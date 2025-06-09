package graphidentifier;

import graph.GraphLink;
import graph.Vertex;
import java.util.*;

public class GraphTypeIdentifier {

    // Método para identificar si el grafo es un camino
    public static boolean isPath(GraphLink graph) {
        for (Vertex vertex : graph.getVertices()) {
            if (graph.getDegree(vertex) != 2) {
                return false; 
            }
        }
        return true;
    }

    // Método para identificar si el grafo es un ciclo
    public static boolean isCycle(GraphLink graph) {
        if (isPath(graph)) {
            for (Vertex vertex : graph.getVertices()) {
                if (graph.getDegree(vertex) == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
