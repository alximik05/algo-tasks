package org.example.cracking_interview.linkedlist;

public class DeleteNodeInMiddle23 {


    void deleteNodeInMiddle(Node node) {
        if (node == null || node.next == null) {
            throw new RuntimeException();
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
