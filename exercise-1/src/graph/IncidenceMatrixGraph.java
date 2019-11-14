package graph;

import java.util.ArrayList;

public class IncidenceMatrixGraph {

    ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();

    // how to fill the matrix?
    // Edge-Objects -> e1(vA, vB), e2(vA, vB), ...
    // first dimension contains the different ArrayLists representing the columns
    // second dimension contains a single ArrayList containing the integer values
    // edges indexing the rows and vertices indexing the columns
    private void init (int numberVertices){
        for (int i = 0; i < numberVertices; i++) {
            incidenceMatrix.add(new ArrayList<>());
        }
    }

    public void convertFromEdgeList(ArrayList<Edge> el){

    }

}
