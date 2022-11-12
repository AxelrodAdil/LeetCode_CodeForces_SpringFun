package core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class BFS {

    private final int V;
    private final LinkedList<Integer>[] adjacency;
    private final Queue<Integer> queue;

    @SuppressWarnings("unchecked")
    BFS(int v) {
        V = v;
        adjacency = new LinkedList[v];
        IntStream.range(0, v).forEach(i -> adjacency[i] = new LinkedList<>());
        queue = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adjacency[v].add(w);
    }

    void bfsGraph(int n) {
        boolean[] nodes = new boolean[V];
        int a = 0;

        nodes[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();
            System.out.print(n + " ");

            for (int i = 0; i < adjacency[n].size(); i++) {
                a = adjacency[n].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(7);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        System.out.println(bfs.V + "  !!!  " + Arrays.toString(bfs.adjacency) + "  !!!  " + bfs.queue.toString());
        bfs.bfsGraph(2);
    }
}
