package graph.util;

import java.util.ArrayList;

import graph.primitives.Edge;

public interface GraphExporter {

    public void setExportPath(String exportPath);

    public String getExportPath();

    public void exportGraph(ArrayList<Edge> edgeList);

}