CREATE TABLE unloadings (
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_id VARCHAR(255) NOT NULL,
  quantity VARCHAR(255) NOT NULL,
  pay VARCHAR(255) NOT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
