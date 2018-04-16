package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RunWith(ApiTestRunner.class)
public class CartApiTest extends ApiSupport {
    private MockServerClient mockClient;

    @Rule
    public MockServerRule server = new MockServerRule(this, 23333);

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        mockClient = new MockServerClient("127.0.0.1", 23333);
    }

    @Test
    public void should_return_201_when_post_cart_success() throws Exception {
        String product_id = "1";
        Map price_map = new HashMap() {{
            put("price", "9");
            put("product_id", product_id);
        }};

        String get_body = new Gson().toJson(price_map, Map.class);
        mockClient.when(
                request()
                        .withPath("/prices")
                        .withQueryStringParameter("product_id", product_id)
                        .withMethod("GET")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(get_body)
        );

        Map cart_item = new HashMap() {{
            put("product_id", product_id);
            put("quantity", "10");
        }};
        Response post = post("/carts", new HashMap() {{
            put("user_id", "007");
            put("cart_items", asList(cart_item));
        }});
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_post_cart_fail() throws Exception {
        String product_id = "1";
        mockClient.when(
                request()
                        .withPath("/prices")
                        .withQueryStringParameter("product_id", product_id)
                        .withMethod("GET")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody("")
        );

        Map cart_item = new HashMap() {{
            put("product_id", product_id);
            put("quantity", "10");
        }};
        Response post = post("/carts", new HashMap() {{
            put("user_id", "007");
            put("cart_items", asList(cart_item));
        }});
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_cart() throws Exception {
        Response get = get("/carts/1");
        assertThat(get.getStatus(), is(200));
    }

    @Test
    public void should_return_201_when_put_cart_success() throws Exception {
        String product_id = "1";
        Map price_map = new HashMap() {{
            put("price", "999");
            put("product_id", product_id);
        }};

        String get_body = new Gson().toJson(price_map, Map.class);
        mockClient.when(
                request()
                        .withPath("/prices")
                        .withQueryStringParameter("product_id", product_id)
                        .withMethod("GET")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(get_body)
        );

        Map cart_item = new HashMap() {{
            put("product_id", product_id);
            put("quantity", "1000");
        }};

        Response put = put("/carts/1",new HashMap() {{
            put("user_id", "007");
            put("cart_items", asList(cart_item));
        }});
        assertThat(put.getStatus(), is(201));
    }

    @Test
    public void should_return_400_when_put_cart_fail() throws Exception {
        String product_id = "1";
        mockClient.when(
                request()
                        .withPath("/prices")
                        .withQueryStringParameter("product_id", product_id)
                        .withMethod("GET")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody("")
        );

        Map cart_item = new HashMap() {{
            put("product_id", product_id);
            put("quantity", "1000");
        }};

        Response put = put("/carts/1",new HashMap() {{
            put("user_id", "007");
            put("cart_items", asList(cart_item));
        }});
        assertThat(put.getStatus(), is(400));
    }
}










