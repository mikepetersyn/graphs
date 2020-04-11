package graph.primitives;

/**
 * Represents an edge within a graph
 */
public class Edge {

    /**
     * First {@link graph.primitives.Vertex} object of the edge.
     */
    private Vertex vertexA;

    /**
     * Second {@link graph.primitives.Vertex} object of the edge.
     */
    private Vertex vertexB;

    /**
     * Indicates the weight of an edge.
     */
    private int weight;

    /**
     * Indicates if an edge is directed or not. The actual direction is given from
     * {@link #vertexA} to {@link #vertexB}.
     */
    private boolean isDirected;

    /**
     * Creates a non-weighted edge with two {@link graph.primitives.Vertex} objects
     * 
     * @param vertexA first vertex object
     * @param vertexB second vertex object
     */
    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = 0;
        this.isDirected = false;
    }

    /**
     * Creates a weighted edge with two {@link graph.primitives.Vertex} objects.
     * 
     * @param vertexA first vertex object
     * @param weight  weight of the edge
     * @param vertexB second vertex object
     */
    public Edge(Vertex vertexA, int weight, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
        this.isDirected = false;
    }

    /**
     * Creates a non-weighted edge with two {@link graph.primitives.Vertex} objects.
     * If declared, this edge is also directed and the first vertex object
     * represents the starting vertex, whereas the second vertex object represents
     * the ending vertex.
     * 
     * @param vertexA    first vertex object
     * @param weight     weight of the edge
     * @param vertexB    second vertex object
     * @param isDirected if true, the edge has an orientation
     */
    public Edge(Vertex vertexA, Vertex vertexB, boolean isDirected) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.isDirected = isDirected;
    }

    /**
     * Creates a weighted edge with two {@link graph.primitives.Vertex} objects. If
     * declared, this edge is also directed and the first vertex object represents
     * the starting vertex, whereas the second vertex object represents the ending
     * vertex.
     * 
     * @param vertexA    first vertex object
     * @param weight     weight of the edge
     * @param vertexB    second vertex object
     * @param isDirected if true, the edge has an orientation
     */
    public Edge(Vertex vertexA, int weight, Vertex vertexB, boolean isDirected) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
        this.isDirected = isDirected;
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

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    /**
     * Swaps the two {@link graph.primitives.Vertex} objects {@link #vertexA} and
     * {@link #vertexA} within the edge.
     */
    public void swapVertices() {
        Vertex tmp = this.vertexA;
        this.vertexA = this.vertexB;
        this.vertexB = tmp;
    }

    /**
     * Checks, if the two passed {@link graph.primitives.Vertex} objects are within
     * the edge.
     * 
     * @param u {@link #vertexA} of the edge to be searched for
     * @param v {@link #vertexB} of the edge to be searched for
     * @return true, if and only if the edge contains the two passed vertices with
     *         the given arrangement.
     */
    public boolean containsVerticePair(Vertex u, Vertex v) {
        if ((u.equals(this.vertexA) && v.equals(this.vertexB)) || (u.equals(this.vertexB) && v.equals(this.vertexA))) {
            return true;
        } else
            return false;
    }

}