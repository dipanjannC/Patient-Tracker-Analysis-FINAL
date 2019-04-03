create database paitent_tracker_analysisdb;
use paitent_tracker_analysisdb;


create table admin
(
    admin_id bigint(10) primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    age int(3) not null,
    gender varchar(10) not null,
    dob varchar(10) not null,
    contact_number bigint(10) not null,
    alternate_contact_number bigint(10),
    email_id varchar(50) not null,
    password varchar(15) not null
);

insert into admin(first_name,last_name,age,gender,dob,contact_number,alternate_contact_number,email_id,password) values('Pratik','Pritam',22,'Male','26-11-1998',9798894106,9112523953,'pratikpriam347@gmail.com','abcd');
insert into admin values();
insert into admin values();
insert into admin values();

alter table admin auto_increment=1001;
select * from admin;
drop table admin;



create table clerk
(
   clerk_id bigint(10) primary key not null auto_increment ,
   first_name varchar(50) not null,
   last_name varchar(50) not null,
   age int(2) not null,
   gender varchar(10),
   dob varchar(10),
   contact_number bigint(10) not null,
   alternate_contact_number bigint(10),
   email_id varchar(50) not null,
   address_line_1 varchar(100) not null,
   address_line_2 varchar(100) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   zip_code int(10) not null
);

 insert into clerk values();
 insert into clerk values();
 insert into clerk values();
 insert into clerk values();

alter table clerk auto_increment=1001;
select * from clerk;
drop table clerk;
desc clerk;



create table doctor
(
   doctor_id bigint primary key auto_increment, 
   first_name varchar(50),
   last_name varchar(50),
   age int(2),
   gender varchar(10),
   dob varchar(10),
   contact_number bigint(10),
   alternate_contact_number bigint(10),
   email_id varchar(50),
   address_line_1 varchar(50),
   address_line_2 varchar(50),
   city varchar(50),
   state varchar(50),
   zip_code int(10),
   degree varchar(50),
   speciality varchar(50),
   work_hours varchar(50),
   hospital_name varchar(100)
);

insert into doctor values();
insert into doctor values();
insert into doctor values();
insert into doctor values();

alter table doctor auto_increment=1001;
select * from doctor;
drop table doctor;



create table patient
(
   patient_id bigint primary key auto_increment,
   first_name varchar(50),
   last_name varchar(50),
   age int,
   gender varchar(10),
   dob varchar(10),
   contact_number bigint,
   alternate_contact_number bigint,
   email_id varchar(50),
   address_line_1 varchar(100),
   address_line_2 varchar(100),
   city varchar(50),
   state varchar(50),
   zip_code varchar(10)
 );
 
insert into patient values();
insert into patient values();
insert into patient values();
insert into patient values();


alter table patient auto_increment=1001;
select * from patient;
drop table patient;




create table medicine
(
   medicine_id bigint(8) primary key auto_increment,
   medicine_description varchar(200) not null,
   cure_for varchar(50) not null,
   manufacturing_company varchar(50) not null,
   dosage int(3) not null,
   prescribed_for varchar(1) not null,
   amount int(6) not null
);

insert into medicine values();
insert into medicine values();
insert into medicine values();
insert into medicine values();

drop table medicine;

alter table medicine auto_increment=1001;
select * from medicine;


create table prescription
(
   request_id bigint primary key auto_increment,
   patient_id int references patient(patient_id),
   doctor_id int references doctor(doctor_id),
   request_date date,
   medicine_id_1 int references medicine(medicine_id),
   quantity_1 int,
   medicine_id__2 int references medicine(medicine_id),
   quantity_2 int,
   medicine_id_3 int references medicine(medicine_id),
   quantity_3 int,
   medicine_id_4 int references medicine(medicine_id),
   quantity_4 int,
   medicine_id_5 int references medicine(medicine_id),
   quantity_5 int,
   other_info varchar(200),
   status varchar(1)
);

insert into prescription values();
insert into prescription values();
insert into prescription values();
insert into prescription values();

drop table prescription;
desc prescription;
alter table prescription auto_increment=1001;
select * from prescription;


create table bill 
 (
   bill_id bigint primary key auto_increment,
   patient_id int not null,
   doctor_id int not null,
   bill_date date not null,
   medicine_id_1 int not null,
   quantity_1 int(3) not null,
   amount_1 double not null,
   medicine_id_2 int,
   quantity_2 int(3),
   amount_2 double,
   medicine_id_3 int,
   quantity_3 int(3),
   amount_3 double,
   medicine_id_4 int,
   quantity_4 int(3),
   amount_4 double,
   medicine_id_5 int,
   quantity_5 int(3),
   amount_5 double,
   total_amount double not null,
   foreign key (patient_id) references patient(patient_id),
   foreign key (doctor_id) references doctor(doctor_id)
);

desc bill;

insert into bill values();
insert into bill values();
insert into bill values();
insert into bill values();

drop table bill;

alter table bill auto_increment=1001;
select * from bill;