package GraphAlgorithms;
import java.util.*;
public class bellmanFord {
    static class Edge {
        int s, d, w;
        Edge(int src, int dest, int weight) 
        {
            this.s = src;
            this.d= dest;
            this.w = weight;
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
                if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.s] + edge.w < dist[edge.d]){
                    dist[edge.d] = dist[edge.s] + edge.w;
                    parent[edge.d]=edge.s;
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.s] + edge.w< dist[edge.d]) {
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
