class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseEvenSublist {

    // Function to reverse the list
    public static ListNode reverseEvenSubparts(ListNode head) {
        // Dummy node to handle the edge case where the first part is even
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;  // To keep track of the node before the sublist
        ListNode current = head; // Traversing node
        
        while (current != null) {
            if (current.val % 2 == 0) {
                // Start reversing the sublist of even numbers
                ListNode evenStart = current;
                
                // Move to the end of the even sublist
                while (current != null && current.val % 2 == 0) {
                    current = current.next;
                }
                
                // Now current is at the first odd number or null
                ListNode evenEnd = current; // The node after the last even number
                
                // Reverse the even sublist
                prev.next = reverseList(evenStart, evenEnd);
                
                // Now prev should point to the last node of the reversed sublist
                evenStart.next = evenEnd;
                prev = evenStart;
            } else {
                // Just move to the next node if it's odd
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
    
    // Helper function to reverse the sublist from start to before end
    private static ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        
        while (current != end) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // Return the new head of the reversed sublist
    }
    
    // Function to print the list (for debugging purposes)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next = new ListNode(16);
        head.next.next.next.next.next.next = new ListNode(18);

        System.out.println("Original List:");
        printList(head);
        
        head = reverseEvenSubparts(head);
        
        System.out.println("List after reversing even sublists:");
        printList(head);
    }
}
