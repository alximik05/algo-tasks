package org.example.balun.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int el = queue.size();

            List<Integer> onLevel = new ArrayList<>();
            for (int i = 0; i < el; i++) {
                TreeNode node = queue.poll();
                onLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(0, onLevel);
        }
        return res;
    }





//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        traverse(root, res, 0);
//        return res;
//    }
//
//    void traverse(TreeNode node, List<List<Integer>> res, int level) {
//        if (node == null) {
//            return;
//        }
//
//
//        if (res.size() == level) {
//            res.add(0, new ArrayList<>());
//        }
//
//        traverse(node.left, res, level + 1);
//        traverse(node.right, res, level + 1);
//
//        List<Integer> numberOnLevel = res.get(res.size() - 1 -  level);
//        numberOnLevel.add(node.val);
//    }
}
