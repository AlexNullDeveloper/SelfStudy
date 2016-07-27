package algorithms.graphs;

import java.util.List;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public abstract class Graph {
    private int numVertices;
    private int numEdges;

    public Graph() {
        numEdges = 0;
        numVertices = 0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public abstract void implementAddVertex();

    public abstract void implementAddEdge(int v, int w);

    public abstract List<Integer> getNeighbors(int v);
}
