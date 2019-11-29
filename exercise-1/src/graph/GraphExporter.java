package graph;

import java.util.ArrayList;

public interface GraphExporter {

    public void setExportPath(String exportPath);

    public String getExportPath();

    public void exportGraph(ArrayList<Edge> edgeList);

}