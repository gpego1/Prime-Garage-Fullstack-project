CREATE TABLE car (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     model VARCHAR(100) NOT NULL,
     make VARCHAR(100) NOT NULL,
     price DECIMAL(10,2) NOT NULL,
     fuel_type VARCHAR(50) NOT NULL,

     store_id INT NOT NULL,
     order_id BIGINT,

     CONSTRAINT fk_car_store
         FOREIGN KEY (store_id)
             REFERENCES store(id),

     CONSTRAINT fk_car_order
         FOREIGN KEY (order_id)
             REFERENCES orders(id)
);
