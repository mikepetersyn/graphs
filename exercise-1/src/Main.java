import graph.*;

public class Main {

    public static void main(String args[]) {

        final String EXPORTPATH = "/home/mike/graphs/exercise-1/exports/";

        EdgeListScanner k3_3 = new EdgeListScanner("/home/mike/graphs/exercise-1/files/k3_3.txt");
        
        EdgeListGraph edgeListGraph = k3_3.scan();
        edgeListGraph.setExportPath(EXPORTPATH);

        EdgeListGraph inverseEdgeListGraph = new EdgeListGraph(edgeListGraph.getEdgeList(), true);
        inverseEdgeListGraph.inverseAllEdges();
        inverseEdgeListGraph.setExportPath(EXPORTPATH);

        //IncidenceMatrixGraph incidenceMatrixGraph = new IncidenceMatrixGraph(edgeListGraph);
        //incidenceMatrixGraph.setExportPath(EXPORTPATH);

        //AdjacenceMatrixGraph adjacenceMatrixGraph = new AdjacenceMatrixGraph(edgeListGraph);
        //adjacenceMatrixGraph.setExportPath(EXPORTPATH);

        //AdjacenceListGraph adjacenceListGraph = new AdjacenceListGraph(edgeListGraph, true);
        //adjacenceListGraph.setExportPath(EXPORTPATH);

        inverseEdgeListGraph.exportGraph(inverseEdgeListGraph.getEdgeList());
    }
}