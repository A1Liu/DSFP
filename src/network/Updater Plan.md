## Task
1. Find a breadth-first algorithm that finds the equilibrium values of *r* and *v* for the entire network, given only the edges between nodes and their weights
2. Find a breadth-first algorithm that updates the values of *r* and *v* so that the only nodes that are updated are those that must be for the value of *r* to stay within .1 of the actual equilibrium value of *r* for each node

## Solution


### Node Significance Rules

1. If *r*<sub>*n*</sub> and *v*<sub>*kn</sub> denote the values of *r* and *v* for node *n* the rating-based significance threshhold for node *n*, *S*<sub>*r*</sub> is:

2. If *r*<sub>*n*</sub> and *v*<sub>*kn</sub> denote the values of *r* and *v* for node *n* the voting power-based significance threshhold for node *n*, *S*<sub>*r*</sub> is:



WIP
  
( *f*(*r*<sub>*n*</sub> , *v*<sub>*n*</sub>) + *f*(*r*<sub>1</sub> , *v*<sub>1</sub>) &times; *w*<sub>1</sub> + *f*(*r*<sub>2</sub> , *v*<sub>2</sub>) &times; *w*<sub>2</sub> + ... *f*(*r*<sub>*t*</sub> , *v*<sub>*t*</sub>) &times; *w*<sub>*t*</sub> )/*v*<sub>*n*</sub>  
