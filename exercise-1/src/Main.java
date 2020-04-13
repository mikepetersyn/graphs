import java.util.ArrayList;

import algorithms.mst.Kruskal;
import algorithms.mst.Prim;
import algorithms.path.BellmanFord;
import algorithms.path.Dijkstra;
import algorithms.path.FloydWarshall;
import algorithms.search.BreadthFirst;
import algorithms.search.DepthFirst;
import graph.primitives.Vertex;
import graph.structures.AdjacenceListGraph;
import graph.structures.AdjacenceMatrixGraph;
import graph.structures.EdgeListGraph;
import graph.util.EdgeListScanner;

public class Main {

        public static void main(String args[]) {

                final String EXPORTPATH = "/home/mikep/code_local/graphs/exercise-1/exports/";

                // DFS Test
                EdgeListScanner dfs_scanner = new EdgeListScanner(
                                "/home/mikep/code_local/graphs/exercise-1/files/search.txt", true, false);

                EdgeListGraph dfs_elg = dfs_scanner.scan();
                AdjacenceListGraph dfs_alg = new AdjacenceListGraph(dfs_elg);
                DepthFirst depthFirst = new DepthFirst(dfs_alg, dfs_scanner);
                depthFirst.calcDFSForest(); // method 'doIt' does a single-DFS, whereby
                                            // 'calcDFSForest' calls 'doIt' multiple times
                ArrayList<Vertex> topSorted_1 = depthFirst.getTopSort();

                // TopSortTest-Graph Test
                EdgeListScanner topsort_scanner = new EdgeListScanner(
                                "/home/mikep/code_local/graphs/exercise-1/files/topSortTest.txt", true, false);
                EdgeListGraph topsort_elg = topsort_scanner.scan();
                AdjacenceListGraph topsort_alg = new AdjacenceListGraph(topsort_elg);
                DepthFirst topsort = new DepthFirst(topsort_alg, topsort_scanner);
                topsort.calcDFSForest();
                ArrayList<Vertex> topSorted_2 = topsort.getTopSort();

                // BFS Test
                EdgeListScanner bfs_scanner = new EdgeListScanner(
                                "/home/mikep/code_local/graphs/exercise-1/files/search.txt", true, false);
                EdgeListGraph bfs_elg = bfs_scanner.scan();
                AdjacenceListGraph bfs_alg = new AdjacenceListGraph(bfs_elg);
                BreadthFirst breadthFirst = new BreadthFirst(bfs_alg, bfs_elg);
                breadthFirst.doIt(1);

                // MST Test
                EdgeListScanner primkruskal_scanner = new EdgeListScanner(
                                "/home/mikep/code_local/graphs/exercise-1/files/primkruskal.txt", false, true);
                EdgeListGraph prim_elg = primkruskal_scanner.scan();
                // Prim
                AdjacenceListGraph prim_alg = new AdjacenceListGraph(prim_elg);
                Prim prim = new Prim(prim_alg, prim_elg);
                prim.doit(1);
                // Kruskal
                EdgeListGraph kruskal_elg = primkruskal_scanner.scan();
                Kruskal kruskal = new Kruskal(kruskal_elg);
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

                // EXPORT TEST
                // EdgeListScanner export_scanner = new EdgeListScanner(
                // "/home/mikep/code_local/graphs/exercise-1/files/dijkstra.txt", true, true);
                // EdgeListGraph export_test_elg = export_scanner.scan();
                // export_test_elg.setExportPath(EXPORTPATH);
                // export_test_elg.exportGraph(dijkstra_elg.getEdgeList());

                // Spider Export Test
                EdgeListScanner spider_scanner = new EdgeListScanner(
                                "/home/mikep/code_local/graphs/exercise-1/files/spider.txt", true, true);

                EdgeListGraph spider_elg = spider_scanner.scan();
                spider_elg.setExportPath(EXPORTPATH);
                spider_elg.exportGraph(spider_elg.getEdgeList());
        }
}