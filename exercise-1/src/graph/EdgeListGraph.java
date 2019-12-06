package graph;

import java.util.ArrayList;

import mst.SortByEdgeWeight;

public class EdgeListGraph extends Graph {

    public EdgeListGraph() {
        this.edgeList = new ArrayList<>();
        super.isDirected = false;
    }

    public EdgeListGraph(boolean isDirected) {
        this.edgeList = new ArrayList<>();
        super.isDirected = isDirected;
    }

    public EdgeListGraph(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public EdgeListGraph(ArrayList<Edge> edgeList, boolean isDirected) {
        this.edgeList = edgeList;
        super.isDirected = isDirected;
    }

    private ArrayList<Edge> edgeList;

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
        edgeList.add(e);
    }

    public void inverseAllEdges() {
        this.edgeList.forEach(edge -> edge.swapVertices());
    }

    public ArrayList<Vertex> returnEdgeListAsVertexList() {
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        for (Edge edge : this.edgeList) {
            vertexList.add(edge.getVertexA());
            vertexList.add(edge.getVertexB());
        }
        return vertexList;
    }

    public ArrayList<Vertex> returnEdgeListAsVertexList(ArrayList<Edge> edgeList) {
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
        for (Edge edge : edgeList) {
            vertexList.add(edge.getVertexA());
            vertexList.add(edge.getVertexB());
        }
        return vertexList;
    }

    public void sortEdgeListByWeight() {
        this.edgeList.sort(new SortByEdgeWeight());
    }

    public ArrayList<Edge> sortEdgeListByWeight(ArrayList<Edge> edgeList) {
        edgeList.sort(new SortByEdgeWeight());
        return edgeList;
    }

}
