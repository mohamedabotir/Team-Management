/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Threats
 * Created: Jul 4, 2020
 */

create table user (id int(4) unsigned auto_increment primary key,name varchar(30) not null, password varchar(20) not null,type int(1) not null,index(id));
/*Programmer Table*/
create table Programmer(ID int(3) auto_increment not null primary key,UserID int unsigned not null,comment varchar(250) not null,SubmissionDate DATETIME,file mediumblob,Filename varchar(60) not null,fullname varchar(80) not null,foreign key (UserID) REFERENCES user(id) );
//tester table
create table tester (id int unsigned auto_increment,id_user int unsigned not null,status varchar(15),approveDate date,notes varchar(250),fileid int unsigned,primary key(id),foreign key(id_user) references user(ID),foreign key(fileid) references programmer(id));