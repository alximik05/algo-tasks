package org.example.balun.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeInLinkedList1019 {

    // Input: head = [2,1,5]
    // Output: [5,5,0]

    public static void main(String[] args) {
        new NextGreaterNodeInLinkedList1019().nextLargerNodes(new ListNode(2, new ListNode(1, new ListNode(5, null))));
    }


    public int[] nextLargerNodes2(ListNode head) {
        Deque<int[]> stack = new ArrayDeque<>();
        int size = defineSize(head);
        int[] result = new int[size];

        ListNode current = head;
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && stack.peekFirst()[1] < current.val) {
                int index = stack.pollFirst()[0];
                result[index] = current.val;
            }
            stack.offerFirst(new int[]{i, current.val});
            current = current.next;
        }
        return result;
    }

    private int defineSize(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public int[] nextLargerNodes(ListNode head) {
        int size = defineSize(head);
        if (size == 0) {
            return new int[0];
        }
        int[] res = new int[size];

        ListNode current = head;
        for (int i = 0; i < size; i++) {
            int currentMax = 0;
            ListNode tmp = current.next;
            while (tmp != null) {
                if (current.val < tmp.val) {
                    currentMax = tmp.val;
                    break;
                }
                tmp = tmp.next;
            }
            res[i] = currentMax;
            current = current.next;
        }
        return res;
    }



}
