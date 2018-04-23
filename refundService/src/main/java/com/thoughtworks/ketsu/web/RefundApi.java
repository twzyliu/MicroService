package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.refund.Refund;
import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.infrastructure.repositories.RefundRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

public class RefundApi {
    private ReturnOrder returnOrder;

    public RefundApi(ReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info,
                           @Context RefundRepository refundRepository) throws URISyntaxException {
        if (!info.containsKey("amount")) {
            return status(400).build();
        }
        info.put("return_order_id", returnOrder.getId());
        Refund refund = refundRepository.getRefund(returnOrder.getId());
        if (refund != null) {
            return status(204).build();
        }
        refundRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/return_orders/" + returnOrder.getId() + "/refund")).build() :
                status(400).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Refund getRefund(@Context RefundRepository refundRepository) {
        return refundRepository.getRefund(returnOrder.getId());
    }
}
