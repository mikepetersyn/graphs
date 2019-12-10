package graph;

import java.util.ArrayList;

/**
 * Represents a vertex in a graph
 */
public class Vertex {

    private int vertexName;

    // false -> white color
    // true -> black color
    private boolean vertexColor;

    private Vertex predecessor;

    private int distance;

    private ArrayList<Vertex> adjacentVertices;

    private final Integer INFINITY;

    public Vertex(int vertexName) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = false;
        this.distance = INFINITY;
        this.adjacentVertices = new ArrayList<>();
    }

    public Vertex(int vertexName, boolean vertexColor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.distance = INFINITY;
        this.adjacentVertices = new ArrayList<>();
    }

    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.distance = INFINITY;
        this.adjacentVertices = new ArrayList<>();
    }

    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor, int distance) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.distance = distance;
        this.adjacentVertices = new ArrayList<>();
    }

    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor, int distance, boolean isStart) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.distance = distance;
        this.adjacentVertices = new ArrayList<>();
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public boolean getVertexColor() {
        return vertexColor;
    }

    public void setVertexColor(boolean vertexColor) {
        this.vertexColor = vertexColor;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addAdjacentVertex(Vertex v) {
        this.adjacentVertices.add(v);
    }

    public ArrayList<Vertex> getAdjacentVertices() {
        return this.adjacentVertices;
    }

    @Override
    public int compareTo(Vertex v) {
        if (vertexName == v.vertexName) {
            return 0;
        } else if (vertexName > v.vertexName) {
            return 1;
        } else
            return -1;
    }

}