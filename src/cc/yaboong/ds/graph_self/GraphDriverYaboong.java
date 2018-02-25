package cc.yaboong.ds.graph_self;

import java.util.Stack;

/**
 * Created by yaboong on 2018. 2. 22..
 */
public class GraphDriverYaboong {
    public static void main(String[] args) {
        Graph g1 = new Graph(13);

        g1.addEdges(0, 5);
        g1.addEdges(4, 3);
        g1.addEdges(0, 1);
        g1.addEdges(9, 12);
        g1.addEdges(6, 4);
        g1.addEdges(5, 4);
        g1.addEdges(0, 2);
        g1.addEdges(11, 12);
        g1.addEdges(9, 10);
        g1.addEdges(0, 6);
        g1.addEdges(7, 8);
        g1.addEdges(9, 11);
        g1.addEdges(5, 3);

        int source = 0, destination = 3;

        Stack<Integer> stack = (Stack<Integer>) g1.pathFromTo(source, destination);
        if (stack == null) {
            System.out.println("No path from " + source + " to " + destination);
        } else {
            while(!stack.isEmpty()) {
                int item = stack.pop();
                System.out.print(stack.isEmpty() ? item : item + "->");
            }
            System.out.println();
        }

        Graph g2 = new Graph(6);
        g2.addEdges(0, 5);
        g2.addEdges(2, 4);
        g2.addEdges(2, 3);
        g2.addEdges(1, 2);
        g2.addEdges(0, 1);
        g2.addEdges(3, 4);
        g2.addEdges(3, 5);
        g2.addEdges(0, 2);

        g2.bfs(0);
    }
}
