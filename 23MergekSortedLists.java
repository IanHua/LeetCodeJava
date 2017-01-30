/**
 * 23. Merge k Sorted Lists
 * Example of PriorityQueue: override Comparator and define PriorityQueue
 * nk elements in total, logk to find min value for each element
 * An alternative is divide and conquer with mergeTwoLists
 * O(nklogk)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Comparator<ListNode> cmp = new Comparator<ListNode>() {
        @Override
        public int compare (ListNode x, ListNode y) {
            return x.val - y.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length, i;
        if (len == 0) return null;
        Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>(len, cmp);
        for (i = 0; i < len; i++) {
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead, tmp;
        while (!priorityQueue.isEmpty()) {
            tmp = priorityQueue.poll();
            curr.next = tmp;
            curr = curr.next;
            if (tmp.next != null) {
                priorityQueue.add(tmp.next);
            }
        }
        return dummyHead.next;
    }
}