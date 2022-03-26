--liquibase formatted sql
--changeset sergei:2f795e4a-6ef1-404b-b6d6-b7f30de2c29d
CREATE TABLE IF NOT EXISTS roles (
id BIGINT AUTO_INCREMENT,
name VARCHAR(45) UNIQUE NOT NULL,
PRIMARY KEY (id)
)

--rollback DROP TABLE roles;