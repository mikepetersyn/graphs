import graph.*;
import mst.Kruskal;

public class Main {

    public static void main(String args[]) {

        final String EXPORTPATH = "/home/mike/graphs/exercise-1/exports/";
        final String IMPORTPATH = "/home/mikep/code_local/graphs/exercise-1/files/primkruskal.txt";

        EdgeListScanner primkrustal = new EdgeListScanner(IMPORTPATH);

        EdgeListGraph edgeListGraph = primkrustal.scanWeighted();
        edgeListGraph.setExportPath(EXPORTPATH);

        // EdgeListGraph inverseEdgeListGraph = new
        // EdgeListGraph(edgeListGraph.getEdgeList(), true);
        // inverseEdgeListGraph.inverseAllEdges();
        // inverseEdgeListGraph.setExportPath(EXPORTPATH);

        // IncidenceMatrixGraph incidenceMatrixGraph = new
        // IncidenceMatrixGraph(edgeListGraph);
        // incidenceMatrixGraph.setExportPath(EXPORTPATH);

        // AdjacenceMatrixGraph adjacenceMatrixGraph = new
        // AdjacenceMatrixGraph(edgeListGraph);
        // adjacenceMatrixGraph.setExportPath(EXPORTPATH);

        // AdjacenceListGraph adjacenceListGraph = new AdjacenceListGraph(edgeListGraph,
        // true);
        // adjacenceListGraph.setExportPath(EXPORTPATH);

        // adjacenceListGraph.exportGraph(adjacenceListGraph.convertToEdgeList());
        Kruskal kruskal = new Kruskal(edgeListGraph);
        kruskal.printEdgeList();

    }
}