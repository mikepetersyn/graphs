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

        ArrayList<Edge> edgeList = new ArrayList<>();

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
                System.out.println(scanner.nextInt());
                i++;
            }
            //System.out.println(scanner.nextInt() + " " + scanner.nextInt());
            edgeList.add(new Edge(scanner.nextInt(), scanner.nextInt()));
        }

        EdgeListGraph elg = new EdgeListGraph(edgeList);

        return elg;
    }


}
