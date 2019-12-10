package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.AdjacenceListGraph;
import graph.Vertex;

public class BreadthFirst {

    private Queue<Vertex> vq;

    private ArrayList<Vertex> al;

    public BreadthFirst(AdjacenceListGraph alg) {
        this.al = alg.getAdjacenceList();
        this.vq = new LinkedList<>();
    }

    public ArrayList<Vertex> getAl() {
        return al;
    }

    // FIXME: Problem with not referencing original vertices
    // references within adjacentVertices must be referencing the
    // the same objects as in the adjacence list!!!
    public void doIt(int startIndex) {
        // declare Vertex v
        Vertex u;
        // add vertex of adjacence list at index to queue
        if ((startIndex <= this.al.size()) && (startIndex >= 0)) {
            // set distance of starting vertex to 0
            this.al.get(startIndex).setDistance(0);
            this.vq.add(this.al.get(startIndex));
            // loop while queue is not empty
            while (this.vq.peek() != null) {
                // poll head of queue into v
                u = this.vq.poll();
                // go for every vertex that is adjacent to u
                for (Vertex v : u.getAdjacentVertices()) {
                    // check if vertex is white (false)
                    if (!v.getVertexColor()) {
                        v.setVertexColor(true);
                        v.setDistance(u.getDistance() + 1);
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