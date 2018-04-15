insert into orders (user_id, name, phone, address, amount) values ("003", "admin", "12345678901", "home", "666");
insert into order_items (order_id, product_id, quantity) values ("3", "23333", "111");
insert into logistics (order_id, time) values ("3", "2018-04-17 02:49:29.352");
insert into confirmations (order_id, recipient) values ("3", "Yong");