INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Admin', 'Istrator', '$2a$10$Y3EfZu1oGD2d4pyyU16R6e9e7Rv8Ymy8zE1yntdx/Dykhbbg38aDa', 'admin', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'ADMIN')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('admin', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Susi', 'Kaufgern', '$2a$10$Y3EfZu1oGD2d4pyyU16R6e9e7Rv8Ymy8zE1yntdx/Dykhbbg38aDa', 'user1', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'MANAGER')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user1', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Max', 'Mustermann', '$2a$10$Y3EfZu1oGD2d4pyyU16R6e9e7Rv8Ymy8zE1yntdx/Dykhbbg38aDa', 'user2', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user2', 'PILOT')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user2', 'EMPLOYEE')
INSERT INTO USER (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE) VALUES(TRUE, 'Klaus', 'Kleber', '$2a$10$Y3EfZu1oGD2d4pyyU16R6e9e7Rv8Ymy8zE1yntdx/Dykhbbg38aDa', 'user3', 'admin', '2016-01-01 00:00:00')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user3', 'CABINSTAFF')
INSERT INTO USER_USER_ROLE (USER_USERNAME, ROLES) VALUES ('user3', 'EMPLOYEE')

