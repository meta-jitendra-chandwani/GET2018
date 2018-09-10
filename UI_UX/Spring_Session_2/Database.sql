drop database employee_portal;
create database employee_portal;

use employee_portal;

create table employee(
  emp_code INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(100) NOT NULL,
  middle_name VARCHAR(100),
  dob DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  primary_contact_number VARCHAR(10),
  secondary_contact_number VARCHAR(10),
  email_id VARCHAR(100) NOT NULL,
  skype_id VARCHAR(100),
  profile_picture VARCHAR(512),
  password VARCHAR(100) NOT NULL,
  skills VARCHAR(25) NOT NULL,
  enable BOOLEAN DEFAULT true
);
Insert into employee
values(
1010,
"Jitendra","Chandwani","1996-08-27",'M',"9782270497","9782270497","jchandwani27896@gmail.com","jitenddra@skype","123456","Jitendr@1996",'Java',true
);
Insert into employee(first_name,middle_name,dob,gender,primary_contact_number,secondary_contact_number,email_id,skype_id,profile_picture,password,skills,enable)
values("Jitendra","Chandwani","1996-08-27",'M',"9782270497","9782270497","jchandwani27896@gmail.com","jitenddra@skype","123456","Jitendr@1996",'Java',true);
    Select * from employee_portal.employee;
  
  select password from employee where emp_code = 1010;
CREATE TABLE job_title_master(
  job_id INT PRIMARY KEY AUTO_INCREMENT,
  job_title VARCHAR(100) NOT NULL
);
Insert into job_title_master value(1010,"ST-2018");

Select * from job_title_master;

CREATE TABLE user_role(
  user_role_id INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(200) NOT NULL,
  role VARCHAR(50) NOT NULL    
);
Select * from user_role;
CREATE TABLE skill_master(
  skill_id INT PRIMARY KEY AUTO_INCREMENT,
  skill_name VARCHAR(100) NOT NULL
);

Select * from skill_master;

CREATE TABLE employee_skill(
  emp_skill_id INT PRIMARY KEY,
  emp_code INT NOT NULL,
  skill_code INT NOT NULL,
  FOREIGN KEY (emp_code)  REFERENCES employee(emp_code),
  FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)
);

Select * from employee_skill;

CREATE TABLE project(
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(50),
  description VARCHAR(200) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE
);
INSERT INTO project(name,description,start_date,end_date) VALUES ('BTLL', 'SImple Calculator', '2018-08-12', '2018-09-02');
Select * from project;
    
CREATE TABLE address(
  address_id INT PRIMARY KEY,
  emp_code INT NOT NULL,
  add_line_1 VARCHAR(100) NOT NULL,
  add_line_2 VARCHAR(100),
  FOREIGN KEY (emp_code) REFERENCES employee(emp_code)
);

Select * from address;
CREATE TABLE job_detail(
  emp_code INT NOT NULL,
  job_detail_id INT PRIMARY KEY AUTO_INCREMENT,
  date_of_joining DATE NOT NULL,
  total_exp INTEGER NOT NULL,
  job_code INT NOT NULL,
  reporting_mgr INT,
  team_lead INT,
  curr_proj_id INT,
  FOREIGN KEY (emp_code) REFERENCES Employee(emp_code),
  FOREIGN KEY (job_code) REFERENCES job_title_master(job_id),
  FOREIGN KEY (reporting_mgr) REFERENCES Employee(emp_code),
  FOREIGN KEY (team_lead) REFERENCES Employee(emp_code),
  FOREIGN KEY (curr_proj_id) REFERENCES project(id)
);
Select * from job_detail;