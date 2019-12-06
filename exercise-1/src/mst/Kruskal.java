package mst;

import java.util.ArrayList;
import java.util.TreeSet;

import ext.UnionFind;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Vertex;

public class Kruskal {
    private TreeSet<Vertex> setToDrawFrom;
    private TreeSet<Vertex> setToAddTo;
    private UnionFind<Vertex> unionFind;
    // is sorted by Weight after constructor call
    private ArrayList<Edge> edgeList;
    private ArrayList<Edge> mstEdgeList;

    public void printEdgeList() {
        for (Edge edge : this.edgeList) {
            System.out.println(edge.getVertexA().getVertexName() + " " + edge.getWeight() + " "
                    + edge.getVertexB().getVertexName());
        }
    }

    public Kruskal(EdgeListGraph edgeListGraph) {
        this.edgeList = edgeListGraph.sortEdgeListByWeight(edgeListGraph.getEdgeList());
        this.setToDrawFrom = new TreeSet<Vertex>(edgeListGraph.returnEdgeListAsVertexList(this.edgeList));
        this.setToAddTo = new TreeSet<>();
        this.unionFind = new UnionFind<Vertex>(this.setToAddTo);
    }

    public void doIt() {
        // take each edge from edgeList, edges with lower weight first
        for (Edge edge : this.edgeList) {
            // check if both vertices from edge are already in unionFind
            if (!(this.unionFind.inSameSet(edge.getVertexA(), edge.getVertexB()))) {
                // - if not then add this edge to the spanning
                // tree graph and add its vertices to the unionFind
                this.mstEdgeList.add(edge);
                unionFind.addElement(edge.getVertexA());
                unionFind.addElement(edge.getVertexB());
            }
            // - if yes then skip -> else would create loop

        }

    }
}