package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {

    // https://leetcode.com/problems/balanced-binary-tree/
    // https://leetcode.com/problems/delete-node-in-a-bst/description/
    // https://leetcode.com/problems/binary-tree-preorder-traversal/

    public static boolean existingFlag = Boolean.FALSE;

    private int getMaxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int leftHeight = getMaxDepth(treeNode.left);
        if (leftHeight < 0) return -1;
        int rightHeight = getMaxDepth(treeNode.right);
        if (rightHeight < 0) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean isBalanced(TreeNode treeNode) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 42 MB
        Beats 90.33%
         */
        if (treeNode == null) return true;
        return getMaxDepth(treeNode) >= 0;
    }

    private void insertTreeNode(TreeNode treeNode, int value) {
        if (value < treeNode.val) {
            if (treeNode.left != null) {
                insertTreeNode(treeNode.left, value);
            } else {
                System.out.println(value + " - left Node: " + treeNode.val);
                treeNode.left = new TreeNode(value);
            }
        } else if (value > treeNode.val) {
            if (treeNode.right != null) {
                insertTreeNode(treeNode.right, value);
            } else {
                System.out.println(value + " - rigth Node: " + treeNode.val);
                treeNode.right = new TreeNode(value);
            }
        }
    }

    private void isExist(TreeNode treeNode, int value) {
        if (treeNode == null) return;
        if (treeNode.val == value) {
            existingFlag = Boolean.TRUE;
            return;
        }
        if (!existingFlag && treeNode.left != null) {
            isExist(treeNode.left, value);
        }
        if (!existingFlag && treeNode.right != null) {
            isExist(treeNode.right, value);
        }
    }

    private TreeNode deleteNode(TreeNode treeNode, int key) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 49.7 MB
        Beats 40.16%
         */
        if (treeNode == null) return null;
        if (treeNode.val == key) treeNode = delete(treeNode);
        if (treeNode != null) {
            if (treeNode.val < key) treeNode.right = deleteNode(treeNode.right, key);
            else treeNode.left = deleteNode(treeNode.left, key);
        }
        return treeNode;
    }

    private TreeNode delete(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) return null;
        if (treeNode.left == null) return treeNode.right;
        if (treeNode.right == null) return treeNode.left;
        TreeNode currentTreeNode = treeNode.right;
        while (currentTreeNode.left != null) {
            currentTreeNode = currentTreeNode.left;
        }
        currentTreeNode.left = treeNode.left;
        return treeNode.right;
    }

    private List<Integer> getPreorderTraversalList(TreeNode treeNode) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.4 MB
        Beats 90.70%
         */
        List<Integer> answerList = new ArrayList<>();
//        preorderRecursive(treeNode, answerList);
        preorderNonRecursive(treeNode, answerList);
        return answerList;
    }

    private void preorderNonRecursive(TreeNode treeNode, List<Integer> answerList) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(treeNode);
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            if (node != null) {
                answerList.add(node.val);
                treeNodeStack.push(node.right);
                treeNodeStack.push(node.left);
            }
        }
    }

    private void preorderRecursive(TreeNode treeNode, List<Integer> answerList) {
        if (treeNode == null) return;
        answerList.add(treeNode.val);
        preorderRecursive(treeNode.left, answerList);
        preorderRecursive(treeNode.right, answerList);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = new TreeNode(10);
        binaryTree.insertTreeNode(treeNode, 8);
        binaryTree.insertTreeNode(treeNode, 12);
        binaryTree.insertTreeNode(treeNode, 3);
        binaryTree.insertTreeNode(treeNode, 1);
        binaryTree.insertTreeNode(treeNode, 9);
        binaryTree.insertTreeNode(treeNode, 6);
        binaryTree.insertTreeNode(treeNode, 7);
        binaryTree.insertTreeNode(treeNode, 5);
        binaryTree.insertTreeNode(treeNode, 25);
        binaryTree.insertTreeNode(treeNode, 15);

        System.out.println("=======================================");
//        System.out.println(binaryTree.isBalanced(treeNode));
//        System.out.println("=======================================");
//        binaryTree.isExist(treeNode, 25);
//        System.out.println(existingFlag);
        System.out.println("=======================================");
        System.out.println(binaryTree.getPreorderTraversalList(treeNode));
//        int deletedElement = 3;
//        binaryTree.isExist(treeNode, deletedElement);
//        TreeNode tempTreeNodeAfterDeletion = null;
//        if (existingFlag) {
//            tempTreeNodeAfterDeletion = binaryTree.deleteNode(treeNode, deletedElement);
//            System.out.println(tempTreeNodeAfterDeletion.val);
//        }
//        System.out.println("=======================================");
//        System.out.println(binaryTree.getPreorderTraversalList(tempTreeNodeAfterDeletion));
//        System.out.println("=======================================");
    }
}
