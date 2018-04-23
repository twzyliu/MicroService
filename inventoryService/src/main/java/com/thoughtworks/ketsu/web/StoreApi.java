package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.store.Store;
import com.thoughtworks.ketsu.infrastructure.repositories.StoreRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.*;

public class StoreApi {
    private Store store;

    public StoreApi(Store store) {
        this.store = store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Store getStore() {
        return store;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Map<String, Object> info,
                           @Context StoreRepository storeRepository) throws URISyntaxException {
        if (!info.containsKey("user_id") || !info.containsKey("name")) {
            return status(400).build();
        }
        info.put("store_id", store.getId());
        storeRepository.update(info);
        return created(new URI("/stores/" + store.getId())).build();
    }

    @Path("/inventory")
    public InventoryApi inventoryApi() {
        return new InventoryApi(store);
    }
}
