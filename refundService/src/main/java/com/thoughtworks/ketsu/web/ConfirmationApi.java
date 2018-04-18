package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.infrastructure.repositories.ConfirmationRepository;

import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

public class ConfirmationApi {
    private ReturnOrder returnOrder;

    public ConfirmationApi(ReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
    }

    @POST
    public Response create(Map<String, Object> info,
                           @Context ConfirmationRepository confirmationRepository) throws URISyntaxException {
        info.put("return_order_id", returnOrder.getId());
        confirmationRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/return_orders/" + returnOrder.getId() + "/confirmation")).build() :
                status(400).build();
    }
}
