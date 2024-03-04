CREATE DATABASE q-social;

CREATE TABLE USERS (
	id bigserial not null PRIMARY key,
	name varchar(100) not null,
	age integer not null
);