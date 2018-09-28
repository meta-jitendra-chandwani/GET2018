drop database springsecurity;
Create database springsecurity;
use springsecurity;

use employee_portal;
drop table user_roles;
create table user_roles(
emp_code int not null,
role varchar(50) not null
);

insert into user_roles(emp_code,role) value(1010,"ROLE_ADMIN"),(1010,"ROLE_USER"),(1011,"ROLE_USER"),(1011,"ROLE_USER"),(1012,"ROLE_USER"),(1013,"ROLE_USER"),(1014,"ROLE_USER");

select * from employee_portal.user_roles;