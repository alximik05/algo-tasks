package org.example.balun.tree;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        rotate(root.right);
        return tra2(root.left, root.right);
    }

    boolean tra(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if(first == null || second == null) {
            return false;
        }
        if (first.val != second.val) {
            return false;
        }

        return tra(first.left, second.right) && tra(first.right, second.left);
    }


    void rotate(TreeNode root) {
        if (root == null) {
            return;
        }

        rotate(root.left);
        rotate(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    boolean tra2(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if(first == null || second == null) {
            return false;
        }
        if (first.val != second.val) {
            return false;
        }
        return tra(first.left, second.left) && tra(first.right, second.right);
    }


}
