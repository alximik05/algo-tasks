package org.example.balun.tree;

public class MinimumDepthofBinaryTree111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root, 1);
    }

    int getMinDepth(TreeNode node, int level) {
        if (isLeaf(node)) {
            return level;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = getMinDepth(node.left, level + 1);
        }
        if (node.right != null) {
            right = getMinDepth(node.right, level + 1);
        }

        return Math.min(left, right);
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
