package graph;

public class Vertex {

    public Vertex(int verticeNumber) {
        this.verticeNumber = verticeNumber;
    }

    public Vertex(int verticeNumber, boolean color) {
        this.verticeNumber = verticeNumber;
        this.color = color;
    }

    private int verticeNumber;

    private boolean color;

    public int getVerticeNumber() {
        return verticeNumber;
    }

    public void setVerticeNumber(int verticeNumber) {
        this.verticeNumber = verticeNumber;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

}
