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
public class ReturnOrderApiTest extends ApiSupport{
    @Test
    public void should_return_201_when_post_returnOrder_success() throws Exception {
        Map return_order_item = new HashMap() {{
            put("return_order_id", "1");
            put("product_id", "1");
            put("quantity", "9");
        }};
        Response post = post("/return_orders", new HashMap(){{
            put("order_id","1");
            put("amount","99");
            put("return_order_items",asList(return_order_item));
        }});
        assertThat(post.getStatus(), is(201));
    }
}
