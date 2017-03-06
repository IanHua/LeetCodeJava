/**
 * 328. Odd Even Linked List
 * dummyHead
 * Debug for odd number, even number and one element
 * O(n)
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head, next = head.next;
        while (next != null) {
            curr.next = next.next;
            prev.next = next;
            prev = next;
            if (curr.next != null) {
                curr = curr.next;
            }
            next = curr.next;
        }
        curr.next = dummyHead.next;
        prev.next = null;
        return head;
    }
}