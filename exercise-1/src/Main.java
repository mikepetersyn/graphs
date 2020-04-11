import algorithms.mst.Kruskal;
import algorithms.mst.Prim;
import algorithms.path.BellmanFord;
import algorithms.path.Dijkstra;
import algorithms.path.FloydWarshall;
import algorithms.search.BreadthFirst;
import algorithms.search.DepthFirst;
import graph.structures.AdjacenceListGraph;
import graph.structures.AdjacenceMatrixGraph;
import graph.structures.EdgeListGraph;
import graph.util.EdgeListScanner;

public class Main {

    public static void main(String args[]) {

        final String EXPORTPATH = "/home/mikep/code_local/graphs/exercise-1/exports/";

        // Search Test
        EdgeListScanner search_scanner = new EdgeListScanner(
                "/home/mikep/code_local/graphs/exercise-1/files/search.txt", true, false);
        EdgeListGraph search_elg = search_scanner.scan();
        AdjacenceListGraph search_alg = new AdjacenceListGraph(search_elg);
        // DFS
        DepthFirst depthFirst = new DepthFirst(search_alg);
        depthFirst.calcDFSForest(); // method 'doIt' does a single-DFS, whereby
                                    // 'calcDFSForest' calls 'doIt' multiple times
        // BFS
        BreadthFirst breadthFirst = new BreadthFirst(search_alg, search_elg);
        breadthFirst.doIt(1);

        // MST Test
        EdgeListScanner primkruskal_scanner = new EdgeListScanner(
                "/home/mikep/code_local/graphs/exercise-1/files/primkruskal.txt", false, true);
        EdgeListGraph primkruskal_elg = primkruskal_scanner.scan();
        // Prim
        AdjacenceListGraph prim_alg = new AdjacenceListGraph(primkruskal_elg);
        Prim prim = new Prim(prim_alg, primkruskal_elg);
        prim.doit(1);
        // Kruskal
        Kruskal kruskal = new Kruskal(primkruskal_elg);
        kruskal.calcMinSpanningTree();

        // Floyd-Warshall Test
        EdgeListScanner floydWarshall_scanner = new EdgeListScanner(
                "/home/mikep/code_local/graphs/exercise-1/files/FloydWarshall.txt", true, true);
        EdgeListGraph floydWarshall_elg = floydWarshall_scanner.scan();
        AdjacenceMatrixGraph floydWarshall_amg = new AdjacenceMatrixGraph(floydWarshall_elg, true, true);
        FloydWarshall floydWarshall = new FloydWarshall(floydWarshall_amg);
        floydWarshall.doIt();

        // Dijkstra Test
        EdgeListScanner dijkstra_scanner = new EdgeListScanner(
                "/home/mikep/code_local/graphs/exercise-1/files/dijkstra.txt", true, true);
        EdgeListGraph dijkstra_elg = dijkstra_scanner.scan();
        AdjacenceListGraph dijkstra_alg = new AdjacenceListGraph(dijkstra_elg, true);
        Dijkstra dijkstra = new Dijkstra(dijkstra_elg, dijkstra_alg);
        dijkstra.doIt(5); // integer value passed as starting vertex

        // Bellmann-Ford Test
        EdgeListScanner bellmannFord_scanner = new EdgeListScanner(
                "/home/mikep/code_local/graphs/exercise-1/files/bellmannford.txt", true, true);
        EdgeListGraph bellmannFord_elg = bellmannFord_scanner.scan();
        BellmanFord bellmanFord = new BellmanFord(bellmannFord_elg);
        bellmanFord.doit(1);

    }
}