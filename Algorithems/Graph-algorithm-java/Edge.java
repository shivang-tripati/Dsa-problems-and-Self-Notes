public class Edge {
    private Vertex start;
    private Vertex end;
    Integer weight;


    public Edge(Vertex startV, Vertex endV, Integer inputWeight ) {
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }

    public Vertex getEndV() {
        return this.end;
    }

    public Vertex getStartV(){
        return this.start;
    }

    public Integer getWeight(){
        return this.weight;
    }
}
