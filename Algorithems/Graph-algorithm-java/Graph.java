import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    
    public Graph(boolean inputIsWeighted, boolean inputIsDirected ) {
        this.vertices = new ArrayList<Vertex>();
        this.isDirected = inputIsDirected;
        this.isWeighted = inputIsWeighted;
    }
    public Vertex addVertex(String Data){
        Vertex newVertex = new Vertex(Data);
        this.vertices.add(newVertex);
        return newVertex;
    }
    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if(!this.isWeighted){
            weight = null;
        }

        vertex1.addEdge(vertex2, weight);

        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if(!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public Vertex getVertexvByValue(String value) {
        for(Vertex v: this.vertices) {
            if(v.getData() == value) {
                return v;
            }
        }
        return null;
    }

    public void print() {
        for( Vertex v : this.vertices) {
            v.print(isWeighted);
        }
    }



    public static void main(String[] args) {
        Graph busNetwork =  new Graph(true, false);
        Vertex gkpStation = busNetwork.addVertex("gkp");
        Vertex kanputStation = busNetwork.addVertex("Kanpur");
        Vertex lucknowStation = busNetwork.addVertex("Lucknow");
        Vertex bastiStation = busNetwork.addVertex("basti");
        Vertex delhiStation = busNetwork.addVertex("delhi");

        busNetwork.addEdge(gkpStation, kanputStation, 450);
        busNetwork.addEdge(bastiStation, delhiStation, 640);
        busNetwork.addEdge(bastiStation, kanputStation, 340);
        busNetwork.addEdge(gkpStation, delhiStation, 700);
        busNetwork.addEdge(lucknowStation, delhiStation, 350);
        busNetwork.addEdge(gkpStation, lucknowStation, 250);

        busNetwork.print();
    }
}