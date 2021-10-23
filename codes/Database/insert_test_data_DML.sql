insert into Professors
(professor_name, title, email_address)
values
('Alton Chua Yeow Kuan', 'Associate Professor', 'altonchua@ntu.edu.sg'),
('Gerard Goggin', 'Professor', 'gerard.goggin@ntu.edu.sg');

insert into Students (username, email_address, password, salt) values ("a", "b@ntu.edu.sg", "123456", "asdf");

insert into Students (username, email_address, password, salt) values ("B", "asd@ntu.edu.sg", "123456", "asdf");

insert into Professors (professor_name, title, email_address) values ("B", "B", "B", "B");

insert into Courses (course_id, Professor_name, Course_name) values ("B", "B", "B");

insert into CR_on_Course (professor_name, username, course_id, rate, comment) values ("B", "B", "B", 4, "B");

insert into CR_on_professor (professor_name, username, rate, comment) values ("B", "B", 4, "BCD");

insert into token (username, token) values ("a", "asdsdgdffdsg");

insert into token (username, token) values ("B", "dvdkvbksdj");