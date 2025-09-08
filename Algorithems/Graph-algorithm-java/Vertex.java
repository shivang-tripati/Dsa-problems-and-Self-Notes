import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Edge> edges;


    public Vertex(String inputData){
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endV, Integer weight) {
        this.edges.add(new Edge(this, endV, weight));
    }

    public void removeEdge(Vertex endV) {
        this.edges.removeIf(edge -> edge.getEndV().equals(endV));
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void print(boolean showWeight) {
        String message = "";

        if(this.edges.size() == 0) {
            System.out.println(this.data + " --> ");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if(i == 0) {
                message += this.edges.get(i).getStartV().data + " --> "; // print the first vertex, first
            }
 
            message += this.edges.get(i).getEndV().data;

            if(showWeight) {
                message += " ( " + this.edges.get(i).getWeight() + " ) " ;
            }

            if( i != this.edges.size() - 1) {
                message += ", ";
            }
        }

        System.out.println(message);
    }
}
