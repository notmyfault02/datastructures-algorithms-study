package cc.yaboong.ds.graph_coursera;

import java.util.LinkedList;

/**
 * Created by yaboong on 2018. 2. 19..
 */
public class Graph {
    private final int V;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
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
}