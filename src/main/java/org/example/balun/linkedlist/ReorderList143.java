package org.example.balun.linkedlist;

import org.example.yandex.sprint1.Q;

import java.util.List;

public class ReorderList143 {

    // Input: head = [1,2,3,4]
    // Output: [1,4,2,3]
    public void reorderList(ListNode head) {
        ListNode preMiddle = findPreMiddle(head);

        ListNode middle = preMiddle.next;
        preMiddle.next = null;

        ListNode tail = reverse(middle);

        ListNode left = head;
        ListNode right = tail;

        while (right != null) {
            ListNode tmpLeft = left.next;
            left.next = right;
            left = right;
            right = tmpLeft;
        }
    }

    private ListNode reverse(ListNode middle) {
        ListNode current = middle;
        ListNode prev = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }

    private ListNode findPreMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
