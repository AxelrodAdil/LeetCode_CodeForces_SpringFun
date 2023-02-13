package leetcode.february2023.yandex;

import java.util.*;
import java.util.stream.IntStream;

public class CollectorDiego {

    // 13.02.2023 - C

    private static class Node {
        int key, height;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    public Node root;

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node node) {
        var newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private Node leftRotate(Node node) {
        var newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);
        if (balance > 1 && key < node.left.key) return rightRotate(node);
        if (balance < -1 && key > node.right.key) return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private int countSmaller(Node node, int key) {
        if (node == null) return 0;
        if (key <= node.key) return countSmaller(node.left, key);
        return 1 + height(node.left) + countSmaller(node.right, key);
    }

    public int countSmaller(int key) {
        return countSmaller(root, key);
    }

    private static void printDifference(CollectorDiego avlTree, List<Integer> nCollectors) {
        nCollectors.forEach(i -> System.out.println(avlTree.countSmaller(i)));
    }

    private static void printDifferenceButTL(List<Integer> nStickers, List<Integer> nCollectors) {
        // TL: 9 test
        var ans = new HashSet<Integer>();
        nCollectors.forEach(i -> {
            nStickers.stream().filter(j -> i > j).forEachOrdered(ans::add);
            System.out.println(ans.size());
            ans.clear();
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        var nStickers = new ArrayList<Integer>();
        var nCollectors = new ArrayList<Integer>();

        CollectorDiego avlTree = new CollectorDiego();
        int t = sc.nextInt();
        IntStream.range(0, t).map(i1 -> sc.nextInt()).forEachOrdered(avlTree::insert);
        int k = sc.nextInt();
        IntStream.range(0, k).mapToObj(i -> sc.nextInt()).forEachOrdered(nCollectors::add);
//        nStickers.sort(Integer::compareTo);
//        printDifferenceButTL(nStickers, nCollectors);
        printDifference(avlTree, nCollectors);
    }

    /*
      1
      5
      2
      4 6

      0
      1

      ====================

      3
      100 1 50
      3
      300 0 75

      3
      0
      2
     */
}
