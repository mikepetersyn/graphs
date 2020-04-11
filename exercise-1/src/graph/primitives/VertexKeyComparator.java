package graph.primitives;

import java.util.Comparator;

/**
 * Implements a comparator that compares two given vertices by comparing their
 * key values.
 */
public class VertexKeyComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex v1, Vertex v2) {
        return Integer.compare(v1.getKey(), v2.getKey());
    }
}