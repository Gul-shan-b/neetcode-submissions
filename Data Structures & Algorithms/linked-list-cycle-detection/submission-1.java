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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode currentNode = head;
        while(currentNode != null){
            if(!visitedNodes.add(currentNode)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
        
    }
}
