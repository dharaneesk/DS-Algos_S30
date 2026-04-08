# Strings-4

## Problem1: Find object in a grid

Given a char grid (o represents an empty cell and x represents a target object) and an API getResponse which would give you a response w.r.t. to your previous position. Write a program to find the object. You can move to any position.

enum Response {
	HOTTER,  // Moving closer to target
	COLDER,  // Moving farther from target
	SAME,    // Same distance from the target as your previous guess
	EXACT;   // Reached destination
}

// Throws an error if 'row' or 'col' is out of bounds
public Response getResponse(int row, int col) {
	// black box
}
Example 1:

Input:
[['o', 'o', 'o'],
 ['o', 'o', 'o'],
 ['x', 'o', 'o']]

Output: [2, 0]
Example 2:

Input:
[['o', 'o', 'o', 'o', 'o'],
 ['o', 'o', 'o', 'o', 'o'],
 ['o', 'o', 'o', 'o', 'o'],
 ['o', 'o', 'o', 'o', 'o'],
 ['o', 'o', 'o', 'x', 'o'],
 ['o', 'o', 'o', 'o', 'o']]

Output: [4, 3]
Assumptions:

There is always one and only one object.
If it's not the target object the 1st call would always give HOTTER as result, ortherwise EXACT.


## Problem2: Atoi (https://leetcode.com/problems/string-to-integer-atoi/)


             
## Problem3: Reorder Log files data (https://leetcode.com/problems/reorder-data-in-log-files/)


