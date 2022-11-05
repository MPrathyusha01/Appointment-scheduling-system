create database appointment_system;
# drop database appointment_system;
use appointment_system;

create table patient(
user_id bigint primary key,
user_name varchar(30) not null,
patient_name varchar(40) not null,
address varchar(40)not null,
password varchar(30) not null,
user_email varchar(30) not null,
phone_no varchar(30) not null,
dob date not null,
gender enum("male","female","others")
);

insert into  patient values
(1001,'Rohit123','Rohit','10th Mile','rohit@123','rohit@gmail','78646578','2000-04-24','male'),
(1002,'Rahul123','Rahul','near Tajhotel','rahul@123','rahul@gmail','88566578','2001-06-27','male'),
(1003,'Shreya123','Shreya','8th mile','Shreya@123','Shreya@gmail','77645578','2000-07-14','female');

create table doctor (
doctor_id bigint primary key,
doctor_name varchar(30) not null,
specialization varchar(40) not null,
consultant enum("online","inPerson"),
fee int not null
);

insert into doctor values
(2001,'Bikash','ENT','online',500),
(2002,'Akash','Cardiac','inPerson',700),
(2003,'Sneha','Dermatology','online',550);

# drop table Appointment;
create table Appointment(
appointment_id bigint  primary key,
appointment_date datetime not null,
appointment_status enum("Accept","Reject"),
user_id bigint,
foreign key(user_id) references patient(user_id),
doctor_id bigint,
foreign key(doctor_id) references doctor(doctor_id) 
);

insert into Appointment values
(3001,'2022-10-24 13:12:55','Accept',1001, 2001),
(3002,'2022-10-26 10:07:22','Reject',1002, 2002),
(3003,'2022-10-28 16:54:44','Accept',1003, 2001);

create table admin(
admin_id bigint primary key,
admin_name varchar(30)  not null,
Password varchar(30) not null
);

insert into admin values
(001, 'admin', 'admin@123');


create table login (
loginid bigint primary key,
id varchar(30) not null,
password varchar(30) not null,
role enum("admin","user")
);

insert into login values
(1,1001, 'rohit@123', 'user'),
(2,1002, 'rahul@123', 'user'),
(3,1003, 'Shreya@123', 'user'),
(4,001, 'admin@123', 'admin');

select * from admin;
select * from appointment;
select * from doctor;
select * from login;
select * from patient;
