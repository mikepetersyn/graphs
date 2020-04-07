package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EdgeListScanner {

    private File importFile;
    private Scanner scanner;
    private boolean isWeighted;
    private boolean isDirected;

    public EdgeListScanner(String path, boolean isDirected, boolean isWeighted) {
        setImportFile(path);
        setScanner(getImportFile());
        setDirected(isDirected);
        setWeighted(isWeighted);
    }

    public File getImportFile() {
        return this.importFile;
    }

    private void setImportFile(String importPath) {
        this.importFile = new File(importPath);
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    private void setWeighted(boolean isWeighted) {
        this.isWeighted = isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    private void setDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    private void setScanner(File importFile) {
        try {
            this.scanner = new Scanner(importFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int checkProperties() {
        if (this.isDirected && this.isWeighted)
            return 1;
        else if (this.isDirected)
            return 2;
        else if (this.isWeighted)
            return 3;
        else
            return 4;
    }

    public EdgeListGraph scan() {
        EdgeListGraph edgeListGraph = null;
        switch (checkProperties()) {
            case 1:
                edgeListGraph = scanWeightedDirected(edgeListGraph);
                break;
            case 2:
                edgeListGraph = scanDirected(edgeListGraph);
                break;
            case 3:
                edgeListGraph = scanWeighted(edgeListGraph);
                break;
            case 4:
                edgeListGraph = scanSimple(edgeListGraph);
                break;
        }
        return edgeListGraph;
    }

    private EdgeListGraph scanSimple(EdgeListGraph edgeListGraph) {
        edgeListGraph = new EdgeListGraph();
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i == 0) {
                edgeListGraph.setNumberVertices(scanner.nextInt());
                i++;
            }
            edgeListGraph.addEdge(new Edge(new Vertex(scanner.nextInt()), new Vertex(scanner.nextInt())));
        }
        return edgeListGraph;
    }

    private EdgeListGraph scanWeighted(EdgeListGraph edgeListGraph) {
        edgeListGraph = new EdgeListGraph();
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i == 0) {
                edgeListGraph.setNumberVertices(scanner.nextInt());
                i++;
            }
            edgeListGraph
                    .addEdge(new Edge(new Vertex(scanner.nextInt()), scanner.nextInt(), new Vertex(scanner.nextInt())));
        }
        return edgeListGraph;
    }

    private EdgeListGraph scanDirected(EdgeListGraph edgeListGraph) {
        edgeListGraph = new EdgeListGraph(this.isDirected);

        int i = 0;
        while (scanner.hasNextInt()) {
            if (i == 0) {
                edgeListGraph.setNumberVertices(scanner.nextInt());
                i++;
            }

            Vertex vertexA = new Vertex(scanner.nextInt());
            Vertex vertexB = new Vertex(scanner.nextInt());
            if (vertexA.getVertexName() == vertexB.getVertexName())
                edgeListGraph.incrementNumSelfLoops();

            edgeListGraph.addEdge(new Edge(vertexA, vertexB, true));
        }
        return edgeListGraph;
    }

    private EdgeListGraph scanWeightedDirected(EdgeListGraph edgeListGraph) {
        edgeListGraph = new EdgeListGraph(this.isDirected);

        int i = 0;
        while (scanner.hasNextInt()) {
            if (i == 0) {
                edgeListGraph.setNumberVertices(scanner.nextInt());
                i++;
            }

            Vertex vertexA = new Vertex(scanner.nextInt());
            int edgeWeight = scanner.nextInt();
            Vertex vertexB = new Vertex(scanner.nextInt());

            if (vertexA.getVertexName() == vertexB.getVertexName())
                edgeListGraph.incrementNumSelfLoops();

            edgeListGraph.addEdge(new Edge(vertexA, edgeWeight, vertexB, true));
        }
        return edgeListGraph;
    }

}
