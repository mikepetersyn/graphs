package mst;

import java.util.Comparator;

import graph.Edge;

public class SortByEdgeWeight implements Comparator<Edge> {

    @Override
    public int compare(Edge edgeA, Edge edgeB) {
        return edgeA.getWeight() - edgeB.getWeight();
    }

}