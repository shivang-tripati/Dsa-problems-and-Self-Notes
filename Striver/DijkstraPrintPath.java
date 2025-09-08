// DijkstraPrintPath.java
import java.util.*;

public class DijkstraPrintPath {

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int edges[][] = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        DijkstraPrintPath obj = new DijkstraPrintPath();
        List<Integer> path = obj.shortestPath(n, m, edges);
        System.out.println(path);
    }

    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            // node a -> edges[i][0], node b -> edges[i][1], weight of edge a to b -> edges[i][2]
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair( edges[i][2], edges[i][0]));
        }
        
        // Min-heap priority queue to get the node with the smallest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        
        // Initialize the distance to the source node (node 1)
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        
        // Dijkstra's algorithm
        while (pq.size() != 0) {
            Pair pair = pq.poll();
            int dis = pair.distance;
            int node = pair.node;
            
            for (Pair adjPair : adj.get(node)) {
                int adjNode = adjPair.node;
                int edgeW = adjPair.distance;
                
                if (dis + edgeW < dist[adjNode]) {
                    dist[adjNode] = dis + edgeW;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        
        // Retrieve the path
        List<Integer> path = new ArrayList<>();

        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        path.add(dist[n]);
        
        System.out.println(path);
        // Reverse the path to start from node 1
        Collections.reverse(path);

        System.out.println(path);
        
        return path;
    }
}



class Pair {
    int distance;
    int node;    
     Pair(int w, int v) {
        this.distance = w;
        this.node = v;
    }
}
