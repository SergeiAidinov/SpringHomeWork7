--liquibase formatted sql
--changeset sergei:a4270474-27ff-4b53-b92a-3095789c3ae3

INSERT INTO users
VALUES
('Piglet', '$2a$12$1Souq7N56xS3gRDwjaBGyu9rVjpyHRgqRrDXkrhhPBvnRzVuE9VHW', 1),
('Winnie-the-Pooh', '$2a$12$jLrjXUF1lca1kBGvdsNc0u9OW.wfujFTQiH1ZqWWgDRKGOffqI/Uq', 1);

--rollback DROP TABLE users;