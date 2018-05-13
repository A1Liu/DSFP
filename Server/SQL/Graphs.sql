USE javabase;
DROP TABLE javabase.friends;
DROP TABLE javabase.ratings;

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
