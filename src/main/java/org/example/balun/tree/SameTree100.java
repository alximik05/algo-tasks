package org.example.balun.tree;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return tra(p, q);
    }

    boolean tra(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return tra(p.left, q.left) && tra(p.right, q.right);
    }
}
