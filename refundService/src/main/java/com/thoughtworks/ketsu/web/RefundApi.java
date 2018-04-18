package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.infrastructure.repositories.RefundRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
        if (!info.containsKey("amount") || !info.containsKey("return_order_id")) {
            return status(400).build();
        }
        refundRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/return_orders/" + returnOrder.getId() + "/refunds")).build() :
                status(400).build();
    }
}
