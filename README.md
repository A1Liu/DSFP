# FinalProj
Project to make a real life version of MeowMeowBeenz.

## Contents
* [To Do](https://github.com/A1Liu/DSFP/blob/master/README.md#todo)
* [MySQL Info](https://github.com/A1Liu/DSFP/blob/master/README.md#mysql-info)
* [Packages](https://github.com/A1Liu/DSFP/blob/master/README.md#packages)  
  * [DatabaseObjectHandler](https://github.com/A1Liu/DSFP/blob/master/README.md#database-object-handler-package)
  * [MySQL](https://github.com/A1Liu/DSFP/blob/master/README.md#mysql-package)
  * [Network](https://github.com/A1Liu/DSFP/blob/master/README.md#network-package)
  * [Server](https://github.com/A1Liu/DSFP/blob/master/README.md#server-package)
  * [Users](https://github.com/A1Liu/DSFP/blob/master/README.md#user-package)
* [Reference Links](https://github.com/A1Liu/DSFP/blob/master/README.md#reference-links)

## TODO
* Finish general network class
  * finish node network and node class
  * add traversal method
  * start testing network methods
* Start learning SQL
* Add config file support for server package  
* Add user file support for user class  
* Add admins with extra priveledges  
* Add datastructure for ratings system  
* Add modular ID confirmation/security features  
* Add tons of other stuff

### MySQL Info
IP: 192.168.1.5  
Port Number: 3306  
Java Java Java Java Java Java  
Windows Service Name: MYSQL58

## Packages

#### Database Object Handler Package
This package handles SQL statement objects. May be deleted when I flesh out the SQL stuff more.

#### MySQL Package
This package allows the server to communicate with the SQL database. It includes:
* Classes to create and execute specific SQL Statement objects
* Classes to connect to database 
* Classes to traverse SQL tables efficiently

#### Network Package
This package will eventually become the format of the working memory of the server.  
The eventual goal is to create an "incomplete" network that stores only the nodes that need to be remembered.  
Everything else will be retrieved and edited in the SQL database as necessary.

#### Server Package
This package holds the back-end for the server stuff. It uses the network package to format the data it works with to reduce the strain on the java server, and uses the MySQL package to write and send commands to the SQL database. It includes:
* main method
* Classes to handle and respond to packets from users
* Classes to build networks
* Classes to update networks

#### Server Security Package
This package holds the security protocols for the server-user interactions. Still not exactly sure how or if this will be implemented.

#### User Package
This package holds the back-end for the user application. It includes:
* main method
* Classes to handle input from the user
* Classes to handle and respond to packets from the server

## Reference Links
These are links that I found that helped me make this app. Well some of them were useless. But most of them were great.  
* [I didn't use this but I might in the future](https://github.com/speedment/speedment/wiki/Tutorial:-Build-a-Social-Network)  
* [Establishing a connection to the database](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database)  
* [Building the database](http://balusc.omnifaces.org/2008/07/dao-tutorial-data-layer.html)
* [Establishing a connection to server/client](http://www.ejbtutorial.com/distributed-systems/hello-world-for-socket-programming-using-java)
