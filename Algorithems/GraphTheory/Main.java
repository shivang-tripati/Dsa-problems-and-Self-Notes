package Algorithems.GraphTheory;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS starting from vertex 2:");
        g.DFS(2);

        System.out.println("BFS starting from vertex 2:");
        g.BFS(2);
    }
    
}
