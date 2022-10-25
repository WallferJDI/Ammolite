-- liquibase formatted sql
-- changeset kull:liqubase run create tables contact,security_contact_reception,building

create table if not exists contact
(
    id  serial primary key,
    first_name  varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(100) not null,
    phone varchar(100) not null
    );

create table if not exists security_contact
(
    id  serial primary key,
    first_name  varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(100) not null,
    phone varchar(100) not null
    );

create table if not exists reception
(
    id  serial primary key,
    phone varchar(100) not null,
    fax varchar(100) not null
    );

create table if not exists building
(   id serial primary key,
    location_id int not null,
    constraint fk_location
        foreign key (location_id)
            references location (id)
            on UPDATE cascade,
    contact_id int not null,
    constraint fk_contact
        foreign key (contact_id)
             references contact (id)
        on UPDATE cascade,
    security_contact_id int not null,
    constraint fk_security_contact
    foreign key (security_contact_id)
    references security_contact (id)
        on UPDATE cascade,
    reception_id int not null,
    constraint fk_reception
    foreign key (reception_id)
    references reception (id)
        on UPDATE cascade);
