insert into orders (user_id, name, phone, address, amount) values ("002", "admin", "12345678901", "home", "11111");
insert into order_items (order_id, product_id, quantity) values ("2", "12345", "1");
insert into payments (order_id, pay_type) values ("2", "wechat");