package graph;

public class Vertex implements Comparable<Vertex> {

    private int vertexName;

    // false -> white color
    // true -> black color
    private boolean vertexColor;

    public Vertex(int vertexName) {
        this.vertexName = vertexName;
        this.vertexColor = false;
    }

    public Vertex(int vertexName, boolean vertexColor) {
        this.vertexName = vertexName;
        this.vertexColor = vertexColor;
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public boolean getVertexColor() {
        return vertexColor;
    }

    public void setVertexColor(boolean vertexColor) {
        this.vertexColor = vertexColor;
    }

    @Override
    public int compareTo(Vertex v) {
        if (vertexName == v.vertexName) {
            return 0;
        } else if (vertexName > v.vertexName) {
            return 1;
        } else
            return -1;
    }

}