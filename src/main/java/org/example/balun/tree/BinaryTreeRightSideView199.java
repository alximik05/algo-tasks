package org.example.balun.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView199 {

    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> levelValues = new HashMap<>();
        tra(levelValues, root, 0);
        return new ArrayList<>(levelValues.values());

    }

    void tra(Map<Integer, Integer> levelValues, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (!levelValues.containsKey(level)) {
            levelValues.put(level, node.val);
        }


        tra(levelValues, node.right, level + 1);

        tra(levelValues, node.left, level + 1);

    }
}
