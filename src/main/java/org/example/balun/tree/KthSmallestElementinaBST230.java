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




}
