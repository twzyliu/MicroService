CREATE TABLE confirmations (
  id INT PRIMARY KEY AUTO_INCREMENT,
  order_id VARCHAR(255) NOT NULL,
  recipient VARCHAR(255) NOT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);