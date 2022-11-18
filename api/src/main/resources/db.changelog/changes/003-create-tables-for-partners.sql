-- liquibase formatted sql
-- changeset Maksim:liqubase run create tables

create table if not exists countries
(
id          serial  primary key,
title       varchar not null unique
);

create table if not exists cities
(
id          serial  primary key,
title       varchar not null
);

create table if not exists web
(
id          serial primary key,
logo_url    varchar,
web_url     varchar,
facebook    varchar
);

create table if not exists addresses
(
id          serial  primary key,
country_id  int     not null,
city        varchar not null,
street      varchar not null,
zip_code    varchar not null,
    constraint fk_countries
        foreign key (country_id)
            references countries (id),

);

create table if not exists companys_data
(
id          serial  primary key,
title       varchar not null,
aka         varchar,
vat_number  varchar not null,
reg_code    varchar not null,
country_id  int     not null,
     constraint fk_countries
        foreign key (country_id)
            references countries (id)
);

create table if not exists contact_persons
(
id          serial primary key,
first_name  varchar,
last_name   varchar,
email       varchar,
phone       varchar,
job_title   varchar,
note        varchar
);

create table if not exists partners
(
id          serial primary key,
data_id     int,
address_id  int,
contact_id  int,
web_id      int,
start_date  timestamp   default now(),
end_date    timestamp   default null,
status      varchar     default 'ACTIVE',
created_by int,
    constraint fk_companys_data
        foreign key (data_id)
            references companys_data (id),
    constraint fk_addresses
            foreign key (address_id)
                references addresses (id),
    constraint fk_contact_persons
            foreign key (contact_id)
                references contact_persons (id),
    constraint fk_web
            foreign key (web_id)
                references web (id),
    constraint fk_users
        foreign key (created_by)
            references users (id)
);