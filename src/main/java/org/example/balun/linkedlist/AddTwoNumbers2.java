package org.example.balun.linkedlist;

public class AddTwoNumbers2 {

    public static void main(String[] args) {
        //Input: l1 = [2,4,3], l2 = [5,6,4]
        //Output: [7,0,8]
//        System.out.println(
//                addTwoNumbers(
//                        new ListNode(2, new ListNode(4, new ListNode(3, null))),
//                        new ListNode(5, new ListNode(6, new ListNode(4, null)))));
//        Input: l1 = [0], l2 = [0]
//        Output: [0]
//        System.out.println(addTwoNumbers(new ListNode(0, null), new ListNode(0, null)));
//        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        Output: [8,9,9,9,0,0,0,1]
//        System.out.println(addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))), new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))));

        // [2,4,9]
        // [5,6,4,9]
        // [7,0,4,0,1]
//        System.out.println(
//                addTwoNumbers(
//                        new ListNode(2, new ListNode(4, new ListNode(9, null))),
//                        new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9, null)))))
//        );

        // [9]
        // [1,9,9,9,9,9,9,9,9,9]

//        System.out.println(
//                addTwoNumbers(
//                        new ListNode(9, null),
//                        new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))))))))
//        );

//          [0,8,6,5,6,8,3,5,7]
//          [6,7,8,0,8,5,8,9,7]
//        System.out.println(
//                addTwoNumbers(new ListNode(0, new ListNode(8, new ListNode(6, new ListNode(5, new ListNode(6, new ListNode(8, new ListNode(3, new ListNode(5, new ListNode(7, null))))))))),
//                        new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(0, new ListNode(8, new ListNode(5, new ListNode(8, new ListNode(9, new ListNode(7, null))))))))))
//        );

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1, null);
        ListNode current = fake;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = getValue(l1) + getValue(l2) + carry;
            int valueToNode = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(valueToNode, null);
            current = current.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        if (carry != 0) {
            current.next = new ListNode(carry, null);
        }
        return fake.next;
    }

    int getValue(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }

}
