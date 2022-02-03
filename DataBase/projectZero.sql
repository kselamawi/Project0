 drop table customer ;
create table customer(
customer_Id int primary key,
firstname varchar(30),
lastname varchar(30),
username varchar(30),
password varchar(30),
account_num int,
balance float
);
select *from  customer;

insert into customer values (245,'solomon','kahsai','solomedia','daytonohio',11223344,45000);
insert into customer values (768,'lomon','hagos','lomon@h','daytonohio',12213344,47600);
insert into customer values (001,'Bereket','kahsai','Beri@media','Norway34',33441122,59000);
insert into customer values (256,'Temesege','Haile','temimedia','daytonohio',13344122,590);
select *from customer c ;
update customer set balance =balance -1000 where account_num ='11223344';
select balance from customer where account_num ='11223344';

---- employee table
drop table employee ;
create table employee(
employee_Id varchar(30) primary key,
firstname varchar(30),
lastname varchar(30)
);
insert into employee values('123355','Mark','Anthony');
insert into employee values('331255','John','Smith');
insert into employee values('355123','Solomon','Hagos');
insert into employee values('125533','Ali','Mahommed');

----drop table bank_app ;
create table bankAdmin (
 bankAdmin_Id int primary key,
firtname varchar(30),
lastname varchar(30)

);
truncate table bank_app ;
insert into   bankAdmin values (112233,'mikal','smith');
insert into   bankAdmin values (118733,'John','Mark');
insert into  bankAdmin values (117733,'Ali','Mahammed');
insert into   bankAdmin values (592233,'Henry','Tore');

//---transaction table

----drop table transction 
create table transactional(
transaction_Id int primary key,
transaction_name varchar(30),
employee_Id int references transactional,
customer_Id int references transactional,
bankAdmin_Id int references transactional
);

insert into transactional values(178,'deposite');
insert into transactional values(234,'withdraw');
insert into transactional values(025,'ransfer fund');

