package cc.yaboong.ds.graph;

/**
 * Created by yaboong on 2018. 1. 26..
 */
public class HackerRankGraphDriver {
    public static void main(String[] args) {
        HackerRankGraph g = new HackerRankGraph(4);

        g.addEdgeTo(0, 1);
        g.addEdgeTo(1, 2);
        g.addEdgeTo(2, 0);
        g.addEdgeTo(2, 3);
        g.addEdgeTo(3, 3);

        g.BFS(2);
        System.out.println("\n");
        g.DFS(2);
    }
}
