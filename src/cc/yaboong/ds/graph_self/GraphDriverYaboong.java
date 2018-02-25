package cc.yaboong.ds.graph_self;

import java.util.Stack;

/**
 * Created by yaboong on 2018. 2. 22..
 */
public class GraphDriverYaboong {
    public static void main(String[] args) {
        Graph g = new Graph(13);

        g.addEdges(0, 5);
        g.addEdges(4, 3);
        g.addEdges(0, 1);
        g.addEdges(9, 12);
        g.addEdges(6, 4);
        g.addEdges(5, 4);
        g.addEdges(0, 2);
        g.addEdges(11, 12);
        g.addEdges(9, 10);
        g.addEdges(0, 6);
        g.addEdges(7, 8);
        g.addEdges(9, 11);
        g.addEdges(5, 3);

        int source = 0, destination = 3;

        Stack<Integer> stack = (Stack<Integer>) g.pathFromTo(source, destination);
        if (stack == null) {
            System.out.println("No path from " + source + " to " + destination);
        } else {
            while(!stack.isEmpty()) {
                int item = stack.pop();
                System.out.print(stack.isEmpty() ? item : item + "->");
            }
            System.out.println();
        }
    }
}
