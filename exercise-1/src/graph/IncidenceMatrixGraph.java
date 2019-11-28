package graph;

import java.util.ArrayList;
import java.util.List;

public class IncidenceMatrixGraph extends Graph{

    public IncidenceMatrixGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices(), elg.getNumberEdges());
        convertFromEdgeList(elg.getEdgeList());
    }

    private ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> getIncidenceMatrix() {
        return incidenceMatrix;
    }

    // how to fill the matrix?
    // Edge-Objects -> e1(vA, vB), e2(vA, vB), ...
    // first dimension contains the different ArrayLists representing the columns
    // second dimension contains a single ArrayList containing the integer values
    // edges indexing the rows and vertices indexing the columns
    private void init (int numberVertices, int numberEdges){
        for (int i = 0; i < numberVertices; i++) {
            this.incidenceMatrix.add(new ArrayList<>());
            for (int j = 0; j < numberEdges; j++) {
                this.incidenceMatrix.get(i).add(0);
            }
        }
    }

    // values from edgelist for the first level index
    // index of edgelist for the second level index setting a 1
    public void convertFromEdgeList(ArrayList<Edge> el){
        for(int i = 0; i < el.size(); i++) {
            this.incidenceMatrix.get( el.get(i).getvA().getVerticeNumber()-1 ).set(i,1);
            this.incidenceMatrix.get( el.get(i).getvB().getVerticeNumber()-1 ).set(i,1);
        }
    }

    public ArrayList<Edge> convertToEdgeList(ArrayList<ArrayList<Integer>> incidenceMatrix) {
        ArrayList<Edge> edgeList = initEdgeList(incidenceMatrix.get(0).size());
        for (int i = 0; i < incidenceMatrix.size(); i++) {
            for (int j = 0; j < incidenceMatrix.get(i).size(); j++) {
                if (incidenceMatrix.get(i).get(j) == 1) {
                    if(edgeList.get(j).getvA().getVerticeNumber() == 0) {
                        edgeList.get(j).getvA().setVerticeNumber(i+1);
                    } else edgeList.get(j).getvB().setVerticeNumber(i+1);
                }
            }
        }
        return edgeList;
    }

    private ArrayList<Edge> initEdgeList(int numberEdges){
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < numberEdges; i++){
            edgeList.add(new Edge( new Vertex(0), new Vertex(0) ) );
        }
        return edgeList;
    }
}
