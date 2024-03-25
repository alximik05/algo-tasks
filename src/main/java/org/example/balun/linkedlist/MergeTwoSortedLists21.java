package org.example.balun.linkedlist;

import javax.print.attribute.standard.PresentationDirection;

public class MergeTwoSortedLists21 {

    public static void main(String[] args) {

        mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null)))
        );


    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {

        ListNode first = list1;
        ListNode second = list2;
        ListNode dummy = new ListNode(-1, null);
        ListNode current = dummy;
        while (first != null && second != null) {
            if (getValue(first) >= getValue(second)) {
                current.next = second;
                second = second.next;
            } else {
                current.next = first;
                first = first.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }
        return dummy.next;
    }

    int getValue(ListNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return node.val;
    }



    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }


        ListNode first = list1;
        ListNode second = list2;


        ListNode dummy = new ListNode(-1, null);
        ListNode current = dummy;
        while (first != null && second != null) {
            if (first.val >= second.val) {
                current.next = second;
                second = second.next;
            } else {
                current.next = first;
                first = first.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }
        return dummy.next;
    }

    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }


        ListNode first = list1;
        ListNode second = list2;


        ListNode result = null;
        if (first.val >= second.val) {
            result = second;
            second = second.next;
        } else {
            result = first;
            first = first.next;
        }

        ListNode current = result;

        while (first != null && second != null) {
            if (first.val >= second.val) {
                current.next = second;
                second = second.next;
            } else {
                current.next = first;
                first = first.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }
        return result;
    }


}
