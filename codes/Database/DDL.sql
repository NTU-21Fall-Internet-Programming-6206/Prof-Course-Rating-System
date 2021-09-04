CREATE DATABASE prof_course_rating_system;

use prof_course_rating_system;

CREATE TABLE Students (
    username VARCHAR(20) NOT NULL, 
    email_address VARCHAR(30) NOT NULL,
    password VARCHAR(64) NOT NULL, 
    salt VARCHAR(64) NOT NULL, 
    PRIMARY KEY (username)
);

CREATE TABLE Professors (
    professor_name VARCHAR(20) NOT NULL, 
    title VARCHAR(20) NOT NULL, 
    email_address VARCHAR(30) NOT NULL,
    PRIMARY KEY (professor_name)
)



