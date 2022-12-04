package core;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Dijkstra {
    private final int[] dist;
    private final Set<Integer> settled;
    private final PriorityQueue<NodeGraph> pq;
    private final int V;
    List<List<NodeGraph>> adj;

    public Dijkstra(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new NodeGraph());
    }

    private void eNeighbours(int u) {
        log.info("\n\neNeighbours()");
        log.info("eNeighbours {}", u);
        int edgeDistance;
        int newDistance;
        for (int i = 0; i < adj.get(u).size(); i++) {
            NodeGraph v = adj.get(u).get(i);
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
                log.info("edgeDistance {}", edgeDistance);
                log.info("newDistance {}", newDistance);
                if (newDistance > dist[v.node]) {
                    log.info("newDistance - {} < dist[v.node] - {}", newDistance, dist[v.node]);
                    dist[v.node] = newDistance;
                    log.info("dist[v.node] - {}", dist[v.node]);
                }
                log.info("Adding to PQ: {}", new NodeGraph(v.node, dist[v.node]));
                pq.add(new NodeGraph(v.node, dist[v.node]));
            }
        }
    }

    public void getDijkstra(List<List<NodeGraph>> adj, int src) {
        log.info("\n\ngetDijkstra()");
        this.adj = adj;
        IntStream.range(0, V).forEachOrdered(i -> dist[i] = Integer.MIN_VALUE);
        pq.add(new NodeGraph(src, 0));
        dist[src] = 0;

        while (settled.size() != V) {
            log.info("\nSettled {}", settled);
            if (pq.isEmpty()) return;
            int u = pq.remove().node;
            log.info("At {} - {}", settled.size(), u);
            if (settled.contains(u)) continue;
            settled.add(u);
            eNeighbours(u);
        }
    }

    public static void main(String[] arg) {
        int V = 6;
        int source = 0;
        List<List<NodeGraph>> adj = IntStream.range(0, V).<List<NodeGraph>>mapToObj(
                i -> new ArrayList<>()).collect(Collectors.toList()
        );

        adj.get(0).add(new NodeGraph(1, 9));
        adj.get(0).add(new NodeGraph(2, 6));
        adj.get(0).add(new NodeGraph(3, 5));
        adj.get(0).add(new NodeGraph(4, 3));

        adj.get(2).add(new NodeGraph(1, 2));
        adj.get(2).add(new NodeGraph(3, 4));

        adj.get(4).add(new NodeGraph(5, 2));
        adj.get(5).add(new NodeGraph(1, 1));

        Dijkstra dijkstra = new Dijkstra(V);
        dijkstra.getDijkstra(adj, source);

        System.out.println("\n\nThe shorted path from node :");
        for (int i = 0; i < dijkstra.dist.length; i++) {
            String s = source + " to " + i + " is " + dijkstra.dist[i];
            System.out.println(s);
        }
    }
}

class NodeGraph implements Comparator<NodeGraph> {
    public int node;
    public int cost;

    public NodeGraph() {
    }

    public NodeGraph(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(NodeGraph node1, NodeGraph node2) {
        return Integer.compare(node1.cost, node2.cost);
    }
}