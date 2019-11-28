package graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EdgeListGraph extends Graph {

    private int numberVertices;

    public int getNumberVertices() {
        return numberVertices;
    }

    public int getNumberEdges() {
        return edgeList.size();
    }

    public void setNumberVertices(int numberVertices) {
        this.numberVertices = numberVertices;
    }

    private ArrayList<Edge> edgeList = new ArrayList<>();

    public EdgeListGraph(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public void addEdge(Edge e){
        edgeList.add(e);
    }


    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public void export(ArrayList<Edge> edgeList, String graphName) {
        File tmpDir = new File("./exports/" + graphName + ".gv");
        boolean exists = tmpDir.exists();
        if (! exists) {
            int listSize = edgeList.size();
            try {
                FileWriter writer = new FileWriter(
                        "./exports/" + graphName + ".gv", true);
                writer.write(("Graph " + graphName + " { \n"));
                for (int i = 0; i < listSize; i++) {
                    writer.write(
                            edgeList.get(i).getvA().getVerticeNumber() + " -- " +
                                    edgeList.get(i).getvB().getVerticeNumber() + " \n");
                }
                writer.write("}");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("File " + graphName +".gv " + "already exists.");
    }
}
