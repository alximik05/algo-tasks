package org.example.cracking_interview.linkedlist;

import java.util.Stack;

import static org.example.cracking_interview.linkedlist.DivideLinkedList24.printLL;

public class IsPalindrom26 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        linkedList.printList();

        System.out.println("==========");
        System.out.println(isPalindrom(linkedList.head));
    }

    static boolean isPalindrom(Node head) {
        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        current = head;

        while (current != null) {
            Node fromStack = stack.pop();
            if (current.data != fromStack.data) {
                return false;
            }
            current = current.next;
        }

        return true;
    }
}
