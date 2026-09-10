class Solution:

    def averageOfSubtree(self, root):
        self.result = 0

        def dfs(node):
            if node is None:
                return 0, 0

            left_sum, left_count = dfs(node.left)
            right_sum, right_count = dfs(node.right)

            total_sum = node.val + left_sum + right_sum
            total_count = 1 + left_count + right_count

            # Integer division gives the required floor average
            if node.val == total_sum // total_count:
                self.result += 1

            return total_sum, total_count

        dfs(root)
        return self.result
