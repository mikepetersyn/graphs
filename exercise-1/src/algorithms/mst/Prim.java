package algorithms.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;

import graph.primitives.Vertex;
import graph.primitives.VertexKeyComparator;
import graph.structures.AdjacenceListGraph;
import graph.structures.EdgeListGraph;

public class Prim {

    private AdjacenceListGraph adjacenceListGraph;
    private EdgeListGraph edgeListGraph;
    private VertexKeyComparator vKeyComparator;
    private PriorityQueue<Vertex> vPriorityQueue;

    public Prim(AdjacenceListGraph adjacenceListGraph, EdgeListGraph edgeListGraph) {
        this.adjacenceListGraph = adjacenceListGraph;
        this.edgeListGraph = edgeListGraph;
        this.vKeyComparator = new VertexKeyComparator();
        this.vPriorityQueue = new PriorityQueue<>(this.edgeListGraph.getNumberVertices(), this.vKeyComparator);
    }

    private void init(int startIndex) {
        // add all vertices to priority queue
        this.vPriorityQueue.addAll(this.edgeListGraph.getVertexList());
        // set key of starting vertex to 0 (predecessor = null and key = INIFITY per
        // default)
        this.edgeListGraph.findVertexByName(startIndex).setKey(0);
    }

    // expects two vertices and returns the weight of the corresponding edge by
    // (1) finding the edge, the two vertices belong to and (2) retrieve its weight
    private int weightFunction(Vertex u, Vertex v) {
        return this.edgeListGraph.findEdgeByVertices(u, v).getWeight();
    }

    public void doit(int startIndex) {
        Vertex u;
        int w;
        this.init(startIndex);
        while (!this.vPriorityQueue.isEmpty()) {
            u = vPriorityQueue.poll();
            for (Vertex v : u.getAdjacentVertices()) {
                w = this.weightFunction(u, v);
                if (vPriorityQueue.contains(v) && w < v.getKey()) {
                    v.setPredecessor(u);
                    v.setKey(w);
                    // remove and add vertex in order to update the Queue
                    vPriorityQueue.remove(v);
                    vPriorityQueue.add(v);
                }
            }
        }
    }

}