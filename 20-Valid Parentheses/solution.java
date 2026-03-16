/*
Problem: Valid Parentheses
Platform: LeetCode
Difficulty: Easy

Given a string s containing just the characters:
'(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

A string is valid if:
1. Open brackets must be closed by the same type.
2. Open brackets must be closed in the correct order.
*/

import java.util.Stack;

public class Solution {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String input = "()[]{}";

        boolean result = isValid(input);

        System.out.println("Is valid: " + result);
    }
}
