package org.example.cracking_interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasIntersection27 {
    public static void main(String[] args) {

    }

    private static Node hasIntersection2(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        Node current = head1;
        while (current != null) {
            set.add(current);
            current = current.next;
        }
        current = head2;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private static Node hasIntersection(Node head1, Node head2) {
        Result tail1 = findTailAndSize(head1);
        Result tail2 = findTailAndSize(head2);

        if (tail1.tail != tail2.tail) {
            return null;
        }

        Node longer = tail1.size > tail2.size ? head1 : head2;
        Node shorter = tail1.size > tail2.size ? head2 : head1;

        int delta = Math.abs(tail2.size - tail1.size);
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

    private static Result findTailAndSize(Node head1) {
        Node current = head1;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }



    static class Result {
        Node tail;
        int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
