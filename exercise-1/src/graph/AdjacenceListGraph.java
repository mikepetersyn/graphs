package graph;

import java.util.ArrayList;

public class AdjacenceListGraph extends Graph {

    private ArrayList<Vertex> adjacenceList;

    public ArrayList<Vertex> getAdjacenceList() {
        return adjacenceList;
    }

    public AdjacenceListGraph(EdgeListGraph elg) {
        this.adjacenceList = new ArrayList<>();
        initAdjacenceList(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), elg.getNumSelfLoops());
        super.isDirected = false;
    }

    public AdjacenceListGraph(EdgeListGraph elg, boolean isDirected) {
        this.adjacenceList = new ArrayList<>();
        initAdjacenceList(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), elg.getNumSelfLoops());
        super.isDirected = isDirected;
    }

    public void initAdjacenceList(int numberOfVertices) {
        while (this.adjacenceList.size() < numberOfVertices)
            this.adjacenceList.add(new Vertex(0));
    }

    private void convertFromEdgeList(ArrayList<Edge> edgeList, int numSelfLoops) {
        for (Edge e : edgeList) {
            if (!this.adjacenceList.contains(e.getVertexA())) {
                this.adjacenceList.set(e.getVertexA().getVertexName() - 1, e.getVertexA());
            }
            this.adjacenceList.get(e.getVertexA().getVertexName() - 1).addAdjacentVertex(e.getVertexB());
        }

    }

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
