package com.thoughtworks.ketsu.domain.order;

import java.util.List;

public class Order {
    private String id;
    private String user_id;
    private String name;
    private String phone;
    private String address;
    private List<OrderItem> order_items;
    private String amount;
    private String create_time;
}
