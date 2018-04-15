package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class LogisticApiTest extends ApiSupport {
    @Test
    public void should_return_200_when_get_logistic_success() throws Exception {
        Response get = get("/orders/2/logistic");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_201_when_post_confirmation_success() throws Exception {
        Response post = post("/orders/2/logistic/confirmation", new HashMap() {{
            put("recipient", "Hades");
        }});
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_post_confirmation_fail() throws Exception {
        Response post = post("/orders/2/logistic/confirmation", new HashMap<>());
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_confirmation_success() throws Exception {
        Response get = get("/orders/3/logistic/confirmation");
        assertThat(get.getStatus(), is(200));
    }
}
