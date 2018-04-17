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
public class InventoryApiTest extends ApiSupport {

    @Test
    public void should_return_201_when_post_store_success() throws Exception {
        Response post = post("/stores", new HashMap() {{
            put("user_id", "007");
            put("name", "shop");
            put("description", "good");
        }});
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_post_store_fail() throws Exception {
        Response post = post("/stores", new HashMap<>());
        assertThat(post.getStatus(), is(400));
    }
}