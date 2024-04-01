package org.example.balun.tree;

import org.example.yandex.sprint1.I;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ordered = new ArrayList<>();
        traverse(root, ordered);
        return ordered.get(k - 1);
    }

    void traverse(TreeNode node, List<Integer> ordered) {
        if (node == null) {
            return;
        }

        traverse(node.left, ordered);
        ordered.add(node.val);
        traverse(node.right, ordered);
    }


    /*
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        traverse(node.left, k);
        count++;
        if (k == count) {
            res = node.val;
        }
        traverse(node.right, k);
    }*/




}
