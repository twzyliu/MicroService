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
public class ConfirmationApiTest extends ApiSupport{
    @Test
    public void should_return_201_when_post_confirmation_success() throws Exception {
        Response post = post("/return_orders/1/confirmation", new HashMap<>());
        assertThat(post.getStatus(), is(201));
    }
}
