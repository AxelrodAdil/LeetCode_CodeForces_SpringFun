package core;

public class CollectionLinkedList {
    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.sort(2);

        Node nodeMap = new Node(5);
        nodeMap = addFirst(nodeMap, 10);
        nodeMap = addFirst(nodeMap, 15);
        System.out.println(nodeMap.data);
        System.out.println(size(nodeMap));
        System.out.println(getLast(nodeMap));

        System.out.println("-----------------------");
        nodeMap = addLast(nodeMap, 25);
        System.out.println(nodeMap.data);
        System.out.println(getLast(nodeMap));
        System.out.println("-----------------------");
        System.out.println(indexOf(nodeMap, 25));
        System.out.println(getByIndex(nodeMap, 3));
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println(removeElem(nodeMap, 25).data);
    }

    public static Node reverse(Node nodeMap) {
        Node prev = null;
        while (nodeMap != null){
            Node next = nodeMap.next;
            nodeMap.next = prev;
            prev = nodeMap;
            nodeMap = next;
        }
        return prev;
    }

    public static Node solve1(Node nodeMap){
        if(nodeMap == null || nodeMap.next == null){
            return nodeMap;
        }

        Node cur = nodeMap;
        while (cur != null){
            Node iteration = cur;
            Node min = iteration;
            while (iteration != null){
                if(iteration.data < min.data){
                    min = iteration;
                }
                iteration = iteration.next;
            }
            int temp = cur.data;
            cur.data = min.data;
            min.data = temp;
            cur = cur.next;
        }
        return nodeMap;
    }

    public static Node sort(Node nodeMap) {
        if (nodeMap == null || nodeMap.next == null) {
            return nodeMap;
        }
        Node head = nodeMap;
        Node temp = nodeMap;
        Node first = nodeMap;
        while (first != null && first.next != null) {
            head = temp;
            temp = temp.next;
            first = first.next.next;
        }
        temp.next = null;
        Node left = sort(nodeMap);
        Node right = sort(temp);
        return merge(left, right);
    }

    public static Node mergeSort(Node l1, Node l2) {
        Node sorted = new Node(0);
        Node cur = sorted;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }
        if (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }
        return sorted.next;
    }

    public static String toString(Node nodeMap) {
        try {
            StringBuilder sb = new StringBuilder();
            while (nodeMap != null) {
                sb.append(nodeMap.data);
                nodeMap = nodeMap.next;
                if(nodeMap !=null){
                    sb.append(" -> ");
                }
            }
            return sb.toString();
        } catch (NullPointerException e) {
            return "";
        }
    }

    public static int[] toArray(Node nodeMap) {
        try {
            int sizeNumber = size(nodeMap);
            int[] arr = new int[sizeNumber];
            int id = 0;
            while (nodeMap != null) {
                arr[id++] = nodeMap.data;
                nodeMap = nodeMap.next;
            }
            return arr;
        } catch (NullPointerException e) {
            return new int[]{};
        }
    }

    public static boolean isSorted(Node nodeMap) {
        try {
            Node curr = nodeMap;
            Node prev = curr;
            if(curr.data > curr.next.data){
                return false;
            }
            curr = curr.next;
            while (curr != null) {
                if(prev.data > curr.data){
                    return false;
                }
                prev = curr;
                curr = curr.next;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static Node merge(Node nodeMap1, Node nodeMap2) {
        try {
            Node temp = nodeMap1;
            while (nodeMap1.next != null) {
                nodeMap1 = nodeMap1.next;
            }
            nodeMap1.next = nodeMap2;
            return temp;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static Node removeByIndex(Node nodeMap, int index) {
        Node curr = nodeMap;
        Node prev = null;
        int id = 0;
        while (curr != null && id != index) {
            prev = curr;
            curr = curr.next;
            id++;
        }
        if (curr != null) {
            if (null == prev) {
                nodeMap = nodeMap.next;
            } else {
                prev.next = curr.next;
            }
        }
        return nodeMap;
    }

    public static Node removeElem(Node nodeMap, int data) {
        Node curr = nodeMap;
        Node prev = null;
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            if (null == prev) {
                nodeMap = nodeMap.next;
            } else {
                prev.next = curr.next;
            }
        }
        return nodeMap;
    }

    public static int getByIndex(Node nodeMap, int index) {
        if (nodeMap == null) {
            return -1;
        }
        int id = 0;
        while (nodeMap.next != null) {
            if (id == index) {
                return nodeMap.data;
            }
            nodeMap = nodeMap.next;
            id++;
        }
        if (id == index) return nodeMap.data;
        return -1;
    }

    public static int indexOf(Node nodeMap, int data) {
        if (nodeMap == null) {
            return -1;
        }
        int id = 0;
        while (nodeMap.next != null) {
            if (nodeMap.data == data) {
                return id;
            }
            nodeMap = nodeMap.next;
            id++;
        }

        if (nodeMap.data == data) {
            return id;
        }
        return -1;
    }

    public static Node addLast(Node nodeMap, int newData) {
        if (nodeMap == null) {
            return new Node(newData);
        }
        Node temp = nodeMap;
        Node tempNodeMap = new Node(newData);
        while (nodeMap.next != null) {
            nodeMap = nodeMap.next;
        }
        nodeMap.next = tempNodeMap;
        return temp;
    }

    public static int getLast(Node nodeMap) {
        try{
            while (nodeMap.next!=null){
                nodeMap = nodeMap.next;
            }
        } catch (NullPointerException e){
            return 0;
        }
        return nodeMap.data;
    }

    public static Node addFirst(Node nodeMap, int newData) {
        Node temp = new Node(newData);
        temp.next = nodeMap;
        nodeMap = temp;
        return nodeMap;
    }

    public static Node addFirst(Node nodeMap, Node newNodeMap) {
        newNodeMap.next = nodeMap;
        nodeMap = newNodeMap;
        return nodeMap;
    }

    public static int size(Node nodeMap) {
        int i = 1;
        try{
            while (nodeMap.next!=null){
                i++;
                nodeMap = nodeMap.next;
            }
        } catch (NullPointerException e){
            return 0;
        }
        return i;
    }
}

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(){}

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
