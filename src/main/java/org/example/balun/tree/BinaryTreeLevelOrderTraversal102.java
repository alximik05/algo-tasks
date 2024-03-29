package org.example.balun.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        return traverse(res, 0, root);
    }

    List<List<Integer>> traverse(List<List<Integer>> res, int level, TreeNode treeNode) {
        if (treeNode == null) {
            return res;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(treeNode.val);
        traverse(res, level + 1, treeNode.left);
        traverse(res, level + 1, treeNode.right);

        return res;
    }
}
