DROP TABLE IF EXISTS Student;
	
CREATE TABLE Student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fname VARCHAR(250) NOT NULL,
  lname VARCHAR(250) NOT NULL,
  dobirth VARCHAR(250) NOT NULL,
  score int,
  major VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO Student (fname, lname, dobirth, score, major) VALUES
('Robin','Hood','1001980',45,'English'),
('Aaren','Carter','1101980',67,'History'),
('Aarika','Johnson','1201980',89,'Maths'),
('Abagael','Williams','1301980',72,'Physics'),
('Abagail','Jones','1401980',94,'Chemistry');