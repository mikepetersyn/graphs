package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacenceListGraph extends Graph {

    private ArrayList<ArrayList<Vertex>> adjacenceList = new ArrayList<>();

    public ArrayList<ArrayList<Vertex>> getAdjacenceList() {
        return adjacenceList;
    }

    public AdjacenceListGraph(EdgeListGraph elg){
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
    }

    private void init(int numberVertices) {
        for (int i = 0; i < numberVertices; i++) {
            this.adjacenceList.add(new ArrayList<Vertex>());
        }
    }

    private void convertFromEdgeList(List<Edge> edgeList){
        for (int i = 0; i < edgeList.size(); i++) {
            this.adjacenceList.get(
                    edgeList.get(i).getvA().getVerticeNumber()
            ).add(new Vertex(edgeList.get(i).getvB().getVerticeNumber()));
        }
    }

    public ArrayList<Edge> convertToEdgeList(ArrayList<ArrayList<Vertex>> adjacenceList){
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < adjacenceList.size(); i++){
            for (int j = 0; j < adjacenceList.get(i).size(); j++){
                edgeList.add(new Edge( new Vertex(i), new Vertex(
                        adjacenceList.get(i).get(j).getVerticeNumber()
                ) ));
            }
        }
        return edgeList;
    }
}
