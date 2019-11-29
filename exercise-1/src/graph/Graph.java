package graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph implements GraphExporter {

    private int numberVertices;

    private boolean isDirected;

    private String exportPath;

    public Graph() {
        this.isDirected = false;
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
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(("Graph " + graphName + " { \n"));
            for (int i = 0; i < edgeList.size(); i++) {
                writer.write(edgeList.get(i).getVertexA().getVertexName() + " -- "
                        + edgeList.get(i).getVertexB().getVertexName() + " \n");
            }
            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
