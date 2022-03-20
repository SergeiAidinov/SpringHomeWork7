--liquibase formatted sql
--changeset sergei:d8f433ed-a2f9-4b77-8e24-1af42594466c

CREATE TABLE IF NOT EXISTS authorities (
username varchar(50) NOT NULL,
authority varchar(50) NOT NULL,
UNIQUE KEY authorities_idx_1 (username, authority),
CONSTRAINT authorities_ibfk_1
FOREIGN KEY (username)
REFERENCES users (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--rollback DROP TABLE authorities