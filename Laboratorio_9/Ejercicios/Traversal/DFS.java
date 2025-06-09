package traversal;

import graph.Vertex;
import graph.Edge;
import java.util.*;

public class DFS {
    public static void dfs(Vertex startVertex, Set<Vertex> visited) {
        visited.add(startVertex);
        System.out.print(startVertex.getName() + " ");

        for (Edge edge : startVertex.getEdges()) {
            Vertex neighbor = edge.getOtherVertex(startVertex);
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
