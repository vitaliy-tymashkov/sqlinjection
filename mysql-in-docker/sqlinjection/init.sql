CREATE USER 'globalaccess_user'@'%' IDENTIFIED BY '789as8asjk';
CREATE USER 'empdb_user'@'%' IDENTIFIED BY '87a98asjhas8';

CREATE DATABASE employees;
USE employees;

GRANT ALL ON employees.* TO 'empdb_user'@'%';
GRANT ALL ON *.* TO 'globalaccess_user'@'%';

CREATE TABLE `employee` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DELIMITER $$
CREATE PROCEDURE `filterByUsernameStoredProcedureUnSafe` (in p_name varchar(1000))
BEGIN
  SET @SQLString = CONCAT("SELECT * FROM employee WHERE name = '", p_name, "'");
  PREPARE test FROM @SQLString;
  EXECUTE test;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `filterByUsernameStoredProcedureSafe`(in p_name varchar(1000))
BEGIN
  SELECT * FROM employee WHERE name = p_name;
END $$
DELIMITER ;

CREATE DATABASE management;
USE management;

CREATE TABLE `employee_review` (
  `id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  `review` varchar(2148) NOT NULL,
  `rating` enum ('1','2','3','4','5') NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO employee_review VALUES (1, 1, 'Good performance', 5);
INSERT INTO employee_review VALUES (2, 2, 'Okay performance', 3);
