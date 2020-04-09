package path;

import graph.AdjacenceMatrixGraph;
import java.util.ArrayList;

public class FloydWarshall {

    private AdjacenceMatrixGraph adjacenceMatrixGraph;
    private ArrayList<ArrayList<Integer>> adjacenceMatrix = new ArrayList<ArrayList<Integer>>();

    public FloydWarshall(AdjacenceMatrixGraph adjacenceMatrixGraph) {
        this.adjacenceMatrixGraph = adjacenceMatrixGraph;
        this.adjacenceMatrix = adjacenceMatrixGraph.getAdjacenceMatrix();
    }

    public void doIt() {
        int d_ij;
        int d_ik;
        int d_kj;
        int len = this.adjacenceMatrix.size();
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    d_ij = this.adjacenceMatrix.get(i).get(j);
                    d_ik = this.adjacenceMatrix.get(i).get(k);
                    d_kj = this.adjacenceMatrix.get(k).get(j);
                    if (d_ij > (d_ik + d_kj))
                        this.adjacenceMatrix.get(i).set(j, d_ik + d_kj);
                }
            }
        }
    }

}