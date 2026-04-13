# Miscellaneous-2

## Problem1: Sparse Search

Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
                     "practice", "", "", "", "quiz"}
         x = "geeks"
Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
                     "practice", "", "", "", "quiz"},
         x = "ds"
         
Output : -1

## Problem2: Character stream (https://leetcode.com/problems/stream-of-characters/)

## Problem 2: Sum of the products of all possible Subsets

Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

Example :

Input : arr[] = {1, 2, 3}

Output : 23

Possible Subset are: 1, 2, 3, {1, 2}, {1, 3},
                    {2, 3}, {1, 2, 3}

Products of elements in above subsets :
1, 2, 3, 2, 3, 6, 6

Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6
                   = 23

