package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.price.Price;
import com.thoughtworks.ketsu.infrastructure.repositories.PriceRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/prices")
public class PriceApi {
    @Inject
    PriceRepository priceRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        if (!info.containsKey("product_id") || !info.containsKey("price")|| !info.containsKey("user_id")) {
            return status(400).build();
        }
        if (priceRepository.getPrice(info.get("product_id") + "") != null) {
            status(204).build();
        }
        priceRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/prices?product_id=" + info.get("product_id"))).build() :
                status(400).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Price getPrice(@QueryParam("product_id") String product_id) {
        return priceRepository.getPrice(product_id);
    }
}
