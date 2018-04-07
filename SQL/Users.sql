DROP TABLE javabase.user;
DROP TABLE javabase.admins;
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
    rating DECIMAL(6,5) UNSIGNED NOT NULL DEFAULT 1,
    votes DECIMAL(10,5) UNSIGNED NOT NULL DEFAULT 1,
 
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
	FOREIGN KEY (userID1) references user (ID),
    FOREIGN KEY (userID2) REFERENCES user (ID),
	PRIMARY KEY (edgeID)
   );
CREATE TABLE javabase.ratings (
	edgeID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    userID1 BIGINT UNSIGNED NOT NULL,
    userID2 BIGINT UNSIGNED NOT NULL,
    rating INTEGER UNSIGNED NOT NULL,
    
    CONSTRAINT self_ref CHECK (userID1 != userID2),
    
    FOREIGN KEY (userID1) REFERENCES user (ID),
    FOREIGN KEY (userID2) REFERENCES user (ID),
    PRIMARY KEY (edgeID)
);

SELECT * FROM user;
SELECT * FROM admins;
SELECT * FROM passwords;
SELECT * FROM friends;
SELECT * FROM ratings;


INSERT INTO user (username, email, firstname, lastname) VALUES("l","e","rt","ed");
INSERT INTO ratings (userID1,userID2,rating) VALUES (1,1,2);
 

