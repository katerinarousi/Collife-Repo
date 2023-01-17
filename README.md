# Collife - A social network from students to students 

*Collife* allows its user to join a unique community of students all over the country, share their thoughts and communicate with one another.

## Compile the code
To compile the Java program from the source code run *mvn* on the *pom.xml* file.
If you change the source code, you can run tests by executing *mvn install* on the *maven* project.

## Run the program
The app is compatible with the latest version of Java 19. 
In order to run the program from the jar file run *java -jar Collife.jar* 

To run the program from the source code, first please download the file *src* on your computer. 
Then include the .png file *collife_logo.png* on the same path as the file.
Also, include the .db database file *cc_db.db* on the file (same path with the file src). Then, run the program via the main class *MainFinal*.

## Contents of repository
This repository includes this README file, the .png file that contains the logo of our product and a file named *src* that represents the latest version of our code. This file also includes the database file *cc_db.db* at main/resources/cc_db.db, the *pom.xml* file that we created through maven and a .md file standing as the licence for our app.

## Data structures
In order to store the data that our app uses to run, we created a database file (*cc_db.db*) using SQLite.
The database contains of two tables (Users, Messages) that represent the basic entities of our project.

## Instructions of use
When oppening the app the users are met with a window that allows them to *Signup* and then *Login* to the app using their own credentials. 
Once logged in, one can select the *category* of the groupchat they want to join between the options: GENERAL, VOLUNTEER, NIGHTLIFE, TRAVEL, FOOD, UNIVERSITY. 
Then, one can *view the posts - messages* of previous users, *add their own message* or *declare that they like a message* from another user.
Every user can also interact with the manu bar on the top of the app.
In order to logout one can select the option *exit* on the top left corner of the window.

## UML diagram
Below, we cite the UML diagram that describes the class structure of our project.

![Model!ClassDiagram1_1](https://user-images.githubusercontent.com/115362627/212862039-dd2d8ea5-8079-4e2e-935a-f522f0d932c5.jpg)
