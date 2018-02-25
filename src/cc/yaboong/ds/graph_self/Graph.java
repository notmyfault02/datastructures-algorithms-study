package cc.yaboong.ds.graph_self;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yaboong on 2018. 2. 19..
 */
public class Graph {
    private final int V;
    private LinkedList<Integer>[] adj;
    private boolean[] marked;
    private int[] edgeTo;

    public Graph(int V) {
        this.V = V;
        this.marked = new boolean[V];
        this.edgeTo = new int[V];
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    public void addEdges(int v, int w) {
        adj[v].addFirst(w);
        adj[w].addFirst(v);
    }

    public Iterable<Integer> adj(int v) { return adj[v]; }

    public int V() { return V; }

    public void dfs(int v) {
        marked[v] = true;
        System.out.println(v);
        for (int w : adj[v])
            if (!marked[w]) {
                dfs(w);
                edgeTo[w] = v;
            }
    }

    private boolean hasPathTo(int v) { return marked[v]; }

    public Iterable<Integer> pathFromTo(int src, int dest) {
        dfs(src);
        if (!hasPathTo(dest)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = dest; x != src; x = edgeTo[x]) // edgeTo[x] 로 x 를 업데이트
            path.push(x);
        path.push(src);
        return path;
    }
}