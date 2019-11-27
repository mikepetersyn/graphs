package graph;

import java.util.ArrayList;
import java.util.List;

public class IncidenceMatrixGraph {

    public IncidenceMatrixGraph(EdgeListGraph elg) {
        init(elg.getNumberVertices(), elg.getNumberEdges());
    }

    private ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();

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
    public void convertFromEdgeList(EdgeListGraph elg){
        List<Edge> el = elg.getEdgeList();
        for(int i = 1; i < el.size(); i++) {
            this.incidenceMatrix.get( el.get(i).getvA() ).set(i,1);
            this.incidenceMatrix.get( el.get(i).getvB() ).set(i,1);
        }
    }

}
