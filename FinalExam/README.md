# FinalExam: 

## Questions

1. Question 1: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
              An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
              using all the original letters exactly once.

2. Question 2: Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
            An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

3. Question 3: Given a string s of '(' , ')' and lowercase English characters.
            Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.


4. Question 4: You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
            The robot can only move either down or  right at any point in time. An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
            Return the number of possible unique paths that the robot can take to reach the bottom-right corner.



## How to run the code

- For every questions I have create separate packages QuestionX.
- Run main.java class in the packages.

## Complexities

Q1 :
Time complexity : O(N * M) , where N is number of words in strs and M is max length of a word in strs
Space Complexity : O(N)

Q2:
Time Complexity:  O(n*m)
Space Complexity: O(1)

Q3:
Time Complexity: O(n), where n is the length of s
Space Complexity: O(n), where n is length of s

Q4:
Time Complexity: O(N*M)
Space Complexity: O(N*M)


