package Algorithems.GraphTheory;
import java.util.*;

public class Graph {
    private int V; // no. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    @SuppressWarnings("unchecked")
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++ ) {
            adj[i] = new LinkedList<>();
        }
    }

    // function to add an edge into graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSutil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]){
                DFSutil(n, visited);
            }
        }
    }

    // DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking.
    // Dfs Traversal of the vertices reachable from v
    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSutil(v, visited);
    }


    // BFS is a graph traversal algorithm that explores all the vertices in the graph level by level.
    // BFS traversal of the vertices reachable from v
    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    // Function to print connected components
    void printConnectedComponents() {
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSutil(i, visited);
                System.out.println();
            }
        }
    }

     

    
}