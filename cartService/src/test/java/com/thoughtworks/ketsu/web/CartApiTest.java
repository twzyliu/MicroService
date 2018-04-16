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
public class CartApiTest extends ApiSupport {
    @Test
    public void should_return_201_when_post_cart_success() throws Exception {
        Map cart_item = new HashMap() {{
            put("product_id", "1");
            put("quantity", "10");
        }};
        Response post = post("/carts", new HashMap() {{
            put("user_id", "007");
            put("amount", "10000");
            put("cart_items", asList(cart_item));
        }});
        assertThat(post.getStatus(), is(201));
    }
}
