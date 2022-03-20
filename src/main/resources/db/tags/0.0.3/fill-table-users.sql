--liquibase formatted sql
--changeset sergei:a4270474-27ff-4b53-b92a-3095789c3ae3

INSERT INTO users
VALUES
('Piglet', '{noop}123', 1),
('Winnie-the-Pooh', '{noop}123', 1);

--rollback DROP TABLE users;