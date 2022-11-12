package core;

import java.util.LinkedList;

public class DFS {

    private final int V;
    private final LinkedList<Integer>[] adjacency;

    @SuppressWarnings("unchecked")
    DFS(int v) {
        V = v;
        adjacency = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacency[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adjacency[v].add(w);
    }


    void dfsGraph(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adjacency[v]) {
            if (!visited[n])
                dfsGraph(n, visited);
        }
    }

    void dfsMainMethod(int v) {
        boolean[] visited = new boolean[V];
        dfsGraph(v, visited);
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        dfs.dfsMainMethod(2);
    }
}
