package algorithms.path;

import java.util.PriorityQueue;

import graph.primitives.Vertex;
import graph.primitives.VertexKeyComparator;
import graph.structures.AdjacenceListGraph;
import graph.structures.EdgeListGraph;

public class Dijkstra {

    private PriorityQueue<Vertex> vPriorityQueue;
    private VertexKeyComparator vKeyComparator;
    private EdgeListGraph edgeListGraph;

    public Dijkstra(EdgeListGraph edgeListGraph, AdjacenceListGraph adjacenceListGraph) {
        this.edgeListGraph = edgeListGraph;
        this.vKeyComparator = new VertexKeyComparator();
        this.vPriorityQueue = new PriorityQueue<>(this.edgeListGraph.getNumberVertices(), this.vKeyComparator);
    }

    public void doIt(int startVertex) {
        Vertex u;
        int d;
        // init
        this.edgeListGraph.findVertexByName(startVertex).setKey(0);
        this.vPriorityQueue.addAll(this.edgeListGraph.getVertexList());
        // start
        while (!this.vPriorityQueue.isEmpty()) {
            // extract element with min key (distance)
            u = this.vPriorityQueue.poll();
            for (Vertex v : u.getAdjacentVertices()) {
                // complete distance from Start via Vertex u to Vertex v
                d = u.getKey() + this.edgeListGraph.findEdgeByVertices(u, v).getWeight();
                if (d < v.getKey()) {
                    // update distance and set predecessor of v
                    v.setKey(d);
                    v.setPredecessor(u);
                    // remove and add vertex in order to update the Queue
                    vPriorityQueue.remove(v);
                    vPriorityQueue.add(v);
                }
            }

        }
    }

    public void printShortestPath(int startVertex) {

    }
}
