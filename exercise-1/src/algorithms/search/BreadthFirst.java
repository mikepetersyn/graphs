package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import graph.primitives.Vertex;
import graph.structures.AdjacenceListGraph;
import graph.structures.EdgeListGraph;

public class BreadthFirst {

    private Queue<Vertex> vq;

    private ArrayList<Vertex> al;

    private HashSet<Vertex> vl;

    private EdgeListGraph elg;

    public BreadthFirst(AdjacenceListGraph alg, EdgeListGraph elg) {
        this.al = alg.getAdjacenceList();
        this.vl = elg.getVertexList();
        this.elg = elg;
        this.vq = new LinkedList<>();
    }

    public ArrayList<Vertex> getAl() {
        return al;
    }

    public void doItFull(int startIndex) {
        Vertex test;
        int i = startIndex;
        do {
            this.doIt(i);
            test = elg.findUncolored(this.vl);
            if (test != null)
                i = test.getVertexName();
        } while (elg.findUncolored(this.vl) != null);
    }

    public void doIt(int startIndex) {
        // declare Vertex v
        Vertex u;
        // add vertex of adjacence list at index to queue
        if ((startIndex <= this.al.size()) && (startIndex > 0)) {
            // set distance of starting vertex to 0
            this.al.get(startIndex - 1).setKey(0);
            this.vq.add(this.al.get(startIndex - 1));
            // loop while queue is not empty
            while (this.vq.peek() != null) {
                // poll head of queue into u
                u = this.vq.poll();
                // go for every vertex that is adjacent to u
                for (Vertex v : u.getAdjacentVertices()) {
                    // check if vertex is white (false)
                    if (!v.getVertexColor()) {
                        v.setVertexColor(true);
                        v.setKey(u.getKey() + 1);
                        v.setPredecessor(u);
                        this.vq.add(v);
                    }
                }
                // set color of u to black (true)
                u.setVertexColor(true);
            }
        } else
            System.out.println("Wrong starting index. Please correct.");
    }
}