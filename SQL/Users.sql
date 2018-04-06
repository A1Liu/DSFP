DROP TABLE javabase.user;
DROP TABLE javabase.passwords;
DROP TABLE javabase.friends;
DROP TABLE javabase.ratings;

CREATE TABLE javabase.user (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	username VARCHAR(60) NOT NULL,
	email VARCHAR(60) NOT NULL,
	firstname VARCHAR(40) NULL,
	lastname VARCHAR(40) NULL,
	birthdate DATE NULL,
    rating DECIMAL(6,5) UNSIGNED NOT NULL,
    votes DECIMAL(15,5) UNSIGNED NOT NULL,
 
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (email)
  );
  
CREATE TABLE javabase.admins (
	id BIGINT UNSIGNED NOT NULL,
	email VARCHAR(60) not null,
    first VARCHAR(40) NULL,
    last VARCHAR(40) null,

	PRIMARY KEY (id),
    UNIQUE (email)
);
  
CREATE TABLE javabase.passwords (
	id BIGINT UNSIGNED NOT NULL,
	salt INTEGER UNSIGNED NOT NULL,
	password VARCHAR(32) NOT NULL,
	
	PRIMARY KEY (id)
  );
CREATE TABLE javabase.friends (
	edgeID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    userID1 BIGINT UNSIGNED NOT NULL,
    userID2 BIGINT UNSIGNED NOT NULL,
    
	PRIMARY KEY (edgeID)
   );
CREATE TABLE javabase.ratings (
	edgeID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    userID1 BIGINT UNSIGNED NOT NULL,
    userID2 BIGINT UNSIGNED NOT NULL,
    rating INTEGER UNSIGNED NOT NULL,
    
    PRIMARY KEY (edgeID)
);

SELECT * FROM user;
SELECT * FROM passwords;



