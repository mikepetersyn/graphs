import java.util.ArrayList;

import graph.*;
import mst.Kruskal;
import search.BreadthFirst;

public class Main {

    public static void main(String args[]) {

        final String EXPORTPATH = "/home/mikep/code_local/graphs/exercise-1/exports/";
        final String IMPORTPATH = "/home/mikep/code_local/graphs/exercise-1/files/search.txt";

        EdgeListScanner directed = new EdgeListScanner(IMPORTPATH, true, false);

        EdgeListGraph edgeListGraph = directed.scan();
        AdjacenceListGraph adjacenceListGraph = new AdjacenceListGraph(edgeListGraph, true);
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
        adjacenceListGraph.setExportPath(EXPORTPATH);
        BreadthFirst bfs = new BreadthFirst(adjacenceListGraph, edgeListGraph);
        bfs.doIt(1);
        ArrayList<Vertex> bfsTree = bfs.getAl();
        adjacenceListGraph.exportGraph(adjacenceListGraph.convertToEdgeList());
        // Kruskal kruskal = new Kruskal(edgeListGraph);
        // kruskal.printEdgeList();

    }
}