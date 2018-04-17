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
public class StoreApiTest extends ApiSupport {

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

    @Test
    public void should_return_200_when_get_stores_success() throws Exception {
        Response get = get("/stores");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_200_when_get_store_success() throws Exception {
        Response get = get("/stores/1");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_404_when_get_store_fail() throws Exception {
        Response get = get("/stores/a");
        assertThat(get.getStatus(), is(404));
    }

    @Test
    public void should_return_201_when_put_store_success() throws Exception {
        Response put = put("/stores/1", new HashMap() {{
            put("user_id", "008");
            put("name", "food");
            put("description", "bad");
        }});
        assertThat(put.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_put_store_fail() throws Exception {
        Response put = put("/stores/1", new HashMap<>());
        assertThat(put.getStatus(), is(400));
    }
}
