package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;

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
}
