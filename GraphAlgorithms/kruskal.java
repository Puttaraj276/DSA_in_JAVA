package GraphAlgorithms;
import java.util.*;
public class kruskal{
    static class Edge{
        int s,d,w;
        public Edge(int s,int d,int w)
        {
            this.s=s;this.d=d;this.w=w;
        }
    }
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 2, 25));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(1, 4, 20));
        edges.add(new Edge(2, 3, 50));
        edges.add(new Edge(2, 4, 35));
        edges.add(new Edge(3, 4, 45));
        edges.add(new Edge(3, 5, 55));
        edges.add(new Edge(4, 5, 60));


        for (Edge edge : edges)
            System.out.println("Source: " + edge.s + ", Destination: " + edge.d + ", Weight: " + edge.w);
        int[] arr = new int[5];
        for(int i=0;i<5;i++)
        arr[i]=i;
        kruskalAlgorithm(edges,arr);
    }
    public static void kruskalAlgorithm(List<Edge> edges, int[] arr)
    {
        Collections.sort(edges,new Comparator<Edge>(){
            @Override
            public int compare(Edge e1,Edge e2)
            {
                return e1.w-e2.w;
            }
        });
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            Edge e = edges.get(i);
            if(find(arr,e.s,e.d)==0)
            {
            sum+=e.w;
            System.out.println(e.s+"->"+e.d+"="+e.w);
            union(arr,e.s, e.d);
            }
        }
        System.out.println("weight of MST is: "+sum);
    }
    static void union(int[] arr,int u,int v)
    {
        int temp =arr[u];
        for(int i=0;i<arr.length;i++)
        if(arr[i]==temp)
        arr[i]=arr[v];
    }
    static int find(int[] arr,int u,int v)
    {
        if(arr[u]==arr[v])
        return 1;
        else
        return 0;
    }
}
