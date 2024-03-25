package org.example.balun.linkedlist;

public class PalindromeLinkedList234 {

    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddle(head);

        ListNode currentReversed = reverseFromNode(middleNode);
        ListNode current = head;

        while (currentReversed != null) {
            if (current.val != currentReversed.val) {
                return false;
            }
            current = current.next;
            currentReversed = currentReversed.next;
        }
        return true;
    }

    private ListNode reverseFromNode(ListNode middleNode) {
        ListNode current = middleNode;
        ListNode prev = null;

        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }

        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
