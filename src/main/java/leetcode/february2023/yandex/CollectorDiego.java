package leetcode.february2023.yandex;

import java.util.*;
import java.util.stream.IntStream;

public class CollectorDiego {

    // 13.02.2023 - C

    private static class Node {
        int key, height, duplicates;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
            this.duplicates = 1;
        }
    }

    public Node root;

    private int size(Node node) {
        return node == null ? 0 : node.height;
    }

    private int countSmaller(Node node, int val) {
        if (node == null) return 0;
        return val <= node.key ? countSmaller(node.left, val)
                : 1 + size(node.left) + countSmaller(node.right, val);
        // node.duplicates +
    }

    private Node insert(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.key) node.left = insert(node.left, val);
        else if (val > node.key) node.right = insert(node.right, val);
        else node.duplicates++;
        node.height = 1 + size(node.left) + size(node.right);
        return node;
    }

    public int countSmaller(int val) {
        return countSmaller(root, val);
    }

    private void insert(int val) {
        root = insert(root, val);
    }

    private static void printDifferenceButTL10(CollectorDiego bst, List<Integer> nCollectors) {
        // TL: 10 test
        nCollectors.forEach(i -> System.out.println(bst.countSmaller(i)));
    }

    private static void printDifferenceButTL9(List<Integer> nStickers, List<Integer> nCollectors) {
        // TL: 9 test
        var ans = new HashSet<Integer>();
        nCollectors.forEach(i -> {
            nStickers.stream().filter(j -> i > j).forEachOrdered(ans::add);
            System.out.println(ans.size());
            ans.clear();
        });
    }

    private static void sortAndSearch(int[] uniqueArr, int key) {
        var pos = Arrays.binarySearch(uniqueArr, key);
        if (pos < 0) {
            pos = -(pos + 1) - 1;
            if (pos < 0) {
                System.out.println(0);
                return;
            } else if (pos < uniqueArr.length - 1 && key - uniqueArr[pos] > uniqueArr[pos + 1] - key) {
                pos++;
            }
        }
        if (pos == 0 && uniqueArr[pos] >= key) {
            System.out.println(0);
            return;
        }
        System.out.println(uniqueArr[pos] < key ? pos + 1 : pos);
    }

    private static void printDifference(HashSet<Integer> nStickers, List<Integer> nCollectors) {
        var uniqueArr = new int[nStickers.size()];
        var index = 0;
        for (int num : nStickers) {
            uniqueArr[index++] = num;
        }
        Arrays.sort(uniqueArr);
        nCollectors.forEach(i -> sortAndSearch(uniqueArr, i));
    }

    private void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.key + " ");
        inOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var nStickers = new HashSet<Integer>();
        var nCollectors = new ArrayList<Integer>();

//        CollectorDiego bst = new CollectorDiego();
        int t = sc.nextInt();
        IntStream.range(0, t).map(i1 -> sc.nextInt()).forEachOrdered(nStickers::add);
//        nStickers.forEach(bst::insert);
        int k = sc.nextInt();
        IntStream.range(0, k).mapToObj(i -> sc.nextInt()).forEachOrdered(nCollectors::add);
//        nStickers.sort(Integer::compareTo);
//        printDifference(nStickers, nCollectors);
//        printDifference(bst, nCollectors);
//        System.out.println("\n==================\n");
//        bst.inOrderTraversal();

        printDifference(nStickers, nCollectors);
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

      ===================

      30
      1 30 2 29 3 28 4 27 5 26 6 25 7 24 8 23 9 22 10 21 11 20 12 19 13 18 14 17 15 16
      31
      1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31

      ==================

      4
      3 3 2 2
      4
      3 3 4 2

      1
      1
      2
      0

      ==================

      100
      41 18467 6334 26500 19169 15724 11478 29358 26962 24464 5705 28145 23281 16827 9961 491 2995 11942 4827 5436 32391 14604 3902 153 292 12382 17421 18716 19718 19895 5447 21726 14771 11538 1869 19912 25667 26299 17035 9894 28703 23811 31322 30333 17673 4664 15141 7711 28253 6868 25547 27644 32662 32757 20037 12859 8723 9741 27529 778 12316 3035 22190 1842 288 30106 9040 8942 19264 22648 27446 23805 15890 6729 24370 15350 15006 31101 24393 3548 19629 12623 24084 19954 18756 11840 4966 7376 13931 26308 16944 32439 24626 11323 5537 21538 16118 2082 22929 16541
      100
      4833 31115 4639 29658 22704 9930 13977 2306 31673 22386 5021 28745 26924 19072 6270 5829 26777 15573 5097 16512 23986 13290 9161 18636 22355 24767 23655 15574 4031 12052 27350 1150 16941 21724 13966 3430 31107 30191 18007 11337 15457 12287 27753 10383 14945 8909 32209 9758 24221 18588 6422 24946 27506 13030 16413 29168 900 32591 18762 1655 17410 6359 27624 20537 21548 6483 27595 4041 3602 24350 10291 30836 9374 11020 4596 24021 27348 23199 19668 24484 8281 4734 53 1999 26418 27938 6900 3788 18127 467 3728 14893 24648 22483 17807 2421 14310 6617 22813 9514


      HERE-SORTED: [41, 153, 288, 292, 491, 778, 1842, 1869, 2082, 2995,
                    3035, 3548, 3902, 4664, 4827, 4966, 5436, 5447, 5537, 5705,
                    6334, 6729, 6868, 7376, 7711, 8723, 8942, 9040, 9741, 9894,
                    9961, 11323, 11478, 11538, 11840, 11942, 12316, 12382, 12623, 12859,
                    13931, 14604, 14771, 15006, 15141, 15350, 15724, 15890, 16118, 16541,
                    16827, 16944, 17035, 17421, 17673, 18467, 18716, 18756, 19169, 19264,
                    19629, 19718, 19895, 19912, 19954, 20037, 21538, 21726, 22190, 22648,
                    22929, 23281, 23805, 23811, 24084, 24370, 24393, 24464, 24626, 25547,
                    25667, 26299, 26308, 26500, 26962, 27446, 27529, 27644, 28145, 28253,
                    28703, 29358, 30106, 30333, 31101, 31322, 32391, 32439, 32662, 32757]

     */
}
