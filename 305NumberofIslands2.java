class Solution {
    
    private class Point {
        private int x;
        
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        Map<Point, Point> map = new HashMap<>();
        int count = 0;
        int[][] offsets = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] pos : positions) {
            Point root = new Point(pos[0], pos[1]);
            map.put(root, root);
            count++;
            for (int[] offset : offsets) {
                int x = pos[0] + offset[0];
                int y = pos[1] + offset[1];
                if (x < 0 || x > m || y < 0 || y > n) continue;
                Point neighbor = new Point(x, y);
                if (!map.containsKey(neighbor)) continue;
                Point neighborRoot = find(map, neighbor);
                if (root != neighborRoot) {
                    map.put(root, neighborRoot);
                    root = neighborRoot;
                    count--;
                }
            }
            res.add(count); 
        }
        return res;
    }
    
    private Point find(Map<Point, Point> map, Point p) {
        if (!map.containsKey(p)) map.put(p, p);
        if (map.get(p) == p) return p;
        map.put(p, find(map, map.get(p)));
        return map.get(p);
    }
}