-- liquibase formatted sql
-- changeset kull:liqubase run insert values
insert into country (title) values ('Estonia'),('Germany'),('France');

insert into location (title, country_id, address, zip_code, ownership,map_coordinates, latitude, longitude, real_estate) VALUES
('Tallinn',(select id from country where title='Estonia'),'Jalgpalli tn 1','11312',default,default,'59.437','24.7535','OFFICE'),
('München',(select id from country where title='Germany'),'Alfred-Kuehne-Str. 1','85416',default,default,'48.137154','11.576124','WAREHOUSE'),
('Lyon',(select id from country where title='France'),'rue Jean Jaures 16','69330',default,default,'45.763420','4.834277','MANUFACTURING_PLANT');
