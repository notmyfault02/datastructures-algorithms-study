package cc.yaboong.ds.graph_coursera;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaboong on 2018. 2. 21..
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        int v = G.V();
        this.marked = new boolean[v];
        this.edgeTo = new int[v];
        this.s = s;
    }

    public void bfs(Graph G, int s)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty())
        {
            int v = q.poll();
            for (int w : G.adj(v))
            {
                if (!marked[w])
                {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
