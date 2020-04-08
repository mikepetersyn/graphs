package mst;

import java.util.Comparator;

import graph.Vertex;

public class VertexKeyComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex v1, Vertex v2) {
        // int w1 = v1.getKey();
        // int w2 = v2.getKey();
        // if (w1 < w2)
        // return 1;
        // else if (w1 > w2)
        // return -1;
        // else
        // return 0;
        return Integer.compare(v1.getKey(), v2.getKey());
    }
}