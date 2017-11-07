class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS
        List<Integer> ans = new LinkedList<>();
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                ans.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            cnt++;
            Set<Integer> adj = graph.get(v);
            for (Integer j : adj) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        queue.add(j);
                        ans.add(j);
                    }
            }
        }
        if (cnt != numCourses) ans.clear();
        int[] intans = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            intans[i] = ans.get(i);
        }
        return intans;
    }
}