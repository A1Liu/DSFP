DROP TABLE javabase.user;
CREATE TABLE javabase.user (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	username VARCHAR(60) NOT NULL,
	email VARCHAR(60) NOT NULL,
	firstname VARCHAR(40) NULL,
	lastname VARCHAR(40) NULL,
	birthdate DATE NULL,
 
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (email)
       
  );
  
  CREATE TABLE javabase.password (
	id BIGINT UNSIGNED NOT NULL,
	username VARCHAR(60) NOT NULL,
	email VARCHAR(60) NOT NULL,
	salt BIGINT UNSIGNED NOT NULL,
	password VARCHAR(40) NOT NULL,
	
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (email)
  );
  
  SELECT * FROM user;
