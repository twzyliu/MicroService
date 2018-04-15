package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.infrastructure.repositories.PaymentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

public class OrderApi {
    private Order order;

    public OrderApi(Order order) {
        this.order = order;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getById() {
        return order;
    }

    @Path("/payments")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPayment(Map<String, Object> info,
                                  @Context PaymentRepository paymentRepository) throws URISyntaxException {
        info.put("order_id", order.getId());
        paymentRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/orders/" + order.getId() + "/payment")).build() :
                status(400).build();
    }
}
