package GraphAlgorithms;
import java.util.*;
class dijkstra{
    public static void Dijkstra(int source, List<List<Pair<Integer, Integer>>> graph, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        heap.add(new Pair<>(0, source));

        while (!heap.isEmpty()) {
            Pair<Integer, Integer> curr = heap.remove();
            int currDist = curr.getKey();
            int node = curr.getValue();
            if (currDist > distances[node])
                continue;
            for (Pair<Integer, Integer> edge : graph.get(node)) {
                int nei = edge.getKey();
                int weight = edge.getValue();
                int dist = currDist + weight;
                if (dist < distances[nei]) {
                    distances[nei] = dist;
                    heap.add(new Pair<>(dist, nei));
                }
            }
        }
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " has distance " + distances[i]);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 10));
        graph.get(0).add(new Pair<>(4, 3));
        graph.get(1).add(new Pair<>(2, 2));
        graph.get(2).add(new Pair<>(3, 9));
        graph.get(4).add(new Pair<>(1, 4));
        graph.get(4).add(new Pair<>(2, 8));

        Dijkstra(0, graph, n);
        for(List<Pair<Integer,Integer>> list: graph){
        for(Pair<Integer,Integer> pair:list)
        System.out.print("("+pair.getKey()+","+pair.getValue()+") ");
        System.out.println();
        }
    }
}
class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}