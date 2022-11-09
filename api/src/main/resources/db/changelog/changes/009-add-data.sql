-- liquibase formatted sql
-- changeset Maksim:liqubase run add data

insert into users (login, password_hash, first_name, last_name, email, active)
values ('test1', '123', 'qwe', 'asd', 'test1@test.com', false),
       ('test2', '123', 'rty', 'fgh', 'test2@test.com', true);

insert into business_units (title, description, start_date, end_date, status, created_by)
values ('sole proprietorship', 'One-man business', default, '2023-01-01', default, 1),
        ('Partnership', '', default, null, default, 2);