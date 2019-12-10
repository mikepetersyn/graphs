package graph;

import java.util.ArrayList;
import java.util.List;

// TODO: use property of direction to export directed graphs correctly
public class AdjacenceListGraph extends Graph {

    private ArrayList<Vertex> adjacenceList = new ArrayList<>();

    public ArrayList<Vertex> getAdjacenceList() {
        return adjacenceList;
    }

    public AdjacenceListGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), elg.getNumSelfLoops());
        super.isDirected = false;
    }

    public AdjacenceListGraph(EdgeListGraph elg, boolean isDirected) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), elg.getNumSelfLoops());
        super.isDirected = isDirected;
    }

    public void init(int numberOfVertices) {
        for (int i = 1; i <= numberOfVertices; i++) {
            this.adjacenceList.add(new Vertex(i));
        }
    }

    // FIXME: index of vertices and their names are a bit nasty here
    // FIXME: also change adding new vertices (call by reference!)
    private void convertFromEdgeList(List<Edge> edgeList, int numSelfLoops) {
        int bound = edgeList.size();
        int u;
        int v;
        for (int i = 0; i < bound; i++) {
            // vertex u that holds all its adjacent vertices
            u = edgeList.get(i).getVertexA().getVertexName();
            // every vertex v that is adjacent to vertex u
            v = edgeList.get(i).getVertexB().getVertexName();
            // add entry to adjacence list
            this.adjacenceList.get(u - 1).addAdjacentVertex(this.adjacenceList.get(v - 1));
        }
    }

    public ArrayList<Edge> convertToEdgeList() {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < this.adjacenceList.size(); i++) {
            for (int j = 0; j < this.adjacenceList.get(i).getAdjacentVertices().size(); j++) {
                edgeList.add(new Edge(new Vertex(i),
                        new Vertex(this.adjacenceList.get(i).getAdjacentVertices().get(j).getVertexName())));
            }
        }
        return edgeList;
    }
}
