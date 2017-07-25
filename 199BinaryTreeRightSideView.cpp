/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> nodes;
        recursion(root, 1, nodes);
        return nodes;
    }
    void recursion(TreeNode* node, int level, vector<int> &nodes) {
        if (node == NULL) return;
        if (nodes.size() < level) nodes.push_back(node->val);
        recursion(node->right, level+1, nodes);
        recursion(node->left, level+1, nodes);
    }
};