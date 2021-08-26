# Project Scenario – Professor & Course Rating Application (PCRA)

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

At the beginning of every semester, NTU students need to register courses that they want to take. Usually, the deadline of the course registration is the weekend of the week 2. To decide whether to take a course, students can read the course's syllabus, and experience the classes in the first two weeks. However, these may be not enough for students to make a good decision. To know about the professor and his/her course more clearly, additional information from those who have taken the course will be helpful.

The Professor & Course Rating System (PCRA) provide a platform where students can publish their comments and rates on a specific professor and his/her course anonymously. Students can also search the professor or the course by name to browse the comments and rates on the professor or the course. All comments and rates are shown anonymously but students can still change or delete their previous comments and rates. 

The main users of PCRA are Students and Application Administrator (AA).


## Brief Description of Current Processes

### User Register & Login

- 学生可以进行用户注册
- 已注册的用户可以用用户名和密码登录PCRA

### Professor Entry Management

- 由AA从学院网站获取教授信息，录入PCRA后台
- 学生不能自行创建、修改或删除Professor Entry

### Course Entry Management

- 学生可以自行创建Course Entry。学生创建的Course的任课老师必须是Professor Entries中已有的教授
- 学生不能自行删除Course Entry。这样是为了保护条目积累的评论。

### Comments & Rates (C&R) Management

- 学生可以针对教授发布匿名C&R。
- 学生可以针对课程发布匿名C&R。
- 学生可以修改或删除自己发布的任何C&R

### Entries View

- 学生可以在教授库中找到某个教授，进入该教授的详情页，查看详情并浏览教授的C&R
- 学生可以在教授详情页看到教授教的课程，并进入课程详情页浏览课程的C&R
- 学生也可以在课程库中直接找到课程，进入课程详情页，浏览课程的C&R

## Functional Specifications 

### User Register

1. 学生使用此功能。
2. 注册用户需要提供：
   - User Name
   - Email Address
   - Password 

### User Login

1. 学生使用此功能。
2. 登录需要提供：
   - User Name
   - Password

### Professor Entry Creation

1. AA使用此功能
2. AA使用爬虫技术爬取学院官方网站的Faculty介绍，存入数据库
3. 一个教授条目包括：
   - Professor Name
   - Title
   - Email

### Course Entry Creation 
1. 学生使用此功能。
2. 创建课程条目需要提供：
   - Course ID
   - Professor Name
   - Course Name


### Comment and Rate (C&R) on Professor & Course

1. 学生使用此功能。
2. 无论是对教授C&R还是对课程C&R，学生创建C&R需要提供：
   - Rating Score (e.g. 4.5 out of 5)
   - Comment Content
3. 针对教授的C&R在数据库中应当有这些属性：
   - Professor Name
   - Rating Score
   - Comment Content
4. 针对课程的C&R在数据库中应当有这些属性：
   - Course ID
   - Rating Score
   - Comment Content