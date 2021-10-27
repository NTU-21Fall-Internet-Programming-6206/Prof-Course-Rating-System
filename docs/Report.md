# Development Report of Professor&Course Rating Application

## 1. Project Scenario

At the beginning of every semester, NTU students need to register courses that they want to take. Usually, the deadline of the course registration is the end of week 2. To decide whether to take a course, students can read the course’s syllabus, and experience the classes in the first two weeks. However, these may be not enough for students to make a good decision. To know about the professor and his/her course more clearly, additional information from those who have taken the course will be helpful.

The Professor & Course Rating System (PCRA) provide a platform where students can publish their comments and rates on a specific professor and his/her course anonymously. Students can also search the professor or the course by name to browse the comments and rates on the professor or the course. All comments and rates are shown anonymously but students can still change or delete their previous comments and rates.

The main users of PCRA are Students and Application Administrator (AA).

Features Completed:
Users could register the account through inputting username, password and email address. And they can use existed username and password to sign in.
<img src="/docs/Report_image/login.png" width="50%">
<!-- ![avatar](/docs/Report_image/login.png)![avatar](/docs/Report_image/register.png) -->
In addition, users could create course entry through inputting course ID, course name and name of the professor whose entry has been created in the database.

From dashboard page, users could enter the professors and courses list webpages. All professors' entries and courses' entries are listed in separate pages. Users could click each entry to enter that professor or course specific C&R list page.

In the specific prof or course page, users could read all comments and score on that prof or course.

In some of the webpages, there exist NavBar where users could create their own comments and score for that prof or course, go back to dashboard page and log out.

Finally, we restrict the users' accessible webpages. Before login, users only access login, register pages and can't access the other pages via URL. After login, users could access the content pages and can't access login and register via URL.

## 2. Architecture Design

### 2.1 Entire Architecture

### 2.2 Frontend (React, JavaScript, CSS)
We choose React as the frontend's framework since it is flexible to achieve the designed UI pattern and features. In addition, we choose BrowseRouter to setup the website's route and fetch as the tool to send HTTP requests and receive the responses information. Every webpage we use modular design and each page has its own files directory which is clear and easily distinguished.

### 2.3 Backend (Servlet)
> 昆哥

## 3. DataBase Design


## 4. Setup Guide

### 4.1 Frontend
If the users want to setup the localhost website, they could use terminal to go into our project's frontend code's directory. Then they could use command npm start to setup and enter the localhost website. Besides, we use the command npm run build to obtain the frontend's build directory for deploying the website.

### 4.2 Backend
> 如何产生.war文件 昆哥

### 4.3 Deployment & Run in Cloud Server


## 5. Description of Roles

- Chen Haoyu: took charge of Frontend work and UI design. And I also participated in designing the features of the project.
- Lin Jingkun:
- Wang Mingye: Backend Engineer, SRE