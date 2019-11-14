package graph;

public class Edge {

    private int vA;
    private int vB;

    public Edge(int vA, int vB) {
        this.vA = vA;
        this.vB = vB;
    }

    public int getvA() {
        return vA;
    }

    public int getvB() {
        return vB;
    }

    public void setvA(int vA) {
        this.vA = vA;
    }

    public void setvB(int vB) {
        this.vB = vB;
    }

}

