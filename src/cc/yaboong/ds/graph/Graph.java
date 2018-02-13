package cc.yaboong.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaboong on 2018. 1. 26..
 */
public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;

    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
        visited = new boolean[v];
    }

    public void addEdgeTo(int v, int w) {
        adj[v].add(w);
    }

    public void addEdges(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()) {
            int currV = queue.poll();
            System.out.println(currV);
            int edgeCnt = adj[currV].size();
            for (int i=0; i<edgeCnt; i++) {
                int v = adj[currV].get(i);
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s);

        Iterator<Integer> iter = adj[s].listIterator();
        while(iter.hasNext()) {
            int v = iter.next();
            if (!visited[v])
                DFSUtil(v, visited);
        }
    }
}
