create database if not exists employeedb;
use employeedb;
create table if not exists employee(
id int(6)  auto_increment primary key,
firstname varchar(30) not null,
lastname varchar(30) not null,
age int
)