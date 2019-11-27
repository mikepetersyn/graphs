package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EdgeListScanner {

    private String path;

    private File file;

    private Scanner scanner;

    public EdgeListScanner(String path) {
        this.path = path;
        this.file = new File(this.path);
    }

    // method that reads in a file
    // scans the content using
    // a)   whitespace as delimiter for seperating
    //      vertices of one edge (elements of a line)
    // b)   line-break as delimiter for seperating
    //      edges (lines of the file)
    // and returns an object of EdgeListGraph

    public EdgeListGraph scan(){
        // initialize edgeList and number of Edges
        ArrayList<Edge> edgeList = new ArrayList<>();
        int numberVertices = 0;
        // open scanner util and read the edgelist
        {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int i = 0;
        while(scanner.hasNextInt()){
            if (i == 0){
                numberVertices = scanner.nextInt();
                i++;
            }
            edgeList.add(new Edge(scanner.nextInt(), scanner.nextInt()));
        }
        // create graph from edgelist and set its number of edges
        EdgeListGraph elg = new EdgeListGraph(edgeList);
        elg.setNumberVertices(numberVertices);

        return elg;
    }


}
