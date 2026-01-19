CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    user_id BIGINT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_orders_store
        FOREIGN KEY (store_id)
            REFERENCES store(id)
);