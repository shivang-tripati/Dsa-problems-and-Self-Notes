import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
    
    public static Map<String, Integer>[] dijkstra(Graph g, Vertex startingVertex) {
        
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Vertex> previous = new HashMap<>();

        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex v : g.getVertices()) {
            if(v != startingVertex) {
                distances.put(v.getData(), Integer.MAX_VALUE);
            }

            previous.put(v.getData(), null);
        }
        distances.put(startingVertex.getData(), 0);
            
        while(!queue.isEmpty()) {
            QueueObject currVertex =  queue.poll();

            for(Edge e : currVertex.vertex.getEdges()) {
                Integer alternative = distances.get(currVertex.vertex.getData()) + e.getWeight();
                String neighbourValue = e.getEndV().getData();

                if(alternative < distances.get(neighbourValue)) {
                    distances.put(neighbourValue, alternative);
                    previous.put(neighbourValue, currVertex.vertex);
                    queue.add(new QueueObject(e.getEndV(), distances.get(neighbourValue)));

                }
            }   
        }

        return new Map[] {distances, previous};

    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        Map<String, Integer>[] dijkstraMaps = dijkstra(g, startingVertex);
        Map<String, Integer> distances = dijkstraMaps[0];
        Map<String, Vertex> previous = dijkstraMaps[1];

        Integer distance = distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (v != null) {
            path.add(0, v);
            v = previous.get(v.getData());
        }
        System.out.println("Shortest Path");
        for (Vertex pathVertex: path){
            System.out.println(pathVertex.getData());
        }

    }


    public static void dijkstraResultPrinter(Map<String, Integer>[] d){
        System.out.println("Distances:\n");
        for (String key : d[0].keySet()) {
            System.out.println(key + ": " + d[0].get(key));
        }
        System.out.println("\nPrevious:\n");
        for (String key : d[1].keySet()) {
            Vertex nextVertex = d[1].get(key);
            System.out.println(key + ": " + (nextVertex == null ? "Null" : nextVertex.getData()));
        }
    }


    public static void main(String[] args){
        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, 2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, 50);

        dijkstraResultPrinter(dijkstra(testGraph, a));
        shortestPathBetween(testGraph, a, g);
    }
}

