package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import graph.AdjacenceListGraph;
import graph.Vertex;

public class DepthFirst {

    // class wide call stack used in doit()
    private Stack<Vertex> vs;

    // original adjacence list from adjacence list graph
    // does not get changed but is used as a reference
    // for returning the corresponding tree of every vertex
    // after getTree() was called
    private ArrayList<Vertex> al;

    // declare map as forest that holds as many
    // adjacence lists as vertices in the graph
    // maybe with init method
    private Map<Vertex, ArrayList<Vertex>> dfsForest;

    /**
     * Creates a DepthFirst object that is used to compute a depth first search on a
     * given graph passed in form of an adjacene list.
     * 
     * @param alg Adjacence List Graph that is to be computet
     */
    public DepthFirst(AdjacenceListGraph alg) {
        this.al = alg.getAdjacenceList();
        this.vs = new Stack<>();
    }

    /**
     * Initializes the map used for managing the corresponding dfs-trees (processed
     * adjacence lists) by deep-copying the original adjacence list from the
     * adjacence-list-graph n-times and putting each into the map (n = number of
     * vertices) as a value (vertices are keys).
     */
    private void initDfsForest() {
        // check for null adjacence list
        if (al != null) {
            // prepare iterator for deep copy
            Iterator<Vertex> iterator = this.al.iterator();
            // initialize map with number of vertices
            this.dfsForest = new HashMap<>(this.al.size());
            // do this for every vertice in the adjacence list
            for (Vertex u : this.al) {
                // init new copy of adjacence list
                ArrayList<Vertex> treeList = new ArrayList<>(this.al.size());
                // deep copy original adjacence list
                while (iterator.hasNext()) {
                    treeList.add(iterator.next().clone());
                }
                // add vertex and corresponding treelist to dict
                this.dfsForest.put(u, treeList);
            }
        } else
            System.out.println("Adjacence List must be initialized in order to initialize the forest.");
    }

    /**
     * Returns a tree out of a forest for a certain vertex from the original
     * adjacence graph (i.e. list).
     * 
     * @param v Vertex whose tree is to be returned
     * @return DFS-Tree in form of an processed adjacence list
     */
    public ArrayList<Vertex> getTree(Vertex v) {
        return this.dfsForest.get(v);
    }

    /**
     * computes a tree out of a forest for a certain vertex from the original
     * adjacence graph (i.e. list)
     */
    public void getDFSForest() {
        // create a dict and an entry for every vertex in the graph
        initDfsForest();
        // for each list in the dict do the search and begin with the vertex
        // that is the key (have to get the index)
        for (Map.Entry<Vertex, ArrayList<Vertex>> entry : this.dfsForest.entrySet()) {
            this.doit(entry.getValue(), entry.getKey().getVertexName() - 1);
        }
    }

    // do a depth first search for one vertex at a given index in a adjacence list
    // not thread-safe because of class-wide call-stack
    public void doit(ArrayList<Vertex> al, int index) {
        // init
        int time = 0;
        Vertex u;
        // select random vertex u and add to stack
        this.vs.add(al.get(0));
        // while stack not empty
        while (!this.vs.empty()) {
            // peek element on stack (u) and
            u = this.vs.peek();
            // set fields of u only if u not visited
            if (!u.getVertexColor()) {
                time += 1;
                u.setDistance(time);
                u.setVertexColor(true);
                // check adjacent vertices of u
                for (Vertex v : u.getAdjacentVertices()) {
                    // only if v is not colored
                    if (!v.getVertexColor()) {
                        // set u as predecessor of v
                        v.setPredecessor(u);
                        // add v to stack
                        this.vs.add(v);
                    }
                }
            } else {
                // break down the stack and set final distances
                vs.pop();
                if (u.getFinalDistance() == 0)
                    u.setFinalDistance(time += 1);
            }
        }
    }

}