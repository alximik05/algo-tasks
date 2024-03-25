package org.example.balun.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists160 {


    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        NodeAndLength a = findLastNodeAndLength(headA);
        NodeAndLength b = findLastNodeAndLength(headB);

        if (a.lastNode != b.lastNode) {
            return null;
        }

        ListNode longer = a.length > b.length ? headA : headB;
        ListNode shorter = a.length > b.length ? headB : headA;

        int delta = Math.abs(b.length - a.length);

        while (delta > 0) {
            longer = longer.next;
            delta--;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    NodeAndLength findLastNodeAndLength(ListNode headA) {
        ListNode current = headA;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        return new NodeAndLength(length, current);
    }

    static class NodeAndLength {
        Integer length;
        ListNode lastNode;

        public NodeAndLength(Integer length, ListNode lastNode) {
            this.length = length;
            this.lastNode = lastNode;
        }
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
                if (p2 != null) {
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }
            } else {
                p1 = headB;
                if (p2 != null) {
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }
            }
        }
        return p1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = headA;
        while (current != null) {
            set.add(current);
            current = current.next;
        }

        current = headB;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
}
