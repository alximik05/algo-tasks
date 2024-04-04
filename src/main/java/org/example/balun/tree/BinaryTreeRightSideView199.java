package org.example.balun.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

//    public List<Integer> rightSideView(TreeNode root) {
//        HashMap<Integer, Integer> levelValues = new HashMap<>();
//        tra(levelValues, root, 0);
//        return new ArrayList<>(levelValues.values());
//
//    }
//
//    void tra(Map<Integer, Integer> levelValues, TreeNode node, int level) {
//        if (node == null) {
//            return;
//        }
//
//        if (!levelValues.containsKey(level)) {
//            levelValues.put(level, node.val);
//        }
//
//
//        tra(levelValues, node.right, level + 1);
//
//        tra(levelValues, node.left, level + 1);
//
//    }

    public static void main(String[] args) {
        System.out.println(rightSideView(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)))));
    }

    static public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int elements = queue.size();
            for (int i = 0; i < elements; i++) {

                TreeNode treeNode = queue.poll();
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if (i == 0) {
                    res.add(treeNode.val);
                }
            }
        }
        return res;
    }
}
