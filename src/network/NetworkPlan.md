# Plan for the Network

## General Rules for Network

1. The network is a directed graph of nodes that hold 2 values: an integer *r*<sub>*n*</sub> from 1 to 5 inclusive, and a real number *v* > 0
2. All edges between nodes are weighted 1 to 5 inclusive
3. All nodes have an edge directed at itself with a weight of 1
4. The value of *r*<sub>*n*</sub> for each node *n* is the mean of all edges *e*<sub>*1...k*</sub> directed into *n*. Each edge is weighted by the value of *f*(*r*<sub>*m*</sub>,*v*<sub>*m*</sub>)
5. The value of *v*<sub>*n*</sub> for each node *n* is $\sum_{i=1}^{k}t_i$ *f*(*r*<sub>*m*<sub>*1...k*</sub></sub>,*v*<sub>*m*<sub>*1...k*</sub></sub>)
