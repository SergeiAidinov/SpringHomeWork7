--liquibase formatted sql
--changeset sergei:484d7617-b086-42db-bdf9-72b5ad804510
INSERT INTO roles (name) VALUES ('USER'), ('ADMIN');

--rollback DROP TABLE roles;