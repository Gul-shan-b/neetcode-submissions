/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // STEP 1: Create a cloned node and interleave it right after the original node.
        // Original: A -> B -> C
        // Interleaved: A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;
            curr = nextNode;
        }

        // STEP 2: Assign random pointers for the cloned nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // curr.next is the clone. 
                // curr.random.next is the clone of the random node.
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }

        // STEP 3: Separate the original list and the cloned list.
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            Node nextOriginal = curr.next.next;

            // Extract the clone
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            // Restore the original list
            curr.next = nextOriginal;
            curr = nextOriginal;
        }

        return dummyHead.next;
    }
}
