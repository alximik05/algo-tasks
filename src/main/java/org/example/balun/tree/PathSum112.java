package org.example.balun.tree;

public class PathSum112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return checkSum(root, 0, targetSum);
    }

    static boolean checkSum2(TreeNode node, int previousSum, int targetSum) {
        if (node == null) {
            return false;
        }

        if (isLeaf(node)) {
            return previousSum + node.val == targetSum;
        }

        return checkSum2(node.left, previousSum + node.val, targetSum) ||
                checkSum2(node.right, previousSum + node.val, targetSum);
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }


 // не все тесты проходят
    static boolean checkSum(TreeNode node, int previousSum, int targetSum) {
        if (node == null) {
            return previousSum == targetSum;
        }

        return checkSum(node.left, previousSum + node.val, targetSum) ||
                checkSum(node.right, previousSum + node.val, targetSum);
    }
}
