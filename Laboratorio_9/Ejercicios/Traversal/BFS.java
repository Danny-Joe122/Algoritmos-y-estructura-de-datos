package traversal;

import graph.Vertex;
import graph.Edge;
import java.util.*;

public class BFS {
    public static void bfs(Vertex startVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getName() + " ");

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getOtherVertex(current);
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
