-- liquibase formatted sql
-- changeset kull:liqubase run insert values

insert into floor (floor_number,real_estate,building_id) values ('1','WAREHOUSE',(select id from building where id=1)),('2','OFFICE',(select id from building where id=1)),
                                                                ('1','MANUFACTURING_PLANT',(select id from building where id=2)),('2','OFFICE',(select id from building where id=2));

update building b set street=address from location l where b.location_id=l.id;

update building b set real_estate=l.real_estate from location l where b.location_id=l.id;