package graph.structures;

import java.util.ArrayList;
import java.util.HashSet;

import graph.primitives.Edge;
import graph.primitives.EdgeWeightComparator;
import graph.primitives.Vertex;

public class EdgeListGraph extends Graph {

    public EdgeListGraph() {
        this.edgeList = new ArrayList<>();
        this.vertexList = new HashSet<Vertex>();
        super.isDirected = false;
    }

    public EdgeListGraph(boolean isDirected) {
        this.edgeList = new ArrayList<>();
        this.vertexList = new HashSet<Vertex>();
        super.isDirected = isDirected;
    }

    public EdgeListGraph(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
        this.vertexList = new HashSet<Vertex>();
    }

    public EdgeListGraph(ArrayList<Edge> edgeList, boolean isDirected) {
        this.edgeList = edgeList;
        this.vertexList = new HashSet<Vertex>();
        super.isDirected = isDirected;
    }

    private ArrayList<Edge> edgeList;
    private HashSet<Vertex> vertexList;

    public boolean containsVertex(Vertex v) {
        return this.vertexList.contains(v);
    }

    public Vertex findVertexByName(Integer name) {
        return this.vertexList.stream().filter(v -> name.equals(v.getVertexName())).findFirst().orElse(null);
    }

    public Edge findEdgeByVertices(Vertex u, Vertex v) {
        Edge result = null;
        for (Edge e : this.edgeList) {
            if (e.containsVerticePair(u, v))
                result = e;
        }
        return result;
    }

    // returns the first found uncolored vertex within the verticelist or null if
    // there is no uncolored vertex
    public Vertex findUncolored() {
        return this.vertexList.stream().filter(v -> false == v.getVertexColor()).findFirst().orElse(null);
    }

    // returns the first found uncolored vertex within the verticelist or null if
    // there is no uncolored vertex
    public Vertex findUncolored(HashSet<Vertex> vl) {
        return vl.stream().filter(v -> false == v.getVertexColor()).findFirst().orElse(null);
    }

    private int numSelfLoops;

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public int getNumberEdges() {
        return edgeList.size();
    }

    public void addEdge(Edge e) {
        if (this.containsVertex(e.getVertexA())) {
            e.setVertexA(this.findVertexByName(e.getVertexA().getVertexName()));
        } else {
            vertexList.add(e.getVertexA());
        }
        if (this.containsVertex(e.getVertexB())) {
            e.setVertexB(this.findVertexByName(e.getVertexB().getVertexName()));
        } else {
            vertexList.add(e.getVertexB());
        }
        edgeList.add(e);
    }

    public void inverseAllEdges() {
        this.edgeList.forEach(edge -> edge.swapVertices());
    }

    public ArrayList<Integer> returnEdgeListAsVertexNameList() {
        ArrayList<Integer> vertexList = new ArrayList<Integer>();
        for (Edge edge : this.edgeList) {
            vertexList.add(edge.getVertexA().getVertexName());
            vertexList.add(edge.getVertexB().getVertexName());
        }
        return vertexList;
    }

    public ArrayList<Integer> returnEdgeListAsVertexNameList(ArrayList<Edge> edgeList) {
        ArrayList<Integer> vertexList = new ArrayList<Integer>();
        for (Edge edge : edgeList) {
            vertexList.add(edge.getVertexA().getVertexName());
            vertexList.add(edge.getVertexB().getVertexName());
        }
        return vertexList;
    }

    public void sortEdgeListByWeight() {
        this.edgeList.sort(new EdgeWeightComparator());
    }

    public ArrayList<Edge> sortEdgeListByWeight(ArrayList<Edge> edgeList) {
        edgeList.sort(new EdgeWeightComparator());
        return edgeList;
    }

    public void incrementNumSelfLoops() {
        this.numSelfLoops += 1;
    }

    public int getNumSelfLoops() {
        return this.numSelfLoops;
    }

    public HashSet<Vertex> getVertexList() {
        return vertexList;
    }
}
