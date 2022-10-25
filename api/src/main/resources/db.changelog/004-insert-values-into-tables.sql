-- liquibase formatted sql
-- changeset kull:liqubase run insert values
insert into contact (first_name,last_name,email,phone) values ('Nikita','Perov','perov@gmail.com','12345678'),
                                                              ('Darina','Fred','fred@gmail.com','54747445'),
                                                              ('Max','Simpson','simpson@gmail.com','885475511');
insert into security_contact (first_name,last_name,email,phone) values ('Bob','Teil','bob@gmail.com','4518754'),
                                                              ('Zuhrad','Jonson','zuh@gmail.com','46662251'),
                                                              ('Larry','Storm','storm@gmail.com','877448844');
insert into reception (fax,phone) values ('7954154','79544155'),('541454','54124111'),('444111255','55544112');


insert into building (location_id, contact_id, security_contact_id, reception_id) VALUES
((select id from location where title='Tartu'),
(select id from contact where phone='12345678'),  (select id from security_contact where phone='4518754'),
    (select id from reception where phone='79544155')),
    ((select id from location where title='London'),
    (select id from contact where phone='54747445'),  (select id from security_contact where phone='46662251'),
    (select id from reception where phone='54124111'));

