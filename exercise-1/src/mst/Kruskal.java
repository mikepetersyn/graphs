package mst;

import java.util.ArrayList;
import java.util.TreeSet;

import ext.UnionFind;
import graph.Edge;
import graph.EdgeListGraph;
import graph.Vertex;

public class Kruskal {

    private UnionFind<Integer> verticeSet;
    private ArrayList<Edge> edgeList;
    private ArrayList<Edge> mstEdgeList;

    public Kruskal(EdgeListGraph edgeListGraph) {
        this.edgeList = edgeListGraph.sortEdgeListByWeight(edgeListGraph.getEdgeList());
        this.verticeSet = new UnionFind<Integer>(new TreeSet<Integer>(edgeListGraph.returnEdgeListAsVertexNameList()));
        this.mstEdgeList = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getMstEdgeList() {
        return mstEdgeList;
    }

    public UnionFind<Integer> getVerticeSet() {
        return verticeSet;
    }

    public void calcMinSpanningTree() {
        for (Edge edge : this.edgeList) {
            int a = edge.getVertexA().getVertexName();
            int b = edge.getVertexB().getVertexName();
            if (!(this.verticeSet.inSameSet(a, b))) {
                this.mstEdgeList.add(edge);
                this.verticeSet.union(a, b);
            }
        }
    }

    public void printEdgeList() {
        for (Edge edge : this.edgeList) {
            System.out.println(edge.getVertexA().getVertexName() + " " + edge.getWeight() + " "
                    + edge.getVertexB().getVertexName());
        }
    }

}