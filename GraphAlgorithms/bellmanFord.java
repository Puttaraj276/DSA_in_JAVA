package GraphAlgorithms;

import java.util.*;

public class bellmanFord {
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) 
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void BellmanFord(List<Edge> edges, int V, int src){
        int dist[] = new int[V];
        int parent[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        parent[src] = -1;
        for (int i = 0; i < V - 1; i++){
            for (Edge edge : edges) 
            {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]){
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                    parent[edge.dest]=edge.src;
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }
        printSolution(dist, V);
    }

    public static void printSolution(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\t\t" + "INF");
            } else {
                System.out.println(i + "\t\t" + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; 
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));
        BellmanFord(edges, V, 0);
    }
}
