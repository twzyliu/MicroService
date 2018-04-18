package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ReturnOrderApi {
    private ReturnOrder returnOrder;

    public ReturnOrderApi(ReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnOrder getById() {
        return returnOrder;
    }

    @Path("/refund")
    public RefundApi refundApi() {
        return new RefundApi(returnOrder);
    }

    @Path("/confirmation")
    public ConfirmationApi confirmationApi() {
        return new ConfirmationApi(returnOrder);
    }
}
