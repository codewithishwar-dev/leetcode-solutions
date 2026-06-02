# 3633. Earliest Finish Time for Land and Water Rides I

🔗 https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/

## Intuition

A tourist must take exactly one land ride and one water ride.

For every `(land ride, water ride)` pair, there are only two possible orders:

1. Land → Water
2. Water → Land

We calculate the finishing time for both orders and keep track of the minimum possible answer.

---

## Approach

For each pair:

### Land → Water

```text
finishLand = landStartTime[i] + landDuration[i]

finishTime =
max(finishLand, waterStartTime[j])
+ waterDuration[j]
```

### Water → Land

```text
finishWater = waterStartTime[j] + waterDuration[j]

finishTime =
max(finishWater, landStartTime[i])
+ landDuration[i]
```

Update the minimum answer across all combinations.

---

## Complexity Analysis

| Complexity | Value |
|------------|--------|
| Time | O(n × m) |
| Space | O(1) |

---

## Solution (Java)

```java
class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int finishLand = landStartTime[i] + landDuration[i];
                int finishLW = Math.max(finishLand, waterStartTime[j])
                        + waterDuration[j];

                int finishWater = waterStartTime[j] + waterDuration[j];
                int finishWL = Math.max(finishWater, landStartTime[i])
                        + landDuration[i];

                ans = Math.min(ans, Math.min(finishLW, finishWL));
            }
        }

        return ans;
    }
}
```

---

## Key Takeaway

For every land-water pair, evaluate both ride orders and choose the earliest finishing time. Since constraints are small (`n, m ≤ 100`), a brute-force pair enumeration is sufficient.
