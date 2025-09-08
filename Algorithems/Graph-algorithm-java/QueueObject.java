public class QueueObject implements Comparable<QueueObject> {
    public Vertex vertex;
    public int priority;

    public QueueObject(Vertex v, int p) {
        this.priority = p;
        this.vertex = v;
    }

    @Override
    public int compareTo(QueueObject o) {
        return Integer.compare(this.priority, o.priority);
    }
}

