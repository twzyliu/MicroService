package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.confirmation.Confirmation;
import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.infrastructure.repositories.ConfirmationRepository;
import com.thoughtworks.ketsu.infrastructure.repositories.RefundRepository;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

public class ConfirmationApi {
    private ReturnOrder returnOrder;

    public ConfirmationApi(ReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
    }

    @POST
    public Response create(Map<String, Object> info,
                           @Context ConfirmationRepository confirmationRepository,
                           @Context RefundRepository refundRepository) throws URISyntaxException {
        String rid = returnOrder.getId();
        if (refundRepository.getRefund(rid) == null) {
            return status(400).build();
        }
        info.put("return_order_id", this.returnOrder.getId());
        confirmationRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/return_orders/" + this.returnOrder.getId() + "/confirmation")).build() :
                status(400).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Confirmation getConfirmation(@Context ConfirmationRepository confirmationRepository) {
        return confirmationRepository.getConfirmation(returnOrder.getId());
    }

}
