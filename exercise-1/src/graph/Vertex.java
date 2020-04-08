package graph;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a vertex in a graph
 */
public class Vertex implements Cloneable {

    private int vertexName;

    // false -> white color
    // true -> black color
    private boolean vertexColor;

    private Vertex predecessor;

    private int distance;

    private int key;

    private ArrayList<Vertex> adjacentVertices;

    private final Integer INFINITY;

    /**
     * This field yields the value needed for computing a DFS on a graph @see
     * search.{@link search.DepthFirst}. Does not need any non-default
     * initialization.
     */
    private int finalDistance;

    public Vertex(int vertexName) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = false;
        this.distance = INFINITY;
        this.setKey(INFINITY);
        this.adjacentVertices = new ArrayList<>();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Vertex(int vertexName, boolean vertexColor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.distance = INFINITY;
        this.setKey(INFINITY);
        this.adjacentVertices = new ArrayList<>();
    }

    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.distance = INFINITY;
        this.setKey(INFINITY);
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
        this.setKey(INFINITY);
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
    public Vertex clone() {
        Vertex clone = null;
        try {
            clone = (Vertex) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

    public int getFinalDistance() {
        return finalDistance;
    }

    public void setFinalDistance(int finalDistance) {
        this.finalDistance = finalDistance;
    }

    // two vertices are equal if their names (integer) are equal
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vertex other = (Vertex) o;
        if (getVertexName() != other.getVertexName())
            return false;
        return true;
    }

    public int hashCode() {
        return getVertexName();
    }
}