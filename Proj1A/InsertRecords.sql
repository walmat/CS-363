AL SCHRECK: 2842117

INSERT INTO students values (1001, 654651234, 'Randy', 'M', '2000/12/01', '301 E Hall', '5152700988', '121 Main', '7083066321');
INSERT INTO students values (1002, 123097834, ‘Victor’, 'M', '2000/05/06’, ’270 W Hall', '5151234578’, ‘702 Walnut’, ‘7080366333’);
INSERT INTO students values (1003, 978012431, ‘John’, 'M', ‘1999/07/08’, ‘201W Hall', '5154132805’, ‘888 University’, ‘5152012011’);
INSERT INTO students values (1004, 746897816, ‘Seth’, 'M', ‘1998/12/30’, ‘199 N Hall', ‘5158891504’, '21 Green’, ‘5154132907’);
INSERT INTO students values (1005, 186032894, ‘Nicole’, ‘F’, ‘2001/04/01', ‘178 S Hall', ‘5158891155’, ’13 Gray’, ’5157162071’);
INSERT INTO students values (1006, 534218752, ‘Becky’, ‘F’, ‘2001/05/16’, ’12 N Hall', ‘5157083698’, ‘189 Clark’, ‘2034367632’);
INSERT INTO students values (1007, 432609519, ‘Kevin’, 'M', '2000/08/12’, ’75 E Hall', ‘5157082497’, ’89 National’, ‘7182340772’);

INSERT INTO departments values  (401, ‘Computer Science’, 5152982801, ‘LAS’);
INSERT INTO departments values  (402, ‘Mathematics’,5152982802, ‘LAS’);
INSERT INTO departments values  (403, ‘Chemical Engineering’, 5152982803, ‘Engineering’);
INSERT INTO departments values  (404, ‘Landscape Architect’, 5152982804, ‘Design’);

INSERT INTO degrees values (‘Computer Science’, ‘BS’, 401);
INSERT INTO degrees values (‘Software Engineering’, ‘BS’, 401);
INSERT INTO degrees values (‘Computer Science’, ‘MS’, 401);
INSERT INTO degrees values (‘Computer Science’, ‘PhD’, 401);
INSERT INTO degrees values (‘Applied Mathematics’, ‘MS’, 402);
INSERT INTO degrees values (‘Chemical Engineering’, ‘BS’, 403);
INSERT INTO degrees values (‘Landscape Architect’, ‘BS’, 404);

INSERT INTO major values (1001, ‘Computer Science’, ‘BS’);
INSERT INTO major values (1002, ‘Software Engineering’, ‘BS’);
INSERT INTO major values (1003, ‘Chemical Engineering’, ‘BS’);
INSERT INTO major values (1004, ‘Landscape Architect’, ‘BS’);
INSERT INTO major values (1005, ‘Computer Science’, ‘MS’);
INSERT INTO major values (1006, ‘Applied Mathematics’, ‘MS’);
INSERT INTO major values (1007, ‘Computer Science’, ‘PhD’);

INSERT INTO minor values (1007, ‘Applied Mathematics’, ‘MS’);
INSERT INTO minor values (1005, ‘Applied Mathematics’, ‘MS’);
INSERT INTO minor values (1001, ‘Software Engineering’, ‘BS’);

INSERT INTO courses values (113, ‘Spreadsheet’, ‘Microsoft Excel and Access’, 3, ‘Undergraduate’, 401);
INSERT INTO courses values (311, ‘Algorithm’, ‘Design and Analysis’, 3, ‘Undergraduate’, 401);
INSERT INTO courses values (531, ‘Theory of Computation’, ‘Theorem and Probability’, 3, ‘Graduate’, 401);
INSERT INTO courses values (363, ‘Database’, ‘Design Principle’, 3, ‘Undergraduate’, 401);
INSERT INTO courses values (412, ‘Water Management’, ‘Water Management’, 3, ‘Undergraduate’, 404);
INSERT INTO courses values (228, ‘Special Topics’, ‘Interesting Topics about CE’, 3, ‘Undergraduate’, 403);
INSERT INTO courses values (101, ‘Calculus’, ‘Limit and Derivative’, 4, ‘Undergraduate’, 402);

INSERT INTO register values (1001, 363, ‘Fall2015’, 3);
INSERT INTO register values (1002, 311, ‘Fall2015’, 4);
INSERT INTO register values (1003, 228, ‘Fall2015’, 4);
INSERT INTO register values (1004, 363, ‘Spring2015’, 3);
INSERT INTO register values (1005, 531, ‘Spring2015’, 4);
INSERT INTO register values (1006, 363, ‘Fall2015’, 3);
INSERT INTO register values (1007, 531, ‘Spring2015’, 4);