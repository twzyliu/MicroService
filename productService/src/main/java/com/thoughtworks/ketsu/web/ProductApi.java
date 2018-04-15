package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/products")
public class ProductApi {
    @Inject
    ProductRepository productRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        productRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/products/" + info.get("id") + "")).build() :
                status(400).build();
    }
}
