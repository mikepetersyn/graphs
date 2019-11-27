import graph.*;

public class Main {

    public static void main(String args[]){

        // scan the k3_3-file
        EdgeListScanner scanner = new EdgeListScanner("/home/mikep/code_local/graphs/exercise-1/files/k3_3.txt");

        EdgeListGraph elg = scanner.scan();

        IncidenceMatrixGraph img = new IncidenceMatrixGraph(elg);

        // TODO: Implementation for adjacence matrix and adjacence list
        // TODO: converter for edgelists ( incidencematrix (X), adjacence matrix (), adjacence list () )
        // TODO: DOT-Format exporter
    }

}
