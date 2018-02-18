package cc.yaboong.ds.graph;

import java.util.Stack;

/**
 * Created by yaboong on 2018. 2. 19..
 */
public class GraphDriver {
    public static void main(String[] args) {
        Graph g = new Graph(13);

        g.addEdge(0, 5);
        g.addEdge(4, 3);
        g.addEdge(0, 1);
        g.addEdge(9, 12);
        g.addEdge(6, 4);
        g.addEdge(5, 4);
        g.addEdge(0, 2);
        g.addEdge(11, 12);
        g.addEdge(9, 10);
        g.addEdge(0, 6);
        g.addEdge(7, 8);
        g.addEdge(9, 11);
        g.addEdge(5, 3);


        int source = 0, dest = 3;

        DepthFirstPaths path = new DepthFirstPaths(g, source);

        Stack<Integer> stack = (Stack<Integer>) path.pathTo(dest);
        if (stack == null) {
            System.out.print("No path from " + source + " to " + dest);
        } else {
            while(!stack.isEmpty()) {
                int item = stack.pop();
                System.out.print(stack.isEmpty() ? item : item + "->");
            }
        }
    }
}
