package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.OrderRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

@Path("/orders")
public class OrderApi {
    @Inject
    OrderRepository orderRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) {
        orderRepository.save(info);
        return status(201).build();
    }
}
