import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String [] args){
        WeightedGraph graph = createRandomCompleteWeightedGraph(30);
        HashMap<Node, Integer> output = dijkstras(graph.getNode("0"));


    }
    public static WeightedGraph createRandomCompleteWeightedGraph(final int n){
        WeightedGraph graph = new WeightedGraph();
        for (int i =0; i<n; i++){
            graph.addNode(Integer.toString(i));
        }
        Random rand = new Random();
        for (Node node : graph.getAllNodes()){
            for (Node node2: graph.getAllNodes()){
                if (node!=node2){
                    graph.addWeightedEdge(node,node2,rand.nextInt(9)+1);
                }
            }
        }

        return graph;
    }

    public static WeightedGraph createLinkedList(final int n){
        WeightedGraph graph = new WeightedGraph();
        for (int i =0; i<n; i++){
            graph.addNode(Integer.toString(i));
        }
        Node[] nodes = graph.getAllNodes().toArray(new Node[0]);
        Arrays.sort(nodes);
        for(int i = 1; i < nodes.length; i++){
            graph.addWeightedEdge((Node)nodes[i], (Node) nodes[i-1], 1);
        }
        return graph;
    }

    public static HashMap<Node, Integer> dijkstras(final Node start){
        HashMap<Node, Integer> mapping = new HashMap<>();
        for (Node dest : start.children.keySet()){
            mapping.put(dest, dijkstrasShortestDistance(start,dest));
        }
        return mapping;
    }

    public static int dijkstrasShortestDistance(final Node start, final Node dest){
        HashMap<Node, Integer> distances = new HashMap<>();
        HashSet<Node> finalized = new HashSet<>();
        distances.put(start,0);
        Node curr = start;
        while (curr != dest){
            finalized.add(curr);
            for (Node child: curr.children.keySet()){
                if (!finalized.contains(child)){
                    int distance = distances.get(curr) + curr.children.get(child);
                    if (!distances.containsKey(child) || distance<distances.get(child)){
                        distances.put(child, distance);
                    }
                }
            }
            int minDistance = Integer.MAX_VALUE;
            for (Node n: distances.keySet()){
                if (distances.get(n) < minDistance && !finalized.contains(n)){
                    curr = n;
                    minDistance = distances.get(n);
                }
            }
        }
        return distances.get(dest);
    }
}
