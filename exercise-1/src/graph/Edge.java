package graph;

public class Edge {

    private Vertex vertexA;
    private Vertex vertexB;

    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Vertex getVertexA() {
        return vertexA;
    }

    public Vertex getVertexB() {
        return vertexB;
    }

    public void setVertexA(Vertex vertexA) {
        this.vertexA = vertexA;
    }

    public void setVertexB(Vertex vertexB) {
        this.vertexB = vertexB;
    }

}