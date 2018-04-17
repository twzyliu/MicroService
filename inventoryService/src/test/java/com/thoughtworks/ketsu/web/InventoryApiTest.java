package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class InventoryApiTest extends ApiSupport {
    @Test
    public void should_return_201_when_post_inventory_success() throws Exception {
        Map item_map = new HashMap() {{
            put("product_id", "1");
            put("quantity", "1000");
        }};
        Response post = post("/stores/1/inventories", new HashMap() {{
            put("inventory_items", asList(item_map));
        }});
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_post_inventory_fail() throws Exception {
        Response post = post("/stores/1/inventories", new HashMap<>());
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_inventory_success() throws Exception {
        Response get = get("/stores/1/inventories");
        assertThat(get.getStatus(), is(200));
    }
}
