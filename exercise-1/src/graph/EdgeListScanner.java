package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Refactor scan method with decorator pattern to reduce code lines
public class EdgeListScanner {

    private String importPath;

    private File importFile;

    private Scanner scanner;

    public EdgeListScanner(String path) {
        this.importPath = path;
        this.importFile = new File(this.importPath);
    }

    public EdgeListGraph scanDirected() {
        EdgeListGraph edgeListGraph = new EdgeListGraph(true);
        int nextLineFirst;
        int nextLineSecond;
        try {
            scanner = new Scanner(this.importFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNextInt()) {
            if (i == 0) {
                edgeListGraph.setNumberVertices(scanner.nextInt());
                i++;
            }
            nextLineFirst = scanner.nextInt();
            nextLineSecond = scanner.nextInt();
            if (nextLineFirst == nextLineSecond)
                edgeListGraph.incrementNumSelfLoops();
            edgeListGraph.addEdge(new Edge(new Vertex(nextLineFirst), new Vertex(nextLineSecond), true));
        }
        return edgeListGraph;

    }

    public EdgeListGraph scanNotWeighted() {
        EdgeListGraph edgeListGraph = new EdgeListGraph();
        {
            try {
                scanner = new Scanner(this.importFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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

    public EdgeListGraph scanWeighted() {
        EdgeListGraph edgeListGraph = new EdgeListGraph();
        {
            try {
                scanner = new Scanner(this.importFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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
}
