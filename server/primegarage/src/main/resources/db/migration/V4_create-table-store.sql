CREATE TABLE store (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address_id INT NOT NULL,
    CONSTRAINT fk_store_address
        FOREIGN KEY (address_id)
            REFERENCES address(id)
)