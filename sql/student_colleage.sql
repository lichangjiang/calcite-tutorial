-- sudo docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=changeme -d mysql:5.7

-- MYSQL
CREATE DATABASE test;
USE test;
CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cid BIGINT NOT NULL
);

CREATE TABLE colleage (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- MYSQL
INSERT INTO colleage (name) 
values("mysql_colleage1"),
("mysql_colleage2"),
("mysql_colleage3"),
("mysql_colleage4"),
("mysql_colleage5");

INSERT INTO student (name,cid) 
values("mysql_student1",1),
("mysql_student2",2),
("mysql_student3",3),
("mysql_student4",4),
("mysql_student5",5);

-- sudo docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=changeme -d postgres:11
-- PG
CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cid BIGINT NOT NULL
);

CREATE TABLE colleage (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- pg
INSERT INTO colleage (name) 
values('pg_colleage1'),
('pg_colleage2'),
('pg_colleage3'),
('pg_colleage4'),
('pg_colleage5');

INSERT INTO student (name,cid) 
values('pg_student1',1),
('pg_student2',2),
('pg_student3',3),
('pg_student4',4),
('pg_student5',5);