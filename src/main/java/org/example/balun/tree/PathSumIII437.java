package org.example.balun.tree;

public class PathSumIII437 {

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        calc(root, targetSum, 0);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return this.count;
    }

    public void calc(TreeNode node, int targetSum, long previousSum) {
        if (node == null) {
            return;
        }

        if (previousSum + node.val == targetSum) {
            this.count++;
        }

        calc(node.left, targetSum, previousSum + node.val);
        calc(node.right, targetSum, previousSum + node.val);
    }
}
