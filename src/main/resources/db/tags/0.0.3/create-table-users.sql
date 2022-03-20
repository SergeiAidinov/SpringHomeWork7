--liquibase formatted sql
--changeset sergei:3e121de1-4a90-4175-9fc1-c41546d15d4e

CREATE TABLE IF NOT EXISTS users (
username varchar(50) NOT NULL,
password varchar(100) NOT NULL,
enabled tinyint(1) NOT NULL,
PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--rollback DROP TABLE users;