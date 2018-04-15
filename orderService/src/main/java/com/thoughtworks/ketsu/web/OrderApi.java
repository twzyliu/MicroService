package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
