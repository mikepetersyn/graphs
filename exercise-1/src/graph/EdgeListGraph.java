package graph;

import java.util.ArrayList;

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

}
