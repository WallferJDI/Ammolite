-- liquibase formatted sql
-- changeset kull:liqubase run create table work_area and insert data into table

create table if not exists work_area
(   id serial primary key,
    room_number varchar not null,
    real_estate varchar,
    floor_id int not null,
    constraint fk_floor
        foreign key (floor_id)
            references floor (id)
            on UPDATE cascade,
    deleted boolean default false);


insert into work_area (room_number,real_estate,floor_id) values ('1','WAREHOUSE',(select id from floor where id=9)),('2','OFFICE',(select id from floor where id=9)),
                                                                ('1','OFFICE',(select id from floor where id=10)),('2','OFFICE',(select id from floor where id=10));

