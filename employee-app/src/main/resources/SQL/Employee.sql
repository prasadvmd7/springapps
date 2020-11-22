CREATE DATABASE emp_db;

use emp_db;

drop table employee;

CREATE TABLE employee ( 
	EMPLOYEE_ID decimal(6) NOT NULL PRIMARY KEY, 
	FIRST_NAME varchar(30) DEFAULT NULL, 
	LAST_NAME varchar(30) NOT NULL, 
	EMAIL varchar(60) NOT NULL, 
	PHONE_NUMBER decimal(15) DEFAULT NULL, 
	HIRE_DATE date NOT NULL,
	SALARY decimal(10, 3) DEFAULT NULL
);

delete from employee where employee_id=123;

select * from employee;

rollback;

insert into employee(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY) 
values (123, 'MyFirstName', 'MLastName', 'MyEmail@gmail.com', 9090909090, curdate(), 1234.567);

commit;

select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY from employee where EMPLOYEE_ID = 567;

update employee set email='My.Email@gmail.com' where employee_id = 123;

