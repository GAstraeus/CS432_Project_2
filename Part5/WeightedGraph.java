import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WeightedGraph{
    ArrayList<Node> graph;

    public WeightedGraph(){
        graph = new ArrayList<>();
    }

    public void addNode(final String nodeVal){
        Node node = new Node(nodeVal);
        this.graph.add(node);
    }

    public void addWeightedEdge(final Node first, final Node second, final int edgeWeight){

        if (!first.children.containsKey(second)) {
            first.children.put(second, edgeWeight);
            second.indegree++;
        }
    }

    public void removeDirectedEdge(final Node first, final Node second){
        first.children.remove(second);
        second.indegree--;
    }

    public HashSet<Node> getAllNodes(){
        return new HashSet<Node>(graph);
    }

    public HashMap<Node, Integer> getChildren(Node node){
        return this.graph.get(graph.indexOf(node)).children;
    }

    public Node getNode(final String value){
        HashSet<Node> nodes = getAllNodes();
        for (Node n : nodes){
            if (n.value.equals(value))
                return n;
        }
        return null;
    }

    private Node getNode(final Node node){
        return graph.get(graph.indexOf(node));
    }

    public HashMap<Node, Integer> getIndegrees(){
        HashMap<Node, Integer> out = new HashMap<>();
        for (Node node : this.getAllNodes()){
            out.put(node, node.indegree);
        }
        return out;
    }
}
