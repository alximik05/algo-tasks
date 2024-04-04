package org.example.balun.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        return traverse(res, 0, root);
//    }
//
//    List<List<Integer>> traverse(List<List<Integer>> res, int level, TreeNode treeNode) {
//        if (treeNode == null) {
//            return res;
//        }
//        if (level == res.size()) {
//            res.add(new ArrayList<>());
//        }
//
//        res.get(level).add(treeNode.val);
//        traverse(res, level + 1, treeNode.left);
//        traverse(res, level + 1, treeNode.right);
//
//        return res;
//    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int numberOnLevel = queue.size();
            List<Integer> levelNumber = new ArrayList<>();
            for (int i = 0; i < numberOnLevel; i++) {
                TreeNode cur = queue.poll();
                levelNumber.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(levelNumber);
        }

        return res;
    }
}
