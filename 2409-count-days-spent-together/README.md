
# 2409. Count Days Spent Together

- **Difficulty:** Easy
- **Topics:** Math, Strings, Intervals
- **Platform:** [LeetCode](https://leetcode.com/problems/count-days-spent-together/)

## Problem Statement

Alice and Bob are traveling to Rome for separate business meetings.

Given four date strings in `MM-DD` format representing their arrival and departure dates, return the total number of days they spend together in Rome.

Both arrival and departure dates are inclusive. All dates belong to the same non-leap year.

## Approach

1. Store the number of days in each month.
2. Convert each date into its corresponding day number in the year.
3. Calculate the overlapping interval using the later arrival date and the earlier departure date.
4. Return the number of overlapping days, or `0` if there is no overlap.

### Formula

```text
start = max(aliceStart, bobStart)
end   = min(aliceEnd, bobEnd)

answer = max(0, end - start + 1)
```

## Java Solution

```java
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int aliceStart = convertToDay(arriveAlice, daysInMonth);
        int aliceEnd = convertToDay(leaveAlice, daysInMonth);
        int bobStart = convertToDay(arriveBob, daysInMonth);
        int bobEnd = convertToDay(leaveBob, daysInMonth);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int convertToDay(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        for (int i = 0; i < month - 1; i++) {
            day += daysInMonth[i];
        }

        return day;
    }
}
```

## Example

**Input**

```text
arriveAlice = "08-15"
leaveAlice  = "08-18"
arriveBob   = "08-16"
leaveBob    = "08-19"
```

**Output**

```text
3
```

**Explanation:** Alice and Bob spend August 16, 17, and 18 together in Rome.

## Complexity Analysis

- **Time Complexity:** O(1) — Each date requires checking at most 11 months.
- **Space Complexity:** O(1) — A fixed-size array stores the days per month.

## Key Takeaway

This problem demonstrates the **interval intersection pattern**, which is useful for calendar scheduling, booking systems, and meeting availability.

For inclusive intervals, the overlap is:

`max(0, min(end1, end2) - max(start1, start2) + 1)`
