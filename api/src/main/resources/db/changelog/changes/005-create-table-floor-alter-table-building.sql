-- liquibase formatted sql
-- changeset kull:liqubase run create table floor and alter table building

create table if not exists floor
(   id serial primary key,
    floor_number varchar not null,
    real_estate varchar,
    building_id int not null,
    constraint fk_building
        foreign key (building_id)
            references building (id)
            on UPDATE cascade,
    deleted boolean default false);


alter table building
    add real_estate varchar,
    add street varchar;
