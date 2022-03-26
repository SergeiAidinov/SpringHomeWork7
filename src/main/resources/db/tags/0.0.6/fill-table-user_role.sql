--liquibase formatted sql
--changeset sergei:58d61db4-9102-43ba-9ef0-ef0d7c9059d2
INSERT INTO user_role (user_id, role_id) VALUES (1,1), (2,2);

--rollback DROP TABLE user_role;