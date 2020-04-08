import java.util.ArrayList;

import graph.*;
import mst.Kruskal;
import mst.Prim;
import search.BreadthFirst;

public class Main {

    public static void main(String args[]) {

        final String EXPORTPATH = "/home/mikep/code_local/graphs/exercise-1/exports/";
        final String IMPORTPATH = "/home/mikep/code_local/graphs/exercise-1/files/primkruskal.txt";

        EdgeListScanner weighted = new EdgeListScanner(IMPORTPATH, false, true);

        EdgeListGraph edgeListGraph = weighted.scan();
        AdjacenceListGraph adjacenceListGraph = new AdjacenceListGraph(edgeListGraph);
        // adjacenceListGraph.setExportPath(EXPORTPATH);
        // adjacenceListGraph.exportGraph(adjacenceListGraph.convertToEdgeList());

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
        // BreadthFirst bfs = new BreadthFirst(adjacenceListGraph, edgeListGraph);
        Prim prim = new Prim(adjacenceListGraph, edgeListGraph);
        prim.doit(1);

        // adjacenceListGraph.exportGraph(adjacenceListGraph.convertToEdgeList());
        // Kruskal kruskal = new Kruskal(edgeListGraph);
        // kruskal.printEdgeList();

    }
}