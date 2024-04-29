package org.example.balun.hash;

import org.example.yandex.sprint1.L;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache146 {

}

class LRUCache {

    LinkedNode head;
    Map<Integer, LinkedNode> map;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        LinkedNode linkedNode = map.get(key);
        if (linkedNode == null) {
            return -1;
        }
        moveToHead(linkedNode);
        return linkedNode.value;
    }

    private void moveToHead(LinkedNode linkedNode) {
        if (linkedNode == head) {
            return;
        }
        if (head == null) {
            head = linkedNode;
            return;
        }
        if (linkedNode.prev != null) {
            linkedNode.prev.next = linkedNode.next;
        }
        if (linkedNode.next != null) {
            linkedNode.next.prev = linkedNode.prev;
        }
    }

    public void put(int key, int value) {
        LinkedNode linkedNode = new LinkedNode(value, null, head);
        map.put(key, linkedNode);
        head = linkedNode;

    }

    class LinkedNode {
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int value, LinkedNode prev, LinkedNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

}
