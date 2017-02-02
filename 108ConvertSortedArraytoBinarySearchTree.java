/** 
 * 108. Convert Sorted Array to Binary Search Tree
 * Divide and conquer just like binary search
 * Pick the middle element as parent node
 * O(n)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode convert(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = convert(arr, start, mid - 1);
        node.right = convert(arr, mid + 1, end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }
}