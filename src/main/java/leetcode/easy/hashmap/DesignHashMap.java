package leetcode.easy.hashmap;

public class DesignHashMap {

    // https://leetcode.com/problems/design-hashmap/

    /*
    Runtime: 57 ms, faster than 43.62% of Java online submissions for Design HashMap.
    Memory Usage: 59.9 MB, less than 84.16% of Java online submissions for Design HashMap.
     */

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(0, 0);
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(5, 3);

        for (int i = 0; i < myHashMap.data.length; i++) {
            System.out.println(myHashMap.get(i));
        }
    }
}

class MyHashMap {

    static class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    static final int size = 16;
    static final int mult = 12582917;
    ListNode[] data;

    public MyHashMap() {
        this.data = new ListNode[size];
    }

    private int hash(int key) {
//        return (int) ((long) key * mult % size);
        return key;
    }

    public void put(int key, int val) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key, val, data[h]);
        data[h] = node;
    }

    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        for (; node != null; node = node.next) {
            if (node.key == key) return node.val;
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if (node == null) return;

        if (node.key == key) {
            data[h] = node.next;
        } else {
            for (; node.next != null; node = node.next) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
            }
        }
    }
}
