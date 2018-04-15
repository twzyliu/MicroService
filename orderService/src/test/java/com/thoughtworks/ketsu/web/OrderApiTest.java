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
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RunWith(ApiTestRunner.class)
public class OrderApiTest extends ApiSupport {

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
    public void should_return_201_when_post_order_success() throws Exception {
        String product_id = "001";
        String price = "100";
        String quantity = "10";
        Map price_map = new HashMap() {{
            put("id", "1234567890");
            put("product_id", product_id);
            put("price", price);
        }};
        Map order_item_map = new HashMap() {{
            put("product_id", product_id);
            put("quantity", quantity);
        }};
        Map order_map = new HashMap() {{
            put("user_id", "007");
            put("name", "Hades");
            put("phone", "999");
            put("address", "home");
            put("order_items", asList(order_item_map));
        }};

        String get_body = new Gson().toJson(price_map, Map.class);
        mockClient.when(
                request()
                        .withPath("/prices")
                        .withMethod("GET")
                        .withQueryStringParameter(new Parameter("product_id", product_id))
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(get_body)
        );

        mockClient.when(
                request()
                        .withPath("/unloadings")
                        .withMethod("POST")
                        .withHeader(new Header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                        .withBody("")
        ).respond(
                response()
                        .withStatusCode(201)
                        .withBody("")
        );

        Response post = post("/orders", order_map);

        assertThat(post.getStatus(), is(201));
    }
}
