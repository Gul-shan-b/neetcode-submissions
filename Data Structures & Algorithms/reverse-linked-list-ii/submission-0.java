/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        // Dummy node helps when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node before 'left'
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // cur is the first node we want to reverse
        ListNode cur = prev.next;

        // Reverse right-left+1 nodes
        ListNode reversePrev = null;

        for (int i = 0; i <= right - left; i++) {

            ListNode next = cur.next;

            cur.next = reversePrev;

            reversePrev = cur;
            cur = next;
        }

        // Connect the reversed part back
        ListNode leftNode = prev.next;

        prev.next = reversePrev;

        leftNode.next = cur;

        return dummy.next;
    }
}