package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.store.Store;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
