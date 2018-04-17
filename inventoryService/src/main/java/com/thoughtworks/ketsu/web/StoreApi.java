package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.StoreRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

@Path("/stores")
public class StoreApi {
    @Inject
    StoreRepository storeRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cteate(Map<String, Object> info) throws URISyntaxException {
        if (!info.containsKey("user_id") || !info.containsKey("name")) {
            return status(400).build();
        }

        storeRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/stores/" + info.get("id"))).build() :
                status(400).build();
    }
}
