import java.util.*;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Graph {
    List<List<Edge>> adjustancyList = null;

    Graph(List<Edge> edges, int N) {
        adjustancyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjustancyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjustancyList.get(edge.source).add(edge);
        }
    }
}

public class Problem1 {
    private static void extractRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            extractRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    public static void findShortestPathFromSourceToAllVertices(Graph graph, int source, int totalNodes) {
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(totalNodes, Integer.MAX_VALUE));

        dist.set(source, 0);

        boolean[] done = new boolean[totalNodes];
        done[source] = true;

        int[] prev = new int[totalNodes];
        prev[source] = -1;

        List<Integer> route = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();

            int u = node.vertex;

            for (Edge edge : graph.adjustancyList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            done[u] = true;
        }

        for (int i = 1; i < totalNodes; ++i) {
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                extractRoute(prev, i, route);
                System.out.println("Shortest path from (" + source + " —> " + i + "): " + route);
                route.clear();
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 4, 3));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 4, 4));
        edges.add(new Edge(2, 3, 9));
        edges.add(new Edge(3, 2, 7));
        edges.add(new Edge(4, 1, 1));

        final int totalNodes = 5;
        Graph graph = new Graph(edges, totalNodes);
        int source = 0;

        findShortestPathFromSourceToAllVertices(graph, source, totalNodes);
    }
}
