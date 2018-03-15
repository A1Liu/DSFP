# FinalProj
Project to make a real life version of MeowMeowBeenz.

### MySQL Info
IP: 192.168.1.5  
Port Number: 3306  
Java Java Java Java Java Java  
Windows Service Name: MYSQL58

### MySQL Package
Start with creating database of users  
* User objects
* Classes to create and execute specific SQL Statement objects
* Class to connect to database
* Classes to connect to server/user
* Classes to create users, send packets of information, etc.

### Network Package
This package will eventually become the format of the working memory of the server.  
The eventual goal is to create an "incomplete" network that stores only the nodes that need to be remembered.  
Everything else will be retrieved and edited in the SQL database as necessary

### SQL DB Plan
Table of Users  
Table of edges  
Server requests info from SQL database, sends edits back to database

### TODO
Add config file support for server package  
Add user file support for user class  
Add admins with extra priveledges  
Add datastructure for ratings system  
Add modular ID confirmation/security features  
Add tons of other stuff

### Reference Links
[I didn't use this but I might in the future](https://github.com/speedment/speedment/wiki/Tutorial:-Build-a-Social-Network)  
[Establishing a connection to the database](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database)  
[Building the database](http://balusc.omnifaces.org/2008/07/dao-tutorial-data-layer.html)
[Establishing a connection to server/client] (http://www.ejbtutorial.com/distributed-systems/hello-world-for-socket-programming-using-java)
