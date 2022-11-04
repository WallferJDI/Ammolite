-- liquibase formatted sql
-- changeset kull:liqubase run insert values
insert into contact (id,first_name,last_name,email,phone) values (1,'Nikita','Perov','perov@gmail.com','12345678'),
                                                              (2,'Darina','Fred','fred@gmail.com','54747445'),
                                                              (3,'Max','Simpson','simpson@gmail.com','885475511');
insert into security_contact (id,first_name,last_name,email,phone) values (1,'Bob','Teil','bob@gmail.com','4518754'),
                                                              (2,'Zuhrad','Jonson','zuh@gmail.com','46662251'),
                                                              (3,'Larry','Storm','storm@gmail.com','877448844');
insert into reception (id,fax,phone) values (1,'7954154','79544155'),(2,'541454','54124111'),(3,'444111255','55544112');


insert into building (id,location_id, contact_id, security_contact_id, reception_id,deleted) VALUES
(1,(select id from location where title='Tallinn'),
(select id from contact where phone='12345678'),  (select id from security_contact where phone='4518754'),
    (select id from reception where phone='79544155'),false),
    (2,(select id from location where title='München'),
    (select id from contact where phone='54747445'),  (select id from security_contact where phone='46662251'),
    (select id from reception where phone='54124111'),false);

