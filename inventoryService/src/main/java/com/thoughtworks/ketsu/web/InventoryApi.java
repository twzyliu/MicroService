package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.store.Store;
import com.thoughtworks.ketsu.infrastructure.repositories.InventoryRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

public class InventoryApi {
    private Store store;

    public InventoryApi(Store store) {
        this.store = store;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info,
                           @Context InventoryRepository inventoryRepository) throws URISyntaxException {
        if (!info.containsKey("inventory_items")) {
            return status(400).build();
        }
        info.put("store_id", store.getId());
        inventoryRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/stores/" + store.getId() + "/inventories/" + info.get("id"))).build() :
                status(400).build();
    }
}
