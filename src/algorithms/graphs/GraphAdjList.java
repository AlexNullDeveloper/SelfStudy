package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class GraphAdjList extends Graph {
    private Map<Integer, ArrayList<Integer>> adjListMap;


    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListMap.put(v, neighbors);
    }

    @Override
    public void implementAddEdge(int v, int w) {
        (adjListMap.get(v)).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        //TODO realize
        return null;
    }
}
