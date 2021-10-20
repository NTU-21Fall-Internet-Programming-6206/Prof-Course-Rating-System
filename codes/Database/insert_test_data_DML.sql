insert into Professors
(professor_name, title, email_address)
values
('Alton Chua Yeow Kuan', 'Associate Professor', 'altonchua@ntu.edu.sg'),
('Gerard Goggin', 'Professor', 'gerard.goggin@ntu.edu.sg');

insert into Students (username, email_address, password, salt) values ("a", "b@ntu.edu.sg", "123456", "asdf");x

insert into CR_on_Course (professor_name, username, course_id, rate, comment) values ("B", "B", "B", 4, "B");

insert into CR_on_professor (professor_name, username, rate, comment) values ("B", "B", 4, "BCD");