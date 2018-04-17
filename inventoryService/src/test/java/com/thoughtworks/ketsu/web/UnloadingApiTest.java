package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UnloadingApiTest extends ApiSupport {
    @Test
    public void should_return_201_when_post_inventory_unloading_success() throws Exception {
        Response post = post("/unloadings", new HashMap() {{
            put("product_id", "1");
            put("quantity", "99");
            put("pay", "0");
        }});
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_post_inventory_unloading_fail() throws Exception {
        Response post = post("/unloadings", new HashMap<>());
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_inventory_unloadings_success() throws Exception {
        Response get = get("/unloadings");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_200_when_get_inventory_unloading_success() throws Exception {
        Response get = get("/unloadings/1");
        assertThat(get.getStatus(), is(200));
    }
}
