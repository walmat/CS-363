SELECT S.snum, S.ssn
FROM students S
WHERE S.name = “Becky”;

SELECT M.name, M.level
FROM students S INNER JOIN major M
ON M.snum = S.snum
WHERE S.ssn = 123097834

SELECT name
FROM courses
WHERE courses.department_code = 401

SELECT degrees.name, degrees.level
FROM degrees
WHERE degrees.department_code = 401

SELECT S.name
FROM students S INNER JOIN minor M
ON Msnum = S.snum; 

SELECT COUNT(*)
FROM students S INNER JOIN minor M
ON M.snum = S.snum;

SELECT S.snum, S.name
FROM register R
	INNER JOIN courses C ON R.course_number = C.number
		INNER JOIN students S ON r.snum
		WHERE C.name = “Algorithm”;

SELECT S.name, S.snum
FROM students S
WHERE (SELECT MIN(S1.dob)
	FROM students S1) = S.dob;

SELECT S.name, S.snum
FROM students S
WHERE (SELECT MAX(S1.dob)
	FROM students S1) = S.dob;

SELECT S.name, S.snum, S.ssn
FROM students S
WHERE NOT (S.name LIKE “%n%” OR S.name LIKE “%N%”);

SELECT C.number, C.name, N.num_students
FROM courses C 
	INNER JOIN (SELECT R.course_number, COUNT(R.course_number) AS num_students
		FROM register R
		GROUP BY R.course_number) AS N
	ON N.course_number = C.number;


SELECT S.name 
FROM students S INNER JOIN register R
ON R.snum = S.snum
WHERE R.when = “Fall2015”;

SELECT C.number, C.name
FROM courses C
WHERE C.department_code = 401;

SELECT C.number, C.name
FROM courses C
WHERE C.department_code = 401 OR C.department_code = 404;

