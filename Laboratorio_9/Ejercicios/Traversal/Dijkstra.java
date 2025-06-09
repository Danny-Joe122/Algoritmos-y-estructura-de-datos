package traversal;

import graph.Vertex;
import graph.Edge;
import java.util.*;

public class Dijkstra {
    public static List<Vertex> dijkstra(List<Vertex> vertices, Vertex start, Vertex end) {
        Map<Vertex, Integer> dist = new HashMap<>();
        Map<Vertex, Vertex> prev = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (Vertex vertex : vertices) {
            dist.put(vertex, Integer.MAX_VALUE);
            prev.put(vertex, null);
        }

        dist.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.equals(end)) break;

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getOtherVertex(current);
                int alt = dist.get(current) + edge.getWeight();
                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Vertex> path = new ArrayList<>();
        for (Vertex at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
