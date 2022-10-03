-- liquibase formatted sql
-- changeset kull:liqubase run insert values
insert into country (title) values ('Estonia'),('Germany'),('France');

insert into location (title, country, address, zip_code, ownership,map_coordinates, latitude, longitude, real_estate) VALUES
('Tallinn','Estonia','Jalgpalli tn 1','11312',default,true,'59.437','24.7535','OFFICE'),
('München','Germany','Alfred-Kuehne-Str. 1','85416',default,true,'48.137154','11.576124','WAREHOUSE'),
('Lyon','France','rue Jean Jaures 16','69330',default,true,'45.763420','4.834277','MANUFACTURING_PLANT');
