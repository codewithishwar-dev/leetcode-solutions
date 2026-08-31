class Solution:
    def nodesBetweenCriticalPoints(self, head):
        first = -1
        previous = -1
        min_distance = float("inf")

        prev = head
        curr = head.next

        position = 1

        while curr.next:
            next_node = curr.next

            if ((curr.val > prev.val and curr.val > next_node.val) or
                (curr.val < prev.val and curr.val < next_node.val)):

                if first == -1:
                    first = position
                else:
                    min_distance = min(
                        min_distance,
                        position - previous
                    )

                previous = position

            prev = curr
            curr = next_node
            position += 1

        if first == -1 or previous == first:
            return [-1, -1]

        max_distance = previous - first

        return [min_distance, max_distance]
