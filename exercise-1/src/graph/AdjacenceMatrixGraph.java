package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacenceMatrixGraph extends Graph{

    private ArrayList<ArrayList<Integer>> adjacenceMatrix = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> getAdjacenceMatrix() {
        return adjacenceMatrix;
    }

    public AdjacenceMatrixGraph(EdgeListGraph elg){
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
    }

    private void init(int numberVertices){
        for (int i = 0; i < numberVertices; i++) {
            this.adjacenceMatrix.add(new ArrayList<>());
            for (int j = 0; j < numberVertices; j++) {
                this.adjacenceMatrix.get(i).add(0);
            }
        }
    }

    private void convertFromEdgeList(List<Edge> el){
        for (Edge e : el){
            this.adjacenceMatrix.get(e.getvA().getVerticeNumber()-1).set(e.getvB().getVerticeNumber()-1,1);
        }
    }

    public ArrayList<Edge> convertToEdgeList(ArrayList<ArrayList<Integer>> adjacenceMatrix) {
        ArrayList<Edge> edgeList = new ArrayList<>();
        for ( int i = 0; i < adjacenceMatrix.size(); i++){
            for (int j = 0; j < adjacenceMatrix.get(i).size(); j++){

                if (adjacenceMatrix.get(i).get(j) == 1) {
                    edgeList.add(new Edge(new Vertex(i+1), new Vertex(j+1)));
                }

            }
        }
        return edgeList;
    }

    private ArrayList<Edge> initEdgeList(int numberEdges){
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < numberEdges; i++){
            edgeList.add(new Edge(new Vertex(0), new Vertex(0)));
        }
        return edgeList;
    }

}
