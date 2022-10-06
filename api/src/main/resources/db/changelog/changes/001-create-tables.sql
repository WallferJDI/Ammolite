-- liquibase formatted sql
-- changeset Maksim:liqubase run create tables

create type status as enum ('ACTIVE', 'INACTIVE');

create table if not exists users
(
id serial primary key,
login varchar(50) not null unique,
password_hash varchar(60) not null,
first_name varchar(50),
last_name varchar(50),
email varchar(254) unique,
active boolean not null
);

create table if not exists business_units
(
id serial primary key,
title varchar(50) not null,
description varchar,
start_date timestamp default now() ,
end_date timestamp default null,
status varchar default 'ACTIVE',
created_by int,
    constraint fk_users
    foreign key (created_by)
        references users (id)
);