package graph.structures;

import java.util.ArrayList;
import java.util.List;

import graph.primitives.Edge;
import graph.primitives.Vertex;

/**
 * Implements an adjacence matrix as data structure for a given graph.
 */
public class AdjacenceMatrixGraph extends Graph {

    /**
     * An ArrayList of ArrayLists with Integer values, each representing a vertex
     * name.
     */
    private ArrayList<ArrayList<Integer>> adjacenceMatrix = new ArrayList<ArrayList<Integer>>();

    /**
     * Creates a graph with an adjacence matrix as underlying data structure. It
     * needs to get the information on vertices and edges by passing and edge list
     * resp. {@link graph.structures.EdgeListGraph}.
     */
    public AdjacenceMatrixGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = false;

    }

    /**
     * Creates a directed graph with an adjacence matrix as underlying data
     * structure. It needs to get the information on vertices and edges by passing
     * and edge list resp. {@link graph.structures.EdgeListGraph}.
     */
    public AdjacenceMatrixGraph(EdgeListGraph elg, boolean isDirected) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = isDirected;
    }

    /**
     * Creates a directed and weighted graph with an adjacence matrix as underlying
     * data structure. It needs to get the information on vertices and edges by
     * passing and edge list resp. {@link graph.structures.EdgeListGraph}.
     */
    public AdjacenceMatrixGraph(EdgeListGraph elg, boolean isDirected, boolean isWeighted) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), isWeighted);
        super.isDirected = isDirected;
    }

    public ArrayList<ArrayList<Integer>> getAdjacenceMatrix() {
        return adjacenceMatrix;
    }

    public void setAdjacenceMatrix(ArrayList<ArrayList<Integer>> adjacenceMatrix) {
        this.adjacenceMatrix = adjacenceMatrix;
    }

    /**
     * Initialized the adjacence matrix by filling the first ArrayList with as many
     * ArrayLists as the graph vields distinct vertices. Each of these lists within
     * the first level list are filled with as many dummy vertices as the graph
     * yields distinct vertices.
     * 
     * @param numberVertices the number of vertices the given graph yields
     */
    private void init(int numberVertices) {
        for (int i = 0; i < numberVertices; i++) {
            this.adjacenceMatrix.add(new ArrayList<>());
            for (int j = 0; j < numberVertices; j++) {
                if (i == j)
                    this.adjacenceMatrix.get(i).add(0);
                else
                    // Integer.MAX_VALUE leads to weird operations while doing the condition within
                    // the floydWarshall
                    // therefore the value 999999999 represents INFINITY
                    this.adjacenceMatrix.get(i).add(999999999);
            }
        }
    }

    /**
     * Converts an edge list structure into a adjacence matrix structure.
     * 
     * @param el the edge list to be converted
     */
    public void convertFromEdgeList(List<Edge> el) {
        for (Edge e : el) {
            this.adjacenceMatrix.get(e.getVertexA().getVertexName() - 1).set(e.getVertexB().getVertexName() - 1, 1);
        }
    }

    /**
     * Converts an edge list structure with weights into a adjacence matrix
     * structure. Normal edges are denoted by the weight between two distinct
     * vertices (if edge(i,j) then w(i,j)). The mapping of the same vertex is
     * denoted by the value 0 (if edge(i,i) then w(0)). Non-existend edges are
     * denoted by the INFINITY value.
     * 
     * @param el         edge list to be converted
     * @param isWeighted boolean value indicating, that the graph is weighted
     */
    public void convertFromEdgeList(List<Edge> el, boolean isWeighted) {
        if (isWeighted) {
            int i;
            int j;
            int w;
            for (Edge e : el) {
                i = e.getVertexA().getVertexName();
                j = e.getVertexB().getVertexName();
                w = e.getWeight();
                this.adjacenceMatrix.get(i - 1).set(j - 1, w);
            }
        } else
            this.convertFromEdgeList(el);
    }

    /**
     * Converts the adjacence matrix back into an edge list structure.
     * 
     * @return the edge list.
     */
    public ArrayList<Edge> convertToEdgeList() {
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < this.adjacenceMatrix.size(); i++) {
            for (int j = 0; j < this.adjacenceMatrix.get(i).size(); j++) {

                if (this.adjacenceMatrix.get(i).get(j) == 1) {
                    edgeList.add(new Edge(new Vertex(i + 1), new Vertex(j + 1)));
                }
            }
        }
        return edgeList;
    }

}
