CREATE DATABASE q-social;

CREATE TABLE USERS (
	id bigserial not null PRIMARY key,
	name varchar(100) not null,
	age integer not null
);

CREATE TABLE POSTS (
	id bigserial not null PRIMARY key,
	post_text varchar(150) not null,
	date_time timestamp not null,
	user_id bigint not null references USERS(id)
);