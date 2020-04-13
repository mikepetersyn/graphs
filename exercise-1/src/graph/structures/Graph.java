package graph.structures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import graph.primitives.Edge;
import graph.util.GraphExporter;

public class Graph implements GraphExporter {

    private int numberVertices;

    protected boolean isDirected;

    protected boolean isWeighted;

    private String exportPath;

    public Graph() {
        this.isDirected = false;
    }

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public int getNumberVertices() {
        return numberVertices;
    }

    public void setNumberVertices(int numberVertices) {
        this.numberVertices = numberVertices;
    }

    @Override
    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }

    @Override
    public String getExportPath() {
        return this.exportPath;
    }

    @Override
    public void exportGraph(ArrayList<Edge> edgeList) {
        boolean nameNotUnique = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a file name: ");
        String graphName = scanner.nextLine();
        String filePath = this.exportPath + graphName + ".gv";
        File tmpDir = new File(filePath);
        String edgeSymbol = "";
        String graphStyle = "";

        while (nameNotUnique) {

            if (tmpDir.exists()) {
                System.out
                        .println(String.format("The file %s at the location %s already exists.\n", graphName, filePath)
                                + "Please enter a different file name: ");
                while (scanner.hasNextLine()) {
                    graphName = scanner.nextLine();
                }
                tmpDir = new File(exportPath + graphName + ".gv");
            } else {
                nameNotUnique = false;
                filePath = exportPath + graphName + ".gv";
                scanner.close();
            }

        }

        try {
            if (this.isDirected) {
                edgeSymbol = " -> ";
                graphStyle = "digraph";
            } else {
                edgeSymbol = " -- ";
                graphStyle = "graph";
            }

            FileWriter writer = new FileWriter(filePath, false);

            writer.write((graphStyle + " " + graphName + " { \n"));
            for (int i = 0; i < edgeList.size(); i++) {
                writer.write(edgeList.get(i).getVertexA().getVertexName() + edgeSymbol
                        + edgeList.get(i).getVertexB().getVertexName());
                if (this.isWeighted) {
                    writer.write(" [label=" + edgeList.get(i).getWeight() + "];" + "\n");
                } else {
                    writer.write("\n");
                }
            }
            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
