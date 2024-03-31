package org.example.balun.tree;

import com.sun.source.tree.Tree;

public class DeleteNodeinaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }


        return root;
    }

    TreeNode findMin(TreeNode root) {
        TreeNode res = root;
        while (res != null && res.left != null) {
            res = res.left;
        }
        return res;
    }
}
