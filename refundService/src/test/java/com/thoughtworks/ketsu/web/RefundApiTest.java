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
public class RefundApiTest extends ApiSupport{
    @Test
    public void should_return_201_when_post_refund_success() throws Exception {
        Response post = post("/return_orders/1/refunds", new HashMap(){{
            put("amount","90");
            put("return_order_id","90");
        }});
        assertThat(post.getStatus(), is(201));
    }
}
