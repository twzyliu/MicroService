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
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RunWith(ApiTestRunner.class)
public class ReturnOrderApiTest extends ApiSupport {
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
    public void should_return_201_when_post_returnOrder_success() throws Exception {
        String order_id = "1";
        String quantity = "9";
        String product_id = "1";

        Map price_map = new HashMap() {{
            put("order_items", "[{\"product_id\":\"" + product_id + "\",\"quantity\":\"" + quantity + "\"}]");
            put("amount", "1");
        }};

        String get_body = new Gson().toJson(price_map, Map.class);
        mockClient.when(
                request()
                        .withPath("/orders/" + order_id)
                        .withMethod("GET")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(get_body)
        );

        Map return_order_item = new HashMap() {{
            put("return_order_id", "1");
            put("product_id", product_id);
            put("quantity", quantity);
        }};
        Response post = post("/return_orders", new HashMap() {{
            put("order_id", order_id);
            put("return_order_items", asList(return_order_item));
        }});
        assertThat(post.getStatus(), is(201));
    }
}
