import graph.*;

public class Main {

    public static void main(String args[]){

        EdgeListScanner scanner = new EdgeListScanner("/home/mikep/code_local/graphs/exercise-1/files/k3_3.txt");

        EdgeListGraph elg = scanner.scan();

        IncidenceMatrixGraph img = new IncidenceMatrixGraph(elg);

        AdjacenceMatrixGraph amg = new AdjacenceMatrixGraph(elg);

        AdjacenceListGraph alg = new AdjacenceListGraph(elg);

        elg.export(elg.getEdgeList(),"edgeListGraph");

        elg.export(img.convertToEdgeList(img.getIncidenceMatrix()), "incidenceMatrixGraph");

        elg.export(amg.convertToEdgeList(amg.getAdjacenceMatrix()), "adjacenceMatrixGraph");

        elg.export(alg.convertToEdgeList(alg.getAdjacenceList()), "adjacenceListGraph");

    }

}
