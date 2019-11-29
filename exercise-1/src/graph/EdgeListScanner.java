package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EdgeListScanner {

    private String importPath;

    private File importFile;

    private Scanner scanner;

    public EdgeListScanner(String path) {
        this.importPath = path;
        this.importFile = new File(this.importPath);
    }

    public EdgeListGraph scan() {
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

}
