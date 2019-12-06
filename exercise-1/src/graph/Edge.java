package graph;

public class Edge {

    private Vertex vertexA;
    private Vertex vertexB;

    private int weight;

    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = 0;
    }

    public Edge(Vertex vertexA, int weight, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void swapVertices() {
        Vertex tmp = this.vertexA;
        this.vertexA = this.vertexB;
        this.vertexB = tmp;
    }
}