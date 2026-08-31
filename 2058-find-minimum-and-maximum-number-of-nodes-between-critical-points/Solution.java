class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int previous = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        while (curr.next != null) {
            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = position;
                } else {
                    minDistance = Math.min(minDistance, position - previous);
                }

                previous = position;
            }

            prev = curr;
            curr = next;
            position++;
        }

        if (first == -1 || previous == first) {
            return new int[]{-1, -1};
        }

        int maxDistance = previous - first;

        return new int[]{minDistance, maxDistance};
    }
}
