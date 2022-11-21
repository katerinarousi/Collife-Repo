create database Collife;
use Collife;


CREATE TABLE University( 
	uni_name varchar(15) PRIMARY KEY ,
	location1 varchar(15) NOT NULL )
	
CREATE TABLE Account(
	username varchar(15) PRIMARY KEY,
	email varchar(20) ,
	password1 int NOT NULL ,
	uni_name varchar(15) NOT NULL foreign key references University)
	
CREATE TABLE Message(
        msg_id varchar(6) PRIMARY KEY,
        time_of TIME NOT NULL,
        username varchar(15) NOT NULL foreign key references Account)
	
CREATE TABLE Like( 
	like_id varchar(6) PRIMARY KEY ,
	like_time TIME NOT NULL,
	MSG_id int NOT NULL foreign key references message )	
	
CREATE TABLE Category(
	category_id varchar(6) PRIMARY KEY ,
	category_name varchar(15) NOT NULL )
	
CREATE TABLE Has(
	category_id varchar(6) NOT NULL foreign key references Category,
	uni_name varchar(20) NOT NULL foreign key references University)
	