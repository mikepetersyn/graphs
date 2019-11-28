package graph;

public class Edge {

    private Vertex vA;
    private Vertex vB;

    public Edge(Vertex vA, Vertex vB) {
        this.vA = vA;
        this.vB = vB;
    }

    public Vertex getvA() {
        return vA;
    }

    public Vertex getvB() {
        return vB;
    }

    public void setvA(Vertex vA) {
        this.vA = vA;
    }

    public void setvB(Vertex vB) {
        this.vB = vB;
    }

}

