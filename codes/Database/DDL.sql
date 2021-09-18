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
    professor_name VARCHAR(30) NOT NULL, 
    title VARCHAR(20) NOT NULL, 
    email_address VARCHAR(30) NOT NULL,
    PRIMARY KEY (professor_name)
);

CREATE TABLE Courses (
    course_id VARCHAR(10) NOT NULL, 
    professor_name VARCHAR(30) NOT NULL, 
    course_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (course_id), 
    FOREIGN KEY (professor_name) REFERENCES Professors(professor_name)
);


/* CR's rate range: [1, 5], CR's comment length: <= 1000 words */
CREATE TABLE CR_on_Professor (
    auto_id INT NOT NULL AUTO_INCREMENT, 
    professor_name VARCHAR(30) NOT NULL, 
    username VARCHAR(20) NOT NULL, 
    rate INT NOT NULL, 
    comment VARCHAR(1000), 
    PRIMARY KEY (auto_id), 
    FOREIGN KEY (professor_name) REFERENCES Professors(professor_name), 
    FOREIGN KEY (username) REFERENCES Students(username)
);

CREATE TABLE CR_on_Course (
    auto_id INT NOT NULL AUTO_INCREMENT, 
    professor_name VARCHAR(30) NOT NULL, 
    username VARCHAR(20) NOT NULL, 
    course_id VARCHAR(10) NOT NULL, 
    rate INT NOT NULL, 
    comment VARCHAR(1000), 
    PRIMARY KEY (auto_id), 
    FOREIGN KEY (professor_name) REFERENCES Professors(professor_name), 
    FOREIGN KEY (username) REFERENCES Students(username), 
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);