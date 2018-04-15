package com.thoughtworks.ketsu;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class ProductApiTest extends ApiSupport{
    @Test
    public void should_return_201_when_post_product_success() throws Exception {
        Response post = post("/products", new HashMap(){{
            put("user_id", "007");
            put("name", "apple");
            put("description", "red");
        }});
        assertThat(post.getStatus(), is(201));
    }
}
