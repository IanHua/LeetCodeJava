/**
 * 160. Intersection of Two Linked Lists
 * Cut the logger part off
 * O(n)
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode intersect(ListNode nodeA, ListNode nodeB) {
        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    } 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 0, lenB = 0, len;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if (lenA >= lenB) {
            while (lenA - lenB > 0) {
                nodeA = nodeA.next;
                lenA--;
            }
        }
        else {
            while (lenB - lenA > 0) {
                nodeB = nodeB.next;
                lenB--;
            }
        }
        return intersect(nodeA, nodeB);
    }
}