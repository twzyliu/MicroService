package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.unloadIng.Unloading;
import com.thoughtworks.ketsu.infrastructure.repositories.UnloadingRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

@Path("/unloadings")
public class UnloadingsApi {
    @Inject
    UnloadingRepository unloadingRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        if (!info.containsKey("product_id") || !info.containsKey("quantity") || !info.containsKey("pay")) {
            return status(400).build();
        }
        unloadingRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/unloadings/" + info.get("id"))).build() :
                status(400).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Unloading getList() {
        return unloadingRepository.getList();
    }

    @Path("{uid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Unloading getById(@PathParam("uid") String uid) {
        return unloadingRepository.getByid(uid);
    }
}
