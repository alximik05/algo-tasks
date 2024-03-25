package org.example.balun.linkedlist;

import org.example.yandex.sprint1.L;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEndofList19 {

    public static void main(String[] args) {

    }




    static public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fake = new ListNode(-1, head);
        ListNode fast = fake;
        ListNode slow = fake;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fake.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return fake.next;
    }


    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(-1, head);
        int length = findLength(fake);
        int index = 0;
        ListNode current = fake;
        while (index != length - 1 - n) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        return fake.next;
    }



    private static int findLength(ListNode head) {
        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

