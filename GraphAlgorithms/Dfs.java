package GraphAlgorithms;
import java.util.ArrayList;

class Dfs{
    static class Edge{
        int source;
        int dest;
        int weight;
        public Edge(int s,int d,int w)
        {
            this.source=s;
            this.dest=d;
        }
    }
    public static void main(String[] args) {
        int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        dfs(graph,0, new boolean[v]);
    }
    static void createGraph(ArrayList<Edge> graph[]) 
    {
        for(int i=0; i<graph.length; i++)
        graph[i] = new ArrayList<>();
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }
    static void dfs(ArrayList<Edge>[] graph,int cur,boolean visited[])
    {
        if(visited[cur])
        return;
        System.out.print(cur+" ");
        visited[cur]=true;
        for(int i=0;i<graph[cur].size();i++)
        {
            Edge e=graph[cur].get(i);
            dfs(graph,e.dest,visited);
        }
    }
}