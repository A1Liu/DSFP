# Plan for the Network

## General Rules for Network

1. The network is a directed graph of nodes *n*<sub>1...*k*</sub> that hold 2 values: an integer *r*<sub>*n*<sub>*k*</sub></sub> from 1 to 5 inclusive, and a positive real number *v*<sub>*n*<sub>*k*</sub></sub>
2. Each edge between two distinct nodes is weighted 1 to 5 inclusive
3. Each node has an edge directed at itself with a weight of 1
4. If *m*<sub>1...*k*</sub> is the set of all adjacent nodes to node *n*, and *w*<sub>*k*</sub> denotes the weight of edge (*m*<sub>*k*</sub>,*n*), the value of *r*<sub>*n*</sub> is:  
     *f*(*r*<sub>*m*<sub>1</sub></sub> , *v*<sub>*m*<sub>1</sub></sub>) &times; *w*<sub>1</sub> + *f*(*r*<sub>*m*<sub>2</sub></sub> , *v*<sub>*m*<sub>2</sub></sub>) &times; *w*<sub>2</sub> + ... *f*(*r*<sub>*m*<sub>k</sub></sub> , *v*<sub>*m*<sub>k</sub></sub>) &times; *w*<sub>k</sub>
5. If *m*<sub>1...*k*</sub> is the set of all adjacent nodes to node *n*, then the value of *v*<sub>*n*</sub> is:  
     *f*(*r*<sub>*m*<sub>1</sub></sub> , *v*<sub>*m*<sub>1</sub></sub>) + *f*(*r*<sub>*m*<sub>2</sub></sub> , *v*<sub>*m*<sub>2</sub></sub>) + ... *f*(*r*<sub>*m*<sub>*k*</sub></sub> , *v*<sub>*m*<sub>*k*</sub></sub>)  


## Rules for *f*(*r*<sub>*n*</sub> , *v*<sub>*n*</sub>)
1. *df*/*dr* > 0
2. *df*/*dv* > 0
3. *d*<sup>2</sup>*f*/*dv<sup>2</sup>* < 0
