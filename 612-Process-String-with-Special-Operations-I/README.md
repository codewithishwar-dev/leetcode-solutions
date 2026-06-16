# 3612. Process String with Special Operations I

## Approach

We simulate the operations from left to right using a `StringBuilder`.

* If the current character is a lowercase letter, append it to the result.
* `*` removes the last character if the result is not empty.
* `#` duplicates the current result by appending it to itself.
* `%` reverses the current result.

Since the input length is at most 20, direct simulation is sufficient.

## Complexity Analysis

* **Time Complexity:** O(n), where n is the size of the generated string.
* **Space Complexity:** O(n)

## Java Solution

```java
class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append(c);
            } else if (c == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (c == '#') {
                result.append(result.toString());
            } else if (c == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}
```
