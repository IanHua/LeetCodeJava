/**
 * 138. Copy List with Random Pointer
 * Map original ListNode to new ListNode
 * Two traversals: the first one is to build new linkedlist and create hashmap,
 * the second one is to set random of the new linkedlist
 * O(n)
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode curr = dummyHead, original = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (original != null) {
            curr.next = new RandomListNode(original.label);
            curr = curr.next;
            map.put(original, curr);
            original = original.next;
        }
        curr = dummyHead;
        original = head;
        while (original != null) {
            curr.next.random = map.get(original.random);
            curr = curr.next;
            original = original.next;
        }
        return dummyHead.next;
    }
}