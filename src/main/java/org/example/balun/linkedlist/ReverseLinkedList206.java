package org.example.balun.linkedlist;

public class ReverseLinkedList206 {


    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
