# 7. Reverse Integer

## Problem
Given a signed 32-bit integer `x`, return `x` with its digits reversed.

If reversing `x` causes the value to go outside the signed 32-bit integer range,
return 0.

## Approach
Extract digits one by one using modulo and build the reversed number.

Handle overflow before updating the result.

## Complexity

Time Complexity: O(log n)  
Space Complexity: O(1)

---

CodeWithIshwar  
Created by Ishwar Chandra Tiwari
