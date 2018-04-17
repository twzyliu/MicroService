package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.UnloadingRepository;

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

@Path("/unloadings")
public class UnloadingsApi {
    @Inject
    UnloadingRepository unloadingRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        unloadingRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/unloadings/" + info.get("id"))).build() :
                status(400).build();
    }
}
