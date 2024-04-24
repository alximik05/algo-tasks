package org.example.balun.binarysearch;

public class Test {

}

class BinaryTree {


    BinTreeNode insert(BinTreeNode root, int newVal) {
        if (root == null) {
            return new BinTreeNode(newVal);
        }
        if (newVal > root.val) {
            root.right = insert(root.right, newVal);
        } else {
            root.left = insert(root.left, newVal);
        }
        return root;
    }

    BinTreeNode remove(BinTreeNode root, int valueForRemove) {
        if (root == null) {
            return null;
        }
        if (valueForRemove > root.val) {
            root.right = remove(root.right, valueForRemove);
        } else if (valueForRemove < root.val) {
            root.left = remove(root.left, valueForRemove);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                BinTreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = remove(root, min.val);
            }
        }
        return root;
    }

    BinTreeNode findMin(BinTreeNode node) {
        BinTreeNode tmp = node;
        while (tmp != null && tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }
}

class BinTreeNode {
    int val;
    BinTreeNode left;
    BinTreeNode right;

    public BinTreeNode(int val, BinTreeNode left, BinTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinTreeNode(int val) {
        this.val = val;
    }
}
