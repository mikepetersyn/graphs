package graph.primitives;

import java.util.Comparator;

/**
 * Implements a compare method that compares two given edges by comparing their
 * weights.
 */
public class EdgeWeightComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge edgeA, Edge edgeB) {
        return edgeA.getWeight() - edgeB.getWeight();
    }

}