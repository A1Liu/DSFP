# Plan for the Network

## General Rules for Network

1. The network is a directed graph of nodes *n*<sub>1...*j*</sub> that holds 2 values: a positive real *r* from 1 to 5 inclusive, and a positive real number *v*
2. Each edge between two distinct nodes is weighted with an integral value 1 to 5 inclusive
3. Each node has an edge directed at itself with a weight of 1
4. If *m*<sub>1...*t*</sub> is the set of all adjacent nodes to node *n*, with *r*<sub>*k*</sub> and *r*<sub>*k*</sub> denoting the values of *r* and *v* for adjacent *m*<sub>*k*</sub>, and *w*<sub>*k*</sub> denotes the weight of edge (*m*<sub>*k*</sub>,*n*), the value of *r*<sub>*n*</sub> is:  
<p style="text-align:center"> ( *f*(*r*<sub>*n*</sub> , *v*<sub>*n*</sub>) + *f*(*r*<sub>1</sub> , *v*<sub>1</sub>) &times; *w*<sub>1</sub> + *f*(*r*<sub>2</sub> , *v*<sub>2</sub>) &times; *w*<sub>2</sub> + ... *f*(*r*<sub>*t*</sub> , *v*<sub>*t*</sub>) &times; *w*<sub>*t*</sub> )/*v*<sub>*n*</sub> </p>
5. If *m*<sub>1...*t*</sub> is the set of all adjacent nodes to node *n*, and *r*<sub>*k*</sub> and *r*<sub>*k*</sub> denote the values of *r* and *v* for adjacent *m*<sub>*k*</sub>, then the value of *v*<sub>*n*</sub> is:  
          *f*(*r*<sub>*n*</sub> , *v*<sub>*n*</sub>) + *f*(*r*<sub>1</sub> , *v*<sub>1</sub>) + *f*(*r*<sub>2</sub> , *v*<sub>2</sub>) + ... *f*(*r*<sub>*t*</sub> , *v*<sub>*t*</sub>)  


<div style="text-align:center">hello!</div>  


## Rules for *f*(*r*<sub>*n*</sub> , *v*<sub>*n*</sub>)
1. *df*/*dr* > 0
2. *df*/*dv* > 0
3. *d*<sup>2</sup>*f*/*dv<sup>2</sup>* < 0

## Task

1. Find function *f*(*r* , *v*) such that the values of *r*<sub>*n*<sub>*k*</sub></sub> and *v*<sub>*n*<sub>*k*</sub></sub> converge for all nodes *n*<sub>1...*j*</sub> of network size *j*
2. Find a breadth-first algorithm that finds the equilibrium values of *r* and *v* for the entire network, given only the edges between nodes and their weights
3. Find a breadth-first algorithm that updates the values of *r* and *v* so that the only nodes that are updated are those that must be for the value of *r* to stay within .1 of the actual equilibrium value of *r* for each node
