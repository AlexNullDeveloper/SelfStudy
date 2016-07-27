package algorithms.graphs;

import java.util.List;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class GraphAdjMatrix extends Graph {
    private int[][] adjMatrix;

    @Override
    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++) {
            adjMatrix[v][i] = 0;
        }

    }

    @Override
    public List<Integer> getNeighbors(int v) {
        //TODO realize
        return null;
    }
}
