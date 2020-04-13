package graph.structures;

import java.util.ArrayList;
import java.util.HashSet;

import graph.primitives.Edge;
import graph.primitives.Vertex;

/**
 * Implements an adjacence list as data structure for a given graph
 */
public class AdjacenceListGraph extends Graph {

    /**
     * An ArrayList yielding the vertices. Each one of the vertices yields a list of
     * adjacent vertices.
     */
    private ArrayList<Vertex> adjacenceList;

    /**
     * Creates a graph with an adjacence list as underlying data structure. It needs
     * to get the information on vertices and edges by passing and edge list resp.
     * {@link graph.structures.EdgeListGraph}.
     */
    public AdjacenceListGraph(EdgeListGraph elg) {
        this.adjacenceList = new ArrayList<>();
        initAdjacenceList(elg.getVertexList());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = false;
    }

    /**
     * Creates a directed graph with an adjacence list as underlying data structure.
     * It needs to get the information on vertices and edges by passing and edge
     * list resp. {@link graph.structures.EdgeListGraph}.
     */
    public AdjacenceListGraph(EdgeListGraph elg, boolean isDirected) {
        this.adjacenceList = new ArrayList<>();
        initAdjacenceList(elg.getVertexList());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = isDirected;
    }

    public ArrayList<Vertex> getAdjacenceList() {
        return adjacenceList;
    }

    public void setAdjacenceList(ArrayList<Vertex> adjacenceList) {
        this.adjacenceList = adjacenceList;
    }

    /**
     * Initializes the adjacence list by adding vertices from the vertex list of the
     * edge list graph
     */
    public void initAdjacenceList(HashSet<Vertex> vertexList) {
        this.adjacenceList.addAll(vertexList);
    }

    /**
     * Initializes the adjacence list by adding vertices from the vertex list of the
     * edge list graph
     */
    public void initAdjacenceList(ArrayList<Vertex> adjacenceList, HashSet<Vertex> vertexList) {
        adjacenceList.addAll(vertexList);
    }

    /**
     * Converts an edge list structure to an adjacence list by iterating all edges.
     * Note, that edge weights, if present, are lost by the conversion.
     * 
     * @param edgeList     edge list to be converted into a adjacence list
     * @param numSelfLoops
     */
    private void convertFromEdgeList(ArrayList<Edge> edgeList) {
        for (Edge e : edgeList) {
            if (!this.adjacenceList.contains(e.getVertexA())) {
                this.adjacenceList.set(e.getVertexA().getVertexName() - 1, e.getVertexA());
            }
            this.adjacenceList.get(e.getVertexA().getVertexName() - 1).addAdjacentVertex(e.getVertexB());
        }
    }

    /**
     * Converts an adjacence list back into an edge list structure.
     * 
     * @return
     */
    public ArrayList<Edge> convertToEdgeList() {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < this.adjacenceList.size(); i++) {
            for (int j = 0; j < this.adjacenceList.get(i).getAdjacentVertices().size(); j++) {
                edgeList.add(
                        new Edge(this.adjacenceList.get(i), this.adjacenceList.get(i).getAdjacentVertices().get(j)));
            }
        }
        return edgeList;
    }
}
