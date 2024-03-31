package org.example.balun.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII107 {


     public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    void traverse(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }


        if (res.size() == level) {
            res.add(0, new ArrayList<>());
        }

        traverse(node.left, res, level + 1);
        traverse(node.right, res, level + 1);

        List<Integer> numberOnLevel = res.get(res.size() - 1 -  level);
        numberOnLevel.add(node.val);
    }
}
