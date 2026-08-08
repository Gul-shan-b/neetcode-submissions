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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;

        while( cur != null && cur.next != null){
            int g = gcd(cur.val,cur.next.val);
            ListNode newnode = new ListNode(g);
            newnode.next = cur.next;

            cur.next = newnode;

            cur = newnode.next;
        }
        return head;
        
    }

    private int gcd(int a, int b){
        while(b!=0){
            int temp =b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}