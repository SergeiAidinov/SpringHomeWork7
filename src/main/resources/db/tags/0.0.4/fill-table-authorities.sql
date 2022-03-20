--liquibase formatted sql
--changeset sergei:2e5b930f-fba3-4229-a0d6-4240881ecc94
INSERT INTO authorities
VALUES
('Piglet', 'ROLE_ADMIN'),
('Piglet', 'ROLE_USER'),
('Winnie-the-Pooh', 'ROLE_USER');

--rollback DROP TABLE authorities;