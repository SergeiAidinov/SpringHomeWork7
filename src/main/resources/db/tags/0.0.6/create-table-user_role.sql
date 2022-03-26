--liquibase formatted sql
--changeset sergei:73292f5c-0c72-45c9-ad0d-d60a4660c9b0
CREATE TABLE IF NOT EXISTS user_role (
user_id BIGINT NOT NULL,
role_id BIGINT NOT NULL
)

--rollback DROP TABLE user_role;