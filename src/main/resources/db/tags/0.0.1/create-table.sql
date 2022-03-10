--liquibase formatted sql
--changeset sergei:48a51f12-1136-4a38-b9b7-6a6bd4434d2f
CREATE TABLE IF NOT EXISTS products (
id BIGINT AUTO_INCREMENT, 
product_name VARCHAR(45) UNIQUE NOT NULL,
price INT,
PRIMARY KEY (id)
)

--rollback DROP TABLE products;