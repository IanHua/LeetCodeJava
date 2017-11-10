class Solution {
    class Pair {
        int x;
        int y;
        int val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return -1;
        int col = matrix[0].length;
        if (col == 0) return -1;
        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare (Pair a, Pair b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, cmp);
        for (int i = 0; i < col; i++) {
            queue.add(new Pair(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Pair p = queue.poll();
            if (p.x == row - 1) continue;
            queue.add(new Pair(p.x + 1, p.y, matrix[p.x+1][p.y]));
        }
        return queue.poll().val;
    }
}