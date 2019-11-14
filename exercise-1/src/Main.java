import graph.*;

public class Main {

    public static void main(String args[]){

        // scan the k3_3-file
        EdgeListScanner scanner = new EdgeListScanner("/home/mikep/code_local/graphs/exercise-1/files/k3_3.txt");

        EdgeListGraph elg = scanner.scan();
    }

}
