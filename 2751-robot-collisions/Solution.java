import java.util.*;

class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // robot: [position, health, direction, originalIndex]
        int[][] robots = new int[n][4];

        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }

        // Sort robots by position
        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {

            // If moving right → push to stack
            if (robot[2] == 'R') {
                stack.push(robot);
            } else {

                // Resolve collisions with previous 'R' robots
                while (!stack.isEmpty() && stack.peek()[2] == 'R') {

                    int[] top = stack.peek();

                    // Case 1: R survives
                    if (top[1] > robot[1]) {
                        top[1]--;     // reduce R health
                        robot[1] = 0; // L dies
                        break;

                    // Case 2: L survives
                    } else if (top[1] < robot[1]) {
                        robot[1]--;   // reduce L health
                        stack.pop();  // remove R

                    // Case 3: both die
                    } else {
                        stack.pop();
                        robot[1] = 0;
                        break;
                    }
                }

                // If current robot survives, push it
                if (robot[1] > 0) {
                    stack.push(robot);
                }
            }
        }

        // Store surviving robots by original index
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int[] r : stack) {
            result[r[3]] = r[1];
        }

        // Build final answer in original order
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (result[i] != -1) {
                ans.add(result[i]);
            }
        }

        return ans;
    }
}
