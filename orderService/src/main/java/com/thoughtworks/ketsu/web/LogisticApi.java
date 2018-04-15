package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.logistic.Logistic;
import com.thoughtworks.ketsu.infrastructure.repositories.ConfirmationRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

public class LogisticApi {
    private Logistic logistic;

    public LogisticApi(Logistic logistic) {
        this.logistic = logistic;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Logistic getLogistic() {
        return logistic;
    }

    @Path("/confirmation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createConfirmation(Map<String, Object> info,
                                       @Context ConfirmationRepository confirmationRepository) throws URISyntaxException {
        info.put("order_id", logistic.getOrder_id());
        if (!info.containsKey("recipient")) {
            return status(400).build();
        }
        confirmationRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/orders/" + logistic.getOrder_id() + "/logistic/confirmation")).build() :
                status(400).build();
    }
}
