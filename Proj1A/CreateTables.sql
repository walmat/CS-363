CREATE TABLE students (
	snum int, 
	ssn int, 
	name varchar(10), 
	gender varchar(1), 
	dob datetime, 
	c_addr varchar(20), 
	c_phone varchar(10),
	p_addr varchar(20), 
	p_phone varchar(10), 
	PRIMARY KEY(ssn), 
	unique(snum)
);

CREATE TABLE departments (
	code int, 
	name varchar(50), 
	phone varchar(10), 
	college varchar(20), 
	PRIMARY KEY(code), 
	unique(name)
);

CREATE TABLE degrees (
	name varchar(50), 
	level varchar(5), 
	department_code int, 
	PRIMARY KEY(name, level),
	FOREIGN KEY(department_code) REFERENCES departments(code)
);

CREATE TABLE courses (
	number int, 
	name varchar(50), 
	description varchar(50), 
	credithours int, 
	level varchar(20), 
	department_code int, 
	PRIMARY KEY(number), 
	unique(name), 
	FOREIGN KEY(department_code) REFERENCES departments(code)
);

CREATE TABLE register (
	snum int, 
	course_number int, 
	whenn varchar(20), 
	grade int, 
	PRIMARY KEY(snum, course_number),
	FOREIGN KEY(snum) REFERENCES students(snum),
	FOREIGN KEY(course_number) REFERENCES courses(number)
);

CREATE TABLE major (
	snum int, 
	name varchar(50), 
	level varchar(5), 
	FOREIGN KEY(snum) REFERENCES students(snum),
	FOREIGN KEY(name, level) REFERENCES degrees(name, level),
	PRIMARY KEY(snum, name, level)
);

CREATE TABLE minor (
	snum int,
	name varchar(50),
	level varchar(5),
	FOREIGN KEY(snum) REFERENCES students(snum),
	FOREIGN KEY(name, level) REFERENCES degrees(name, level),
	PRIMARY KEY(snum, name, level)
);