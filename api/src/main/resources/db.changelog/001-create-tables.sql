-- liquibase formatted sql
-- changeset kull:liqubase run create tables
create type ownership_type as enum ('OUR_PREMISES','PARTNER_COMPANIES');

create type real_estate_type as enum ('WAREHOUSE','OFFICE', 'MANUFACTURING_PLANT', 'POINT_OF_SALE');

create table if not exists country
(
    id  serial primary key,
    title  varchar(100) not null unique
    );


create table if not exists location
(
    id       serial primary key,
    title    varchar(100) not null,
    country_id int not null,
    constraint fk_country
        foreign key (country_id)
             references country (id)
        on UPDATE cascade,
    address varchar(200) not null,
    zip_code varchar(10) not null,
    ownership varchar default 'OUR_PREMISES',
    map_coordinates boolean default false,
    latitude varchar(100),
    longitude varchar(100),
    real_estate varchar,
    deleted boolean default false);
