package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacenceMatrixGraph extends Graph {

    private ArrayList<ArrayList<Integer>> adjacenceMatrix = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> getAdjacenceMatrix() {
        return adjacenceMatrix;
    }

    public AdjacenceMatrixGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = false;
    }

    public AdjacenceMatrixGraph(EdgeListGraph elg, boolean isDirected) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = isDirected;
    }

    public AdjacenceMatrixGraph(EdgeListGraph elg, boolean isDirected, boolean isWeighted) {
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList(), isWeighted);
        super.isDirected = isDirected;
    }

    private void init(int numberVertices) {
        for (int i = 0; i < numberVertices; i++) {
            this.adjacenceMatrix.add(new ArrayList<>());
            for (int j = 0; j < numberVertices; j++) {
                this.adjacenceMatrix.get(i).add(0);
            }
        }
    }

    private void convertFromEdgeList(List<Edge> el) {
        for (Edge e : el) {
            this.adjacenceMatrix.get(e.getVertexA().getVertexName() - 1).set(e.getVertexB().getVertexName() - 1, 1);
        }
    }

    private void convertFromEdgeList(List<Edge> el, boolean isWeighted) {
        if (isWeighted) {
            for (Edge e : el) {
                this.adjacenceMatrix.get(e.getVertexA().getVertexName() - 1).set(e.getVertexB().getVertexName() - 1,
                        e.getWeight());
            }
        } else
            this.convertFromEdgeList(el);
    }

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
