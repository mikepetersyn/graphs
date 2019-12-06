package graph;

public class Vertex {

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
}