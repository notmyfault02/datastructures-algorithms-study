package cc.yaboong.ds.graph_hackerrank;

/**
 * Created by yaboong on 2018. 1. 26..
 */
public class GraphDriverHackerRank {
    public static void main(String[] args) {
        Graph g = new Graph(7);

//        g.addEdgeTo(0, 1);
//        g.addEdgeTo(1, 2);
//        g.addEdgeTo(2, 0);
//        g.addEdgeTo(2, 3);
//        g.addEdgeTo(3, 3);
//
//        g.BFS(2);
//        System.out.println("\n");
//        g.DFS(2);

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(0, 5);
        g.addEdges(0, 6);
        g.addEdges(5, 3);
        g.addEdges(5, 4);
        g.addEdges(3, 4);
        g.addEdges(4, 6);


        g.DFS(0);
    }
}
