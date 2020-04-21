import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Graph {
    HashMap<Node, HashSet<Node>> graph;

    public Graph(){
        graph = new HashMap<Node, HashSet<Node>>();
    }

    public void addNode(final String nodeVal){
        Node node = new Node(nodeVal);
        if (!graph.containsKey(node))
            graph.put(node, new HashSet<>());
    }

    public void addUndirectedEdge(final Node first, final Node second){
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    public void removeUndirectedEdge(final Node first, final Node second){
        graph.get(first).remove(second);
        graph.get(second).remove(first);
    }

    public HashSet<Node> getAllNodes(){
        return new HashSet<Node>(graph.keySet());
    }

    public HashSet<Node> getChildren(Node node){
        return this.graph.get(node);
    }


    public Node getNode(final String value){
        HashSet<Node> nodes = getAllNodes();
        for (Node n : nodes){
            if (n.value.equals(value))
                return n;
        }
        return null;
    }
}
