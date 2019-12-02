package graph;

import java.util.ArrayList;

public class IncidenceMatrixGraph extends Graph {

    public IncidenceMatrixGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices(), elg.getNumberEdges());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = false;
    }

    public IncidenceMatrixGraph(EdgeListGraph elg, boolean isDirected) {
        init(elg.getNumberVertices(), elg.getNumberEdges());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = isDirected;
    }

    private ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> getIncidenceMatrix() {
        return incidenceMatrix;
    }

    private void init(int numberVertices, int numberEdges) {
        for (int i = 0; i < numberVertices; i++) {
            this.incidenceMatrix.add(new ArrayList<>());
            for (int j = 0; j < numberEdges; j++) {
                this.incidenceMatrix.get(i).add(0);
            }
        }
    }

    public void convertFromEdgeList(ArrayList<Edge> el) {
        for (int i = 0; i < el.size(); i++) {
            this.incidenceMatrix.get(el.get(i).getVertexA().getVertexName() - 1).set(i, 1);
            this.incidenceMatrix.get(el.get(i).getVertexB().getVertexName() - 1).set(i, 1);
        }
    }

    public ArrayList<Edge> convertToEdgeList() {
        ArrayList<Edge> edgeList = initEdgeList(incidenceMatrix.get(0).size());
        for (int i = 0; i < this.incidenceMatrix.size(); i++) {
            for (int j = 0; j < this.incidenceMatrix.get(i).size(); j++) {
                if (this.incidenceMatrix.get(i).get(j) == 1) {
                    if (edgeList.get(j).getVertexA().getVertexName() == 0) {
                        edgeList.get(j).getVertexA().setVertexName(i + 1);
                    } else
                        edgeList.get(j).getVertexB().setVertexName(i + 1);
                }
            }
        }
        return edgeList;
    }

    private ArrayList<Edge> initEdgeList(int numberEdges) {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < numberEdges; i++) {
            edgeList.add(new Edge(new Vertex(0), new Vertex(0)));
        }
        return edgeList;
    }
}
