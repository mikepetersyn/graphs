package graph;

import java.util.ArrayList;

public class EdgeListGraph {

    private ArrayList<Edge> edgeList = new ArrayList<>();

    public EdgeListGraph(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public void addEdge(Edge e){
        edgeList.add(e);
    }
}
