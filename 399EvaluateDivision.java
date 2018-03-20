class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pair = new HashMap<>();
        Map<String, List<Double>> valuePair = new HashMap();
        int n = equations.length;
        int m = queries.length;
        double[] res = new double[m];
        Arrays.fill(res, -1.0);
        if (n == 0 || m == 0) return res;
        for (int i = 0; i < n; i++) {
            String first = equations[i][0];
            String second = equations[i][1];
            if (!pair.containsKey(first)) {
                pair.put(first, new ArrayList<>());
                valuePair.put(first, new ArrayList<>());
            }
            if (!pair.containsKey(second)) {
                pair.put(second, new ArrayList<>());
                valuePair.put(second, new ArrayList<>());
            }
            pair.get(first).add(second);
            pair.get(second).add(first);
            valuePair.get(first).add(values[i]);
            valuePair.get(second).add(1.0 / values[i]);
        }
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String first = queries[i][0];
            String second = queries[i][1];
            res[i] = dfs(first, second, pair, valuePair, visited, 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    private double dfs(String start, String end, Map<String, List<String>> pair, Map<String, List<Double>> valuePair, 
                       Set<String> visited, double value) {
        if (visited.contains(start)) return 0.0;
        if (!pair.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        visited.add(start);
        List<String> tmpStr = pair.get(start);
        List<Double> tmpValue = valuePair.get(start);
        double tmp = 0.0;
        for (int i = 0; i < tmpStr.size(); i++) {
            tmp = dfs(tmpStr.get(i), end, pair, valuePair, visited, value * tmpValue.get(i));
            if (tmp != 0.0) break;
        }
        visited.remove(start);
        return tmp;
    }
}