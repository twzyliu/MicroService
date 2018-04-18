package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

@Path("/users")
public class UsersApi {
    @Inject
    UserRepository userRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        if (!info.containsKey("name")) {
            return status(400).build();
        }
        userRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/users/" + info.get("id"))).build() :
                status(400).build();
    }

    @Path("{uid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("uid") String uid, Map<String, Object> info) throws URISyntaxException {
        if (!info.containsKey("name")) {
            return status(400).build();
        }
        info.put("user_id", uid);
        userRepository.update(info);
        return created(new URI("/users/" + info.get("id"))).build();
    }
}
