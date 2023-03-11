package leetcode.march2023.kaspi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class QueueAtTheBank {

    //do not change code here
    public static void main(String[] args) {
//        var requestArray = new String[]{"1", "2", "VIP 3", "SERVED", "SERVED"};
//        var requestArray = new String[]{"2", "VIP 3", "SERVED", "1"};

        var requestArray = new String[]{"50",       "VIP 44",   "38",       "VIP 32",   "5",
                                        "11",       "34",       "32",       "VIP 16",   "31",
                                        "17",       "SERVED",   "SERVED",   "43",       "1",
                                        "VIP 4",    "10",       "22",       "SERVED",   "47",
                                        "SERVED",   "3",        "SERVED",   "SERVED",   "SERVED",
                                        "SERVED",   "4",        "45",       "VIP 28",   "28",
                                        "49",       "VIP 8",    "SERVED",   "30",       "14",
                                        "VIP 20",   "20",       "15",       "6",        "46",
                                        "13",       "29",       "19",       "SERVED",   "27",
                                        "VIP 48",   "50",       "VIP 40",   "VIP 36",   "41",
                                        "23"};
        System.out.println(Arrays.toString(queueAtTheBank(requestArray.length, requestArray)));
    }

    public static int[] queueAtTheBank(int n, String[] requests) {
        //write your implementation here
        // [50, 44, 16, 28, 20, 40, 48, 8, 4, 32] wrong
        // [44, 32, 38, 5, 16, 11, 34, 4, 32, 31] ???
        if (requests == null) return new int[]{};
        var linkedList = new LinkedListImpl();
        var regularList = new LinkedList<Integer>();
        var vipList = new LinkedList<Integer>();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (requests[i].equals("SERVED")) count++;
            else if (requests[i].contains("VIP")) vipList.add(Integer.valueOf(requests[i].split(" ")[1]));
            else regularList.add(Integer.valueOf(requests[i]));
        }

        System.out.println("\n=======================\n");
        vipList.stream().map(i -> i + " ").forEach(System.out::print);
        System.out.println();
        regularList.stream().map(i -> i + " ").forEach(System.out::print);
        System.out.println();
        System.out.println(count);
        System.out.println("\n=======================\n");

        linkedList.addNode(requests[0].contains("VIP") ? Integer.valueOf(requests[0].split(" ")[1])
                : Integer.valueOf(requests[0]));
        if (count != 1) {
            IntStream.range(1, count).forEachOrdered(i -> {
                if (!vipList.isEmpty()) linkedList.addNodeInMiddle(vipList.pop());
                else if (!regularList.isEmpty()) linkedList.addNode(regularList.pop());
            });
        }
        return linkedList.getList().stream().mapToInt(Integer::intValue).toArray();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListImpl {
    Node head;

    public LinkedListImpl() {
        this.head = null;
    }

    public void addNode(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            this.head = new_node;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
        }
    }

    public Node getMiddleNode() {
        Node slowPtr = this.head;
        Node fastPtr = this.head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public void addNodeInMiddle(int data) {
        Node middleNode = this.getMiddleNode();
        Node newNode = new Node(data);
        newNode.next = middleNode.next;
        middleNode.next = newNode;
    }

    public ArrayList<Integer> getList() {
        var arrayList = new ArrayList<Integer>();
        Node current = this.head;
        while (current != null) {
            arrayList.add(current.data);
            current = current.next;
        }
        return arrayList;
    }
}
