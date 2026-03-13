# 1. Two Sum

## Problem
Given an array of integers `nums` and an integer `target`,
return indices of the two numbers such that they add up to `target`.

## Approach
Use a HashMap to store previously seen numbers and their indices.

For each number:
- compute the complement `target - nums[i]`
- check if it exists in the map

## Complexity

Time Complexity: O(n)  
Space Complexity: O(n)

---

CodeWithIshwar  
Created by Ishwar Chandra Tiwari
