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
create table Programmer(ID int(3) auto_increment not null primary key,UserID int unsigned not null,comment varchar(250) not null,SubmissionDate DATE,file mediumblob,Filename varchar(60) notnull,foreign key (UserID) REFERENCES user(id) );