class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
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
            if (indegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            cnt++;
            Set<Integer> adj = graph.get(v);
            for (Integer j : adj) {
                    indegree[j]--;
                    if (indegree[j] == 0) queue.add(j);
            }
        }
        return cnt == numCourses;
        
       /* DFS
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onpath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(graph, visited, onpath, i)) return false;
        }
        return true;
        */
    }
    /*
    private boolean dfs(List<Set<Integer>> graph, boolean[] visited, boolean[] onpath, int vertex) {
        if (visited[vertex]) return true;
        visited[vertex] = true;
        onpath[vertex] = true;
        for (Integer adj : graph.get(vertex)) {
            if (onpath[adj] || !dfs(graph, visited, onpath, adj)) return false;
        }
        onpath[vertex] = false;
        return true;
    }*/
    
}