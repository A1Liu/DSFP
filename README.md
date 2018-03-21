# FinalProj
Project to make a real life version of MeowMeowBeenz.

## Contents
* [To Do](https://github.com/A1Liu/DSFP/blob/master/README.md#todo)
* [Plan](https://github.com/A1Liu/DSFP/blob/master/README.md#plan)
* [MySQL Info](https://github.com/A1Liu/DSFP/blob/master/README.md#mysql-info)
* [Packages](https://github.com/A1Liu/DSFP/blob/master/README.md#packages)  
  * [DatabaseObjectHandler](https://github.com/A1Liu/DSFP/blob/master/README.md#database-object-handler-package)
  * [MySQL](https://github.com/A1Liu/DSFP/blob/master/README.md#mysql-package)
  * [Network](https://github.com/A1Liu/DSFP/blob/master/README.md#network-package)
  * [Server](https://github.com/A1Liu/DSFP/blob/master/README.md#server-package)
  * [Security](https://github.com/A1Liu/DSFP/blob/master/README.md#security-package)
  * [Users](https://github.com/A1Liu/DSFP/blob/master/README.md#user-package)
* [Reference Links](https://github.com/A1Liu/DSFP/blob/master/README.md#reference-links)

## TODO
* Start learning SQL
* [x] Add config file support for server package  
* Add user file support for user class  
* Add admins with extra priveledges  
* Add datastructure for ratings system  
* Add modular ID confirmation/security features 
* Add App specific network classes and methods
* Add tons of other stuff

## Plan
#### Basics
1. [x] Create User Class with basic fields
2. [x] Create SQL Handler
3. Create connection between server and user
4. [x] Create connection between server and SQL server

#### Friend Network
1. Add classes for user and server package to make and send networks.
2. Add edge table and a way for DAO's to parse through it
3. Use breadth-first traversal to get list of friends and friends' friends, etc.

#### Ratings Network
1. Learn how to implement Signal flow graphs
2. Implement this structure first  
   1. Weight of ratings increases linearly as rating of source increases (maybe rating should be changed according to median?)
   2. Users automatically rate themselves a 5
   3. Users start with 10 ratings of 1, weight of 3, which get replaced by the first 10 ratings they get.
3. Next, implement structure above but change weight of ratings to increase quadratically as rating of source increases. Also, weight should increase for 4's and 5's if standard deviation of ratings is lower, and weight should decrease for 1's and 2's.

## MySQL Info
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

#### Security Package
This package holds the security protocols for the server-user interactions.

#### User Package
This package holds the back-end for the user application. It includes:
* main method
* Classes to handle input from the user
* Classes to handle and respond to packets from the server

## Reference Links
These are links that I found that helped me make this app. Well some of them were useless. But most of them were great.  
* [I didn't use this but I might in the future](https://github.com/speedment/speedment/wiki/Tutorial:-Build-a-Social-Network)  
* [Establishing a connection to the database](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database)  
* [Data Access Objects Explanation](https://stackoverflow.com/questions/19154202/data-access-object-dao-in-java)
* [Data Access Objects Tutorial](http://balusc.omnifaces.org/2008/07/dao-tutorial-data-layer.html)
* [Establishing a connection to server/client](http://www.ejbtutorial.com/distributed-systems/hello-world-for-socket-programming-using-java)
* [What is a signal-flow graph?](https://en.wikipedia.org/wiki/Signal-flow_graph)
