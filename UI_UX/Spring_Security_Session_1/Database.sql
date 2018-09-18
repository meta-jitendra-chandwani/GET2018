drop database springsecurity;
Create database springsecurity;
use springsecurity;
create table users(
userId int primary key AUTO_INCREMENT,
username varchar(50) not null,
password varchar(100) not null,
enabled BOOLEAN DEFAULT true
);
create table user_roles(
username varchar(50) not null,
role varchar(50) not null
);

insert into users(username,password) value("jitendra","jitendra"),("vaibhav","vaibhav");
insert into user_roles(username,role) value("jitendra","ROLE_ADMIN"),("jitendra","ROLE_USER"),("vaibhav","ROLE_USER");

select * from users;
select * from user_roles;