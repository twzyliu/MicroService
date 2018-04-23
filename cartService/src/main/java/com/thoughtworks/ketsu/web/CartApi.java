package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.thoughtworks.ketsu.domain.cart.Cart;
import com.thoughtworks.ketsu.infrastructure.repositories.CartRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.ketsu.util.HttpClient.doGet;
import static java.lang.Integer.parseInt;
import static java.lang.System.getenv;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/carts")
public class CartApi {
    @Inject
    CartRepository cartRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creat(Map<String, Object> info) throws URISyntaxException {
        List<Map> cart_items = (List<Map>) info.get("cart_items");
        int amount = 0;
        for (Map cart_item : cart_items) {
            String price = getPrice(cart_item);
            if ("-1".equals(price)) {
                return status(400).build();
            }
            amount += parseInt(price) * parseInt(cart_item.get("quantity") + "");
        }
        info.put("amount", amount);
        cartRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/carts/" + info.get("id"))).build() :
                status(400).build();
    }

    @Path("{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCart(@PathParam("cid") String cid) {
        return cartRepository.getCart(cid);
    }

    @Path("{cid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Map<String, Object> info,
                           @PathParam("cid") String cid) throws URISyntaxException {
        info.put("cart_id", cid);
        cartRepository.deleteItems(cid);
        return creat(info);
    }

    private String getPrice(Map cartItem) {
        String host = getenv().getOrDefault("PRICE_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("PRICE_SERVICE_PORT", "23333");
        String price_json = doGet("http://" + host + ":" + port + "/prices?product_id=" + cartItem.get("product_id"));
        Map price_map = new Gson().fromJson(price_json, Map.class);
        return (!"".equals(price_json) && price_map.containsKey("price")) ?
                price_map.get("price") + "" :
                "-1";
    }
}
