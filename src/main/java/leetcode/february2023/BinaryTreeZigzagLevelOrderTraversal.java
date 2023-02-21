package leetcode.february2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    public List<List<Integer>> zigzagLevelOrder(TreeNodeBinaryTreeZigzagLevelOrderTraversal root) {
        /*
        Runtime 1 ms
        Beats 84.7%
        Memory 40.9 MB
        Beats 65.61%
        */
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        var count = 0;
        Queue<TreeNodeBinaryTreeZigzagLevelOrderTraversal> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            count++;
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNodeBinaryTreeZigzagLevelOrderTraversal node = queue.poll();
                if (count % 2 == 1) curr.add(node != null ? node.val : 0);
                else curr.add(0, node != null ? node.val : 0);
                if ((node != null ? node.left : null) != null) queue.add(node.left);
                if ((node != null ? node.right : null) != null) queue.add(node.right);
            }
            ans.add(curr);
        }
        return ans;
    }
}

class TreeNodeBinaryTreeZigzagLevelOrderTraversal {

    int val;
    TreeNodeBinaryTreeZigzagLevelOrderTraversal left;
    TreeNodeBinaryTreeZigzagLevelOrderTraversal right;

    TreeNodeBinaryTreeZigzagLevelOrderTraversal() {
    }

    TreeNodeBinaryTreeZigzagLevelOrderTraversal(int val) {
        this.val = val;
    }

    TreeNodeBinaryTreeZigzagLevelOrderTraversal(int val, TreeNodeBinaryTreeZigzagLevelOrderTraversal left,
                                                TreeNodeBinaryTreeZigzagLevelOrderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
