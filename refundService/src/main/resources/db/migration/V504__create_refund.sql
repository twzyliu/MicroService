CREATE TABLE refunds (
  id INT PRIMARY KEY AUTO_INCREMENT,
  return_order_id VARCHAR(255) NOT NULL,
  amount VARCHAR(255) NOT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);