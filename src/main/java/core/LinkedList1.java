package core;

import java.util.ArrayList;

public class LinkedList1 {

    private void printLinkedList(ListNodeSiw1 listNodeSiw1) {
        while (listNodeSiw1.next != null) {
            System.out.print(listNodeSiw1.val + "->");
            listNodeSiw1 = listNodeSiw1.next;
        }
        System.out.print(listNodeSiw1.val + "->");
        System.out.print("null");
        System.out.println();
    }

    private ListNodeSiw1 getFirstListNodeSiw1(ListNodeSiw1 listNodeSiw1, int val) {
        if (listNodeSiw1.val == val) return listNodeSiw1;
        while (listNodeSiw1.next != null) {
            if (listNodeSiw1.val == val) return listNodeSiw1;
            listNodeSiw1 = listNodeSiw1.next;
        }
        return null;
    }

    private void validateLinkedList(ListNodeSiw1 listNodeSiw1, int val) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNodeSiw1 ourHead = getFirstListNodeSiw1(listNodeSiw1, val);
        if (ourHead == null) {
            throw new RuntimeException("Error!");
        }
        System.out.println("HERE --- " + ourHead.val + " -> " + ourHead.next.val);
        listNodeSiw1 = listNodeSiw1.next;
        while (listNodeSiw1.next != null) {
            System.out.println(arrayList);
            System.out.println("Check: " + listNodeSiw1.val);
            arrayList.add(listNodeSiw1.val);
            if (arrayList.contains(ourHead.val)) {
                System.out.println("TRUE");
                return;
            }
            listNodeSiw1 = listNodeSiw1.next;
        }
        arrayList.add(listNodeSiw1.val);
        if (arrayList.contains(ourHead.val)) {
            System.out.println("TRUE");
            return;
        }
        System.out.println("FALSE");
    }

    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1();
        ListNodeSiw1 l1 = new ListNodeSiw1(1);
        l1.next = new ListNodeSiw1(2);
        l1.next.next = new ListNodeSiw1(3);
        l1.next.next.next = new ListNodeSiw1(4);
        l1.next.next.next.next = new ListNodeSiw1(1);
        linkedList1.printLinkedList(l1);
        linkedList1.validateLinkedList(l1, 4);
    }
}

class ListNodeSiw1 {

    int val;
    ListNodeSiw1 next;

    ListNodeSiw1() {
    }

    ListNodeSiw1(int val) {
        this.val = val;
    }

    ListNodeSiw1(int val, ListNodeSiw1 next) {
        this.val = val;
        this.next = next;
    }
}
