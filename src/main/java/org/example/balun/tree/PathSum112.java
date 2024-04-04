package org.example.balun.tree;

public class PathSum112 {

    public static void main(String[] args) {
        boolean x = hasPathSum(new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7), new TreeNode(2)), null),
                        new TreeNode(8,
                                new TreeNode(13), new TreeNode(4, null,
                                new TreeNode(1)))),
                22);
        System.out.println(x);
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return calc(root, targetSum, 0);
    }

    static boolean calc(TreeNode node, int targetSum, int prevSum) {
        if(isLeaf(node) && targetSum == prevSum + node.val) {
            return true;
        }

        if(node.left != null && calc(node.left, targetSum, prevSum + node.val)) {
            return true;
        }
        if(node.right != null && calc(node.right, targetSum, prevSum + node.val)) {
            return true;
        }
        return false;
    }




//    public static boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        return checkSum(root, 0, targetSum);
//    }
//
//    static boolean checkSum2(TreeNode node, int previousSum, int targetSum) {
//        if (node == null) {
//            return false;
//        }
//
//        if (isLeaf(node)) {
//            return previousSum + node.val == targetSum;
//        }
//
//        return checkSum2(node.left, previousSum + node.val, targetSum) ||
//                checkSum2(node.right, previousSum + node.val, targetSum);
//    }
//
    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
//
//
// // не все тесты проходят
//    static boolean checkSum(TreeNode node, int previousSum, int targetSum) {
//        if (node == null) {
//            return previousSum == targetSum;
//        }
//
//        return checkSum(node.left, previousSum + node.val, targetSum) ||
//                checkSum(node.right, previousSum + node.val, targetSum);
//    }
}
