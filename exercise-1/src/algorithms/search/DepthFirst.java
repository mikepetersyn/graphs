package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import graph.primitives.Vertex;
import graph.structures.AdjacenceListGraph;
import graph.structures.EdgeListGraph;
import graph.util.EdgeListScanner;

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
     * ArrayList holding vertices in topological order after a DFS has been
     * executed.
     */
    private ArrayList<Vertex> topSort;

    /**
     * EdgeListScanner is used for generating real (deep) copies of adjacence lists
     * within the initialization of the DFSForest (each list needs distinct vertice
     * objects and each of these objects corresponding adjacent vertices)
     */
    private EdgeListScanner els;

    /**
     * Flag used for indicating if we want to compute SCC on this graph
     */
    private boolean scc_flag;

    /**
     * Creates a DepthFirst object that is used to compute a depth first search on a
     * given graph passed in form of an adjacene list.
     * 
     * @param alg Adjacence List Graph that is to be computet
     */
    public DepthFirst(AdjacenceListGraph alg, EdgeListScanner els) {
        this.al = alg.getAdjacenceList();
        this.els = els;
        this.vs = new Stack<>();
        this.topSort = new ArrayList<>();
    }

    public ArrayList<Vertex> getTopSort() {
        return topSort;
    }

    public void setTopSort(ArrayList<Vertex> topSort) {
        this.topSort = topSort;
    }

    /**
     * Initializes the map used for managing the corresponding dfs-trees (processed
     * adjacence lists) by deep-copying the original adjacence list from the
     * adjacence-list-graph n-times and putting each into the map (n = number of
     * vertices) as a value (vertices are keys).
     */
    private void initDFSForest() {
        // check for null adjacence list
        if (al != null) {
            Vertex i;
            Vertex c;
            // initialize map with number of vertices
            this.dfsForest = new HashMap<>(this.al.size());
            // do this for every vertex in the adjacence list
            for (Vertex u : this.al) {
                if (this.scc_flag) {
                    EdgeListGraph elg_inv_tmp = els.scan();
                    elg_inv_tmp.inverseAllEdges();
                    this.dfsForest.put(u, new AdjacenceListGraph(elg_inv_tmp).getAdjacenceList());
                } else {
                    this.dfsForest.put(u, new AdjacenceListGraph(els.scan()).getAdjacenceList());
                }

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
    public void calcDFSForest() {
        // create a dict and an entry for every vertex in the graph
        initDFSForest();
        // for each list in the dict do a DFS beginning with the vertex
        // that is the key for each entry
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
        Vertex w;
        // select vertex at given index and add to stack
        this.vs.add(al.get(index));
        // while stack not empty
        while (!this.vs.empty()) {
            // peek element on stack (u) and
            u = this.vs.peek();
            // set fields of u only if u not visited
            if (!u.getVertexColor()) {
                time += 1;
                u.setKey(time);
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
                // get Vertex from original adjacence list
                w = this.al.get(u.getVertexName() - 1);
                // set final keys for topological sorting
                if (w.getFinalKey() == 0) {
                    w.setFinalKey(time += 1);
                    topSort.add(0, w);
                }

            }
        }
    }

    public boolean isScc_flag() {
        return scc_flag;
    }

    public void setScc_flag(boolean scc_flag) {
        this.scc_flag = scc_flag;
    }

}