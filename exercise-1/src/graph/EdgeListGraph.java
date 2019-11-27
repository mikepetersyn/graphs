package graph;

import java.util.ArrayList;

public class EdgeListGraph {

    private int numberVertices;

    public int getNumberVertices() {
        return numberVertices;
    }

    public int getNumberEdges() {
        return edgeList.size();
    }

    public void setNumberVertices(int numberVertices) {
        this.numberVertices = numberVertices;
    }

    private ArrayList<Edge> edgeList = new ArrayList<>();

    public EdgeListGraph(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public void addEdge(Edge e){
        edgeList.add(e);
    }


    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }
}
