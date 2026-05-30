class Solution {

    class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int L, int R) {
            if (L > R) return 0;
            return query(1, 0, n - 1, L, R);
        }

        private int query(int node, int l, int r, int L, int R) {
            if (L <= l && r <= R) {
                return tree[node];
            }

            int mid = (l + r) >> 1;
            int ans = 0;

            if (L <= mid) {
                ans = Math.max(ans,
                        query(node * 2, l, mid, L, R));
            }

            if (R > mid) {
                ans = Math.max(ans,
                        query(node * 2 + 1, mid + 1, r, L, R));
            }

            return ans;
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50002;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        SegmentTree seg = new SegmentTree(MAX);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                Integer prev = obstacles.floor(x);
                Integer next = obstacles.ceiling(x);

                obstacles.add(x);

                seg.update(x, x - prev);

                if (next != null) {
                    seg.update(next, next - x);
                }

            } else {

                int x = q[1];
                int sz = q[2];

                Integer p = obstacles.floor(x);

                int maxGap = seg.query(0, p);
                maxGap = Math.max(maxGap, x - p);

                ans.add(maxGap >= sz);
            }
        }

        return ans;
    }
}
