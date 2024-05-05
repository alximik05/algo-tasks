package org.example.balun.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private final List<Integer> array = new ArrayList<>();
    public void push(int num) {
        array.add(num);
        moveUp(array.size() - 1);
    }

    public int top() {
        return array.get(0);
    }

    public int pop() {
        int top = top();
        swap(0, array.size() - 1);
        array.remove(array.size() - 1);
        moveDown(0);
        return top;
    }

    private void moveDown(int i) {
        int leftIndex = i * 2 - 1;
        int rightIndex = i * 2 - 2;
        if (leftIndex >= array.size()) {
            return;
        }

        int nextIndex = leftIndex;
        int nextMinVal = array.get(leftIndex);

        if (rightIndex < array.size() && array.get(rightIndex) < nextMinVal) {
            nextMinVal = array.get(rightIndex);
            nextIndex = rightIndex;
        }

        int current = array.get(i);
        if (nextMinVal < current) {
            swap(i, nextIndex);
            moveDown(nextIndex);
        }
    }

    private void moveUp(int i) {
        if (array.get(i) < array.get((i - 1) / 2)) {
            swap(array.get(i), array.get((i - 1) / 2));
            moveUp((i - 1) / 2);
        }
    }

    private void swap(Integer first, Integer second) {
        int tmp = array.get(first);
        array.set(first, array.get(second));
        array.set(second, tmp);
    }


}
