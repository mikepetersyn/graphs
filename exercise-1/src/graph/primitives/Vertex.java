package graph.primitives;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents a vertex within a graph.
 */
public class Vertex implements Cloneable {

    /**
     * This field specifies the name of the vertex, which is numeric value (e.g.
     * vertex 1).
     */
    private int vertexName;

    /**
     * This field indicates the color of the vertex. A false value represents a
     * white colorization, whereas a true value represents a black colorization.
     * Only utilized within a {@link algorithms.search.BreadthFirst} and a
     * {@link algorithms.search.DepthFirst} yet.
     */
    private boolean vertexColor;

    /**
     * This field yields the predecessing vertex of the current vertex.
     */
    private Vertex predecessor;

    /**
     * This field specifies a key, that is usually used as a key figure within an
     * algorithm (e.g. Dijkstra) indicating the distance between two vertices.
     */
    private int key;

    /**
     * An ArrayList yielding all vertices, that are adjacent to the current vertex.
     * This List is utilized within the {@link graph.structures.AdjacenceListGraph}
     * class.
     */
    private ArrayList<Vertex> adjacentVertices;

    /**
     * A constant yielding the value of {@link Integer.MAX_VALUE} that is utilized
     * as an infinity value for algorithmic purposes.
     */
    private final Integer INFINITY;

    /**
     * This field yields the value needed for computing a DFS on a graph @see
     * search.{@link search.DepthFirst}. Does not need any non-default
     * initialization.
     */
    private int finalKey;

    /**
     * Creates a vertex.
     * 
     * @param vertexName the name of the vertex ({@link #vertexName})
     */
    public Vertex(int vertexName) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = false;
        this.setKey(INFINITY);
        this.adjacentVertices = new ArrayList<>();
    }

    /**
     * Creates a colored vertex.
     * 
     * @param vertexName  the name of the vertex ({@link #vertexName})
     * @param vertexColor the color of the vertex ({@link #vertexColor)
     */
    public Vertex(int vertexName, boolean vertexColor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.setKey(INFINITY);
        this.adjacentVertices = new ArrayList<>();
    }

    /**
     * Creates a colored vertex with a given predecessor
     * 
     * @param vertexName  the name of the vertex ({@link #vertexName})
     * @param vertexColor the color of the vertex ({@link #vertexColor)
     * @param predecessor the predecessor of the vertex ({@link #predecessor})
     */
    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.setKey(INFINITY);
        this.adjacentVertices = new ArrayList<>();
    }

    /**
     * Creates a colored vertex with a given predecessor and key.
     * 
     * @param vertexName  the name of the vertex ({@link #vertexName})
     * @param vertexColor the color of the vertex ({@link #vertexColor)
     * @param predecessor the predecessor of the vertex ({@link #predecessor})
     * @param key         the key value of the vertex ({@link #key})
     */
    public Vertex(int vertexName, boolean vertexColor, Vertex predecessor, int key) {
        this.INFINITY = Integer.MAX_VALUE;
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
        this.predecessor = predecessor;
        this.key = key;
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getFinalKey() {
        return finalKey;
    }

    public void setFinalKey(int finalKey) {
        this.finalKey = finalKey;
    }

    /**
     * Adds a vertex to the list of adjacent vertices of this current vertex.
     * 
     * @param v vertex to be added to the list
     */
    public void addAdjacentVertex(Vertex v) {
        this.adjacentVertices.add(v);
    }

    public ArrayList<Vertex> getAdjacentVertices() {
        return this.adjacentVertices;
    }

    public void setAdjacentVertices(ArrayList<Vertex> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
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

    /**
     * Two vertices are equal if their names are equal.
     */
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