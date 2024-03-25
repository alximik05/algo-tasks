package org.example.balun.linkedlist;

public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1, null);
        ListNode current = dummy;
        while (true) {
            Integer minList = minNodeIndex(lists);
            if (minList == null) {
                current.next = null;
                break;
            }

            // так почему то не работает
//            ListNode list = lists[minList];
//            current.next = list;
//            current = current.next;
//            list = list.next;

            current.next = lists[minList];
            current = current.next;
            lists[minList] = lists[minList].next;


        }
        return dummy.next;
    }


    Integer minNodeIndex(ListNode[] lists) {
        int minIndex = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lists[i].val < minValue) {
                minValue = lists[i].val;
                minIndex = i;
            }
        }
        if (minValue == Integer.MAX_VALUE) {
            return null;
        }
        return minIndex;
    }


}
