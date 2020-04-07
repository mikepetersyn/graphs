package path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FloydWarshall {

    private static final int INFINITY = Integer.MAX_VALUE;

    private ArrayList<List<Integer>> myList;

    public FloydWarshall() {
        this.myList = new ArrayList<>();
        this.init();
    }

    private void init() {
        List<Integer> rowOne = Arrays.asList(0, 3, 8, INFINITY, -4);
        List<Integer> rowTwo = Arrays.asList(INFINITY, 0, INFINITY, 1, 7);
        List<Integer> rowThree = Arrays.asList(INFINITY, 4, 0, INFINITY, INFINITY);
        List<Integer> rowFour = Arrays.asList(2, INFINITY, -5, 0, INFINITY);
        List<Integer> rowFive = Arrays.asList(INFINITY, INFINITY, INFINITY, 6, 0);
        this.myList.add(rowOne);
        this.myList.add(rowTwo);
        this.myList.add(rowThree);
        this.myList.add(rowFour);
        this.myList.add(rowFive);
    }
    /**
     * public void doIt() { int n = this.myList.size(); ArrayList<List<Integer>> d =
     * this.myList; for (int k = 1; k < n; k++) { d = } }
     */

}