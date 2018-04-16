CREATE TABLE prices (
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_id VARCHAR(255) NOT NULL,
  price VARCHAR(255) NOT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);