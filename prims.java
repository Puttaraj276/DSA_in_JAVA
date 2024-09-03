package GraphAlgorithms;
import java.util.*;
class prims{
    public static void prim(int source, List<List<Pair<Integer, Integer>>> graph, int n) {
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[source] = 0;
        boolean[] inMST = new boolean[n];
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        heap.add(new Pair<>(0, source));
        int totalCost = 0;
        while (!heap.isEmpty()) {
            Pair<Integer, Integer> curr = heap.remove();
            int cost = curr.getKey();
            int node = curr.getValue();
            if (inMST[node]) {
                continue;
            }
            inMST[node] = true;
            totalCost += cost;
            for (Pair<Integer, Integer> edge : graph.get(node)) {
                int nei = edge.getKey();
                int weight = edge.getValue();

                if (!inMST[nei] && weight < minCost[nei]) {
                    minCost[nei] = weight;
                    heap.add(new Pair<>(weight, nei));
                }
            }
        }
        System.out.println("Total cost of the MST: " + totalCost);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair<>(1, 2));
        graph.get(0).add(new Pair<>(3, 6));
        graph.get(1).add(new Pair<>(0, 2));
        graph.get(1).add(new Pair<>(2, 3));
        graph.get(1).add(new Pair<>(3, 8));
        graph.get(1).add(new Pair<>(4, 5));
        graph.get(2).add(new Pair<>(1, 3));
        graph.get(2).add(new Pair<>(4, 7));
        graph.get(3).add(new Pair<>(0, 6));
        graph.get(3).add(new Pair<>(1, 8));
        graph.get(4).add(new Pair<>(1, 5));
        graph.get(4).add(new Pair<>(2, 7));
        prim(0, graph, n);
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
