package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class OrderApiTest extends ApiSupport{
    @Test
    public void should_return_201_when_post_order_success() throws Exception {
        Map order_item_map = new HashMap() {{
            put("product_id", "001");
            put("quantity", "10");
        }};
        Map order_map = new HashMap() {{
            put("user_id", "007");
            put("name", "Hades");
            put("phone", "999");
            put("address", "home");
            put("amount", 100);
            put("order_items", asList(order_item_map));
        }};
        Response post = post("/orders", order_map);

        assertThat(post.getStatus(), is(201));
    }

}
