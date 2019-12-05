package graph;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class AdjacenceListGraph extends Graph {

    private ArrayList<ArrayList<Vertex>> adjacenceList = new ArrayList<>();

    public ArrayList<ArrayList<Vertex>> getAdjacenceList() {
        return adjacenceList;
    }

    public Vertex returnRandomVertex (){
        SecureRandom sr = new SecureRandom();
        int boundEdges = getAdjacenceList().size();
        ArrayList<Vertex> selectedVerticeList = getAdjacenceList().get(sr.nextInt(boundEdges));
        while (selectedVerticeList.size() == 0){
            selectedVerticeList = getAdjacenceList().get(sr.nextInt(boundEdges));
        }
        return selectedVerticeList.get(sr.nextInt(selectedVerticeList.size()));
    }

    public AdjacenceListGraph(EdgeListGraph elg){
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = false;
    }

    public AdjacenceListGraph(EdgeListGraph elg, boolean isDirected){
        init(elg.getNumberVertices());
        convertFromEdgeList(elg.getEdgeList());
        super.isDirected = isDirected;
    }

    private void init(int numberVertices) {
        for (int i = 0; i < numberVertices; i++) {
            this.adjacenceList.add(new ArrayList<Vertex>());
        }
    }

    private void convertFromEdgeList(List<Edge> edgeList){
        for (int i = 0; i < edgeList.size(); i++) {
            this.adjacenceList.get(
                    edgeList.get(i).getVertexA().getVertexName()
            ).add(new Vertex(edgeList.get(i).getVertexB().getVertexName()));
        }
    }

    public ArrayList<Edge> convertToEdgeList(){
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < this.adjacenceList.size(); i++){
            for (int j = 0; j < this.adjacenceList.get(i).size(); j++){
                edgeList.add(new Edge( new Vertex(i), new Vertex(
                        this.adjacenceList.get(i).get(j).getVertexName()
                ) ));
            }
        }
        return edgeList;
    }
}
