create database Collife;
use Collife;
CREATE TABLE Account(
	username varchar(15) NOT NULL PRIMARY KEY,
	email varchar(20) NOT NULL,
	password int NOT NULL ,
	uni_name varchar(15) NOT NULL foreign key references University ,
	department_id int NOT NULL foreign key references Department)
	
CREATE TABLE Post(
	post_id int NOT NULL PRIMARY KEY ,
	username varchar(15) NOT NULL FOREIGN KEY references Account ,
	description varchar(30) ,
	hour int NOT NULL ,
	date varchar() NOT NULL )
	
CREATE TABLE Category(
	category_id int NOT NULL PRIMARY KEY ,
	category_name varchar(15) NOT NULL )
	
CREATE TABLE Like( 
	like_id int NOT NULL PRIMARY KEY ,
	username varchar(15) NOT NULL foreign key references Account,
	hour int NOT NULL ,
	date varchar() NOT NULL ,
	post_id int NOT NULL foreign key references Post )
	
CREATE TABLE Comment(
	comment_id int NOT NULL PRIMARY KEY ,
	username varchar(15) NOT NULL foreign key references Account,
	hour int NOT NULL ,
	date varchar() NOT NULL ,
	post_id int NOT NULL foreign key references Post )
	
CREATE TABLE University( 
	uni_name varchar(15) NOT NULL PRIMARY KEY ,
	location varchar(15) NOT NULL )
	
CREATE TABLE Department(
	department_id int NOT NULL PRIMARY KEY,
	department_name varchar(15) NOT NULL )
	
CREATE TABLE Categorized_in(
	category_id int NOT NULL foreign key references Category,
	post_id int NOT NULL foreign key references Post )

	