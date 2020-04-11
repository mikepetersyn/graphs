package algorithms.path;

import graph.primitives.Edge;
import graph.primitives.Vertex;
import graph.structures.EdgeListGraph;

public class BellmanFord {

    private EdgeListGraph edgeListGraph;

    public BellmanFord(EdgeListGraph edgeListGraph) {
        this.edgeListGraph = edgeListGraph;
    }

    private int iterationThreshold(int i, int threshold) {
        return (i < threshold) ? 0 : 1;
    }

    /**
     * Implementation of the Bellman Ford algorithm for finding the shortest path
     * from a given starting Vertex passed as method parameter, to an arbitrary
     * vertex of the graph. For retrieving the shortest path to an arbitrary vertex,
     * just iterate over the predecessors of each vertex, starting with the desired
     * Vertex Uses the edgeList of the edgeListGraph passed to the constructor of
     * this class For finding
     * 
     * @param startVertex
     */
    public void doit(int startVertex) {
        Vertex u;
        Vertex v;
        int j;
        int len = edgeListGraph.getNumberVertices();
        // checking if given starting index is within range
        if ((0 < startVertex) && (startVertex <= len)) {
            // init
            this.edgeListGraph.findVertexByName(startVertex).setKey(0);
            // start algorithm
            for (int i = startVertex; i < (startVertex + len); i++) {
                j = i - (len * iterationThreshold(i, len + 1));
                for (Edge e : this.edgeListGraph.getEdgeList()) {
                    // operate only if current vertex name corresponds to element from edge list
                    if (e.getVertexA().getVertexName() == j) {
                        // setting vertices u and v for this operation
                        u = e.getVertexA();
                        v = e.getVertexB();
                        if (v.getKey() > u.getKey() + e.getWeight()) {
                            v.setKey(u.getKey() + e.getWeight());
                            v.setPredecessor(u);
                        }
                    }
                }

            }
            // condition testing cycles with negative weights
            for (Edge e : this.edgeListGraph.getEdgeList()) {
                if (e.getVertexB().getKey() > (e.getVertexA().getKey() + e.getWeight())) {
                    System.out.println("Stop. There is a cycle with negative weights");
                    break;
                }
            }
        } else
            System.out.println("starting vertex must be within range.");
    }
}
