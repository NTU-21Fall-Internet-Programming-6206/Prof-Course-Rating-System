# Project Scenario – Professor & Course Rating Application (PCRA)

> **This Proposal's Webpage**: [https://ntu-21fall-internet-programming-6206.github.io/Professor-Course-Rating-Applicaion/docs/Proposal](https://ntu-21fall-internet-programming-6206.github.io/Professor-Course-Rating-Applicaion/docs/Proposal)</br>
> **This Project's Github Repository**: [https://github.com/NTU-21Fall-Internet-Programming-6206/Professor-Course-Rating-Applicaion/blob/main/docs/Proposal.md](https://github.com/NTU-21Fall-Internet-Programming-6206/Professor-Course-Rating-Applicaion/blob/main/docs/Proposal.md)

- [Project Scenario – Professor & Course Rating Application (PCRA)](#project-scenario--professor--course-rating-application-pcra)
  - [Background](#background)
  - [Brief Description of Current Processes](#brief-description-of-current-processes)
    - [User Register & Login](#user-register--login)
    - [Professor Entry Management](#professor-entry-management)
    - [Course Entry Management](#course-entry-management)
    - [Comments & Rates (C&R) Management](#comments--rates-cr-management)
    - [Entries View](#entries-view)
  - [Functional Specifications](#functional-specifications)
    - [User Register](#user-register)
    - [User Login](#user-login)
    - [Professor Entry Creation](#professor-entry-creation)
    - [Course Entry Creation](#course-entry-creation)
    - [Comment and Rate (C&R) on Professor & Course](#comment-and-rate-cr-on-professor--course)

## Background

At the beginning of every semester, NTU students need to register courses that they want to take. Usually, the deadline of the course registration is the end of week 2. To decide whether to take a course, students can read the course's syllabus, and experience the classes in the first two weeks. However, these may be not enough for students to make a good decision. To know about the professor and his/her course more clearly, additional information from those who have taken the course will be helpful.

***The Professor & Course Rating System (PCRA)*** provide a platform where students can publish their comments and rates on a specific professor and his/her course anonymously. Students can also search the professor or the course by name to browse the comments and rates on the professor or the course. All comments and rates are shown anonymously but students can still change or delete their previous comments and rates. 

The main users of *PCRA* are *Students* and *Application Administrator (AA)*.


## Brief Description of Current Processes

### User Register & Login

- *Students* can register as a user by initializing the username, email address and password.
- The successfully registered user will be authorized to sign in *PCRA* with the corresponding username/email address and password.

### Professor Entry Management

- AAs are responsible for data entry of the professors' information from the school website.
- Students have no authority to create, modify or delete Professor Entry.

### Course Entry Management

- Students are allowed to create Course Entry with the corresponding course professor name.
- In order to reserve C&Rs of a Course Entry, students have no authority to delete it.

### Comments & Rates (C&R) Management

- Students can choose a professor and post the C&R on this professor anonymously.
- Students can choose a course and post the C&R on this course anonymously.
- Students can modify or delete any C&R posted by themselves.

### Entries View

- Students can find a professor in the professor library, access that professor's details webpage, view the details and browse the C&Rs on that professor.
- Students can find which courses were taught by the professor in that professor's details webpage, access the course's details webpage and browse the C&Rs on that course.
- Students can find a course in the course library, access that course's details webpage, view the details and browse C&Rs on that course.

## Functional Specifications

### User Register

1. Students available.
2. When registering a user, the information below is necessary：
   - Username
   - Email Address
   - Password

### User Login

1. Students available.
2. When signing in, the information below is required：
   - Username
   - Password

### Professor Entry Creation

1. Only for AAs.
2. AAs are responsible to store professors' information scrawled from the faculty page on the school website into databases.
3. A professor entry consists of：
   - Professor Name
   - Title
   - Email

### Course Entry Creation

1. This module is used by students.
2. Enable the adding of courses' entries：
   - A typical course entry consists of:
      - Course ID
      - Professor Name
      - Course Name

### Comment and Rate (C&R) on Professor & Course

1. This module is used by students.
2. Enable students to comment and rate on both professor and course.
   - A typical C&R consists of:
      - Rating Score (e.g. 4.5 out of 5)
      - Comment Content
3. Assume that the following information is available in the database.
   - C&R on professors:
      - Professor Name
      - Rating Score
      - Comment Content
   - C&R on courses：
      - Course ID
      - Rating Score
      - Comment Content