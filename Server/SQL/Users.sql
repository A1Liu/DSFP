/*\. code/java/dsfp/server/SQL/Users.sql*/
USE javabase;
DROP TABLE javabase.passwords;
DROP TABLE javabase.users;

CREATE TABLE javabase.users (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	username VARCHAR(60) NOT NULL,
	email VARCHAR(60) NOT NULL,
	name VARCHAR(40) NULL,
	birthdate DATE NULL,
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (email)
  );

CREATE TABLE javabase.passwords (
	id BIGINT UNSIGNED NOT NULL,
	salt INTEGER UNSIGNED NOT NULL,
	password VARCHAR(32) NOT NULL,

	FOREIGN KEY (id) references users (id),
	PRIMARY KEY (id)
  );
/*
	INSERT INTO user (username, email, firstname, lastname) VALUES("l","e","rt","ed");
	INSERT INTO passwords (id, salt,password) VALUES(1,12,"hello");*/
