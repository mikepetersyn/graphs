package graph;

import java.util.ArrayList;

// TODO: avoid unnecessary initializing of default values in constructor
/**
 * Represents an edge within a graph
 */
public class Edge {

    /**
     * First vertex object of the edge.
     */
    private Vertex vertexA;

    /**
     * Second vertex object of the edge.
     */
    private Vertex vertexB;

    /**
     * Indicates the weight of an edge.
     */
    private int weight;

    /**
     * Indicates if an edge is directed or not.
     */
    private boolean isDirected;

    /**
     * Indicates the orientation of the edge, if it is directed. The first element
     * represents the starting vertex and the second elements represents the ending
     * vertex.
     */
    // private ArrayList<Vertex> orientation;

    /**
     * Creates a non-weighted edge with two vertex objects @see graph.Vertex.
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
     * Creates a weighted edge with two vertex objects @see graph.Vertex.
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
     * Creates a non-weighted edge with two vertex objects @see graph.Vertex. If
     * declared, this edge is also directed and the first vertex object represents
     * the starting vertex, whereas the second vertex object represents the ending
     * vertex.
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
        // if (this.isDirected) {
        // this.orientation = new ArrayList<Vertex>(2);
        // this.orientation.add(vertexA);
        // this.orientation.add(vertexB);
        // }
    }

    /**
     * Creates a weighted edge with two vertex objects @see graph.Vertex. If
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
        // if (this.isDirected) {
        // this.orientation = new ArrayList<Vertex>(2);
        // this.orientation.add(vertexA);
        // this.orientation.add(vertexB);
        // }
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

    // checks if the two passed Vertices are within the Edge
    // returns true if both vertices are within the edge
    // returns false if not
    public boolean containsVerticePair(Vertex u, Vertex v) {
        if ((u.equals(this.vertexA) && v.equals(this.vertexB)) || (u.equals(this.vertexB) && v.equals(this.vertexA))) {
            return true;
        } else
            return false;
    }
}