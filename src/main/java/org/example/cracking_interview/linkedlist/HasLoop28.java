package org.example.cracking_interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasLoop28 {
    public static void main(String[] args) {

    }

    Node hasLoop(Node head) {
        Set<Node> set = new HashSet<>();
        Node current = head;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }

    Node hasLoop2(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }



}
