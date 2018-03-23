# Data Structures and Algorithms Final Project:
#### "MeowMeowBeenz"

## Contents
* [Project Proposal](https://github.com/A1Liu/DSFP/blob/master/Project-Proposal.md#project-proposal)
* [Data Structures](https://github.com/A1Liu/DSFP/blob/master/Project-Proposal.md#data-structures)
* [Roadmap](https://github.com/A1Liu/DSFP/blob/master/Project-Proposal.md#roadmap)
* [References](https://github.com/A1Liu/DSFP/blob/master/Project-Proposal.md#references)

## Project Proposal
The idea for this project comes from the TV show *Community*, in an episode titled "App Development and Condiments". Essentially, this app allows users to rate each other on a 1 to 5 scale. Everyone's rating is public, as are their ratings of others. The catch is that each person's ratings are weighted according to how popular they are. So for instance, a user with a 5 would get more of a vote on other peoples' ratings than someone with a 1. I aim to create this app using a SQL database to store the information; a Java server to handle user requests, access the database, and perform signal-flow graph calculations; and a Java client to send user requests.

## Data Structures
This project will employ multiple data structures to store user information and handle user requests. These include:
* Directed and undirected social graphs
  * Hashtable of nodes
  * LinkedLists of edges for each node
  * Queues for handling breadth-first traversal of the social graph
* A relational database of user information, friendships, and ratings
  * User, password, and edge tables
  * DAO's for all the tables

## Roadmap
1. [ ] **A simple app for making users**
    * [x] Basic database implementation
    * [x] Basic user table and user DAO's
    * [x] Basic password salting and hashing using MD5
    * [ ] Single-thread client-server connection
    * [ ] Multi-thread client-server connection
    * [ ] Full Client-Server-DB integration (Server Logic)
    * [ ] Client UI
    * [ ] Server command prompt
2. [ ] **A simple app for making and friending users**
    * [ ] Database implementation for social graph
    * [ ] DAO's for social graph edges
    * [ ] Network handler to traverse and load social graph
    * [ ] User actions and server logic
    * [ ] User UI
3. [ ] **MeowMeowBeenz**
    * [ ] Database implementation for ratings graph
    * [ ] DAO's for ratings graph
    * [ ] Network handler for ratings graph
    * [ ] Network updater for server-stored ratings graph
    * [ ] User actions and server logic
    * [ ] User UI

## References
These are links that I found that helped me make this app. 
* [**Building a social network server**](https://github.com/speedment/speedment/wiki/Tutorial:-Build-a-Social-Network)  
* [**Establishing a connection to the database**](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database)  
* [**Data Access Objects Explanation**](https://stackoverflow.com/questions/19154202/data-access-object-dao-in-java) - This helped
* [**Data Access Objects Tutorial**](http://balusc.omnifaces.org/2008/07/dao-tutorial-data-layer.html) - This was really helpful for writing the UserDAO. Basically all of my code for the UserDAO and the DAOFactory came from this tutorial, although I messed around with inheritance to try to make it more modular and ended up implementing some of my own interfaces as well.
* [**Establishing a connection to server/client**](http://www.ejbtutorial.com/distributed-systems/hello-world-for-socket-programming-using-java)
* [**What is a signal-flow graph?**](https://en.wikipedia.org/wiki/Signal-flow_graph)
