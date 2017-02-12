/**
 * 133. Clone Graph
 * USe DFS to traverse the undirected graph
 * Use map to record copied nodes to avoid infinite recursion
 * O(n)
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         if (node == null) return null;
         Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
         return dfs(node, map);
    }
}