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

    @Test
    public void should_return_400_when_post_product_fail() throws Exception {
        Response post = post("/products", new HashMap<>());
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_products_success() throws Exception {
        Response get = session(target("/products").queryParam("user_id", "007").request()).get();
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_200_when_get_product_success() throws Exception {
        Response get = get("/products/1");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_404_when_get_product_fail() throws Exception {
        Response get = get("/products/aaa");
        assertThat(get.getStatus(), is(404));
    }

    @Test
    public void should_return_201_when_put_product_success() throws Exception {
        Response put = put("/products/1", new HashMap() {{
            put("user_id", "007");
            put("name", "pen");
            put("description", "green");
        }});
        assertThat(put.getStatus(), is(201));
    }
}
