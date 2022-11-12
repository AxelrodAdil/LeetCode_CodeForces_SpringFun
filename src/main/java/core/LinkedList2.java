package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class LinkedList2 {

    private static void printLinkedList(ListNodeSiw2 listNodeSiw2) {
        while (listNodeSiw2.next != null) {
            System.out.print(listNodeSiw2.val + "->");
            listNodeSiw2 = listNodeSiw2.next;
        }
        System.out.print(listNodeSiw2.val + "->");
        System.out.print("null");
        System.out.println();
    }

    private ListNodeSiw2 getFirstListNodeSiw2(ListNodeSiw2 listNodeSiw2, int val) {
        if (listNodeSiw2.val == val) return listNodeSiw2;
        while (listNodeSiw2.next != null) {
            if (listNodeSiw2.val == val) {
                var nodeSiw2 = new ListNodeSiw2(listNodeSiw2.prev.val);
                nodeSiw2.next = new ListNodeSiw2(listNodeSiw2.val);
                printLinkedList(nodeSiw2);
                return nodeSiw2;
            }
            listNodeSiw2 = listNodeSiw2.next;
        }
        return null;
    }

    private ListNodeSiw2 getSortedLinkedList(ArrayList<Integer> arrayList) {
        System.out.println("DONE!!!");
        if (arrayList == null || arrayList.isEmpty()) return null;
        if (arrayList.size() == 1) return new ListNodeSiw2(arrayList.get(0));
        Collections.sort(arrayList);
        var ans = new ListNodeSiw2(arrayList.get(0));
        arrayList.forEach(integer -> ans.next = new ListNodeSiw2(integer));
        System.out.println("SORTED : ");
        printLinkedList(ans);
        return ans;
    }

    private void sortLinkedList(ListNodeSiw2 listNodeSiw2, int val) {
        ArrayList<Integer> arrayListLeft = new ArrayList<>();
        ArrayList<Integer> arrayListRight = new ArrayList<>();
        var ourHead = getFirstListNodeSiw2(listNodeSiw2, val);
        Objects.requireNonNull(ourHead, "Error!");
        System.out.println("HERE --- |" + ourHead.val + "| ");
        while (listNodeSiw2.next != null) {
            if (listNodeSiw2.val == ourHead.val) {
                System.out.println("checkIt - " + listNodeSiw2.val + " " + ourHead.val);
                listNodeSiw2 = listNodeSiw2.next.next;
                continue;
            }
            if (listNodeSiw2.val < ourHead.val) arrayListLeft.add(listNodeSiw2.val);
            else arrayListRight.add(listNodeSiw2.val);
            listNodeSiw2 = listNodeSiw2.next;
        }
        arrayListRight.add(listNodeSiw2.val);
        System.out.println(arrayListLeft);
        System.out.println(arrayListRight);
        var left = getSortedLinkedList(arrayListLeft);

        ListNodeSiw2 list2 = new ListNodeSiw2();
        var tempLeft = list2.sortedMerge(left, ourHead);
        printLinkedList(tempLeft);
        var right = getSortedLinkedList(arrayListRight);
        var ans = list2.sortedMerge(tempLeft, right);
        printLinkedList(ans);
    }

    public static void main(String[] args) {
        LinkedList2 linkedList2 = new LinkedList2();
        ListNodeSiw2 l = new ListNodeSiw2(1, null);
        l.next = new ListNodeSiw2(2, l);
        l.next.next = new ListNodeSiw2(4, l.next);
        l.next.next.next = new ListNodeSiw2(3, l.next.next);
        l.next.next.next.next = new ListNodeSiw2(1, l.next.next.next);
        l.next.next.next.next.next = new ListNodeSiw2(5, l.next.next.next.next);
        l.next.next.next.next.next.next = new ListNodeSiw2(4, l.next.next.next.next.next);
        l.next.next.next.next.next.next.next = new ListNodeSiw2(7, l.next.next.next.next.next.next);
        printLinkedList(l);
        linkedList2.sortLinkedList(l, 7);
    }
}

class ListNodeSiw2 {

    int val;
    ListNodeSiw2 next;
    ListNodeSiw2 prev;

    ListNodeSiw2() {
    }

    ListNodeSiw2(int val) {
        this.val = val;
    }

    ListNodeSiw2(int val, ListNodeSiw2 prev) {
        this.val = val;
        this.prev = prev;
    }

    ListNodeSiw2(int val, ListNodeSiw2 next, ListNodeSiw2 prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public ListNodeSiw2 sortedMerge(ListNodeSiw2 A, ListNodeSiw2 B) {
        if (A == null) return B;
        if (B == null) return A;
        A.next = sortedMerge(A.next, B);
        return A;
    }
}
