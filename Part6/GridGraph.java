import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GridGraph{
    ArrayList<Node> graph;
    public int length;

    public GridGraph(int length){
        graph = new ArrayList<>();
        this.length = length;
    }

    public void addNode(final int x, final int y, final String nodeVal){
        Node node = new Node(x,y,nodeVal);
        this.graph.add(node);
    }

    public void addUndirectedEdge(final Node first, final Node second){
            first.children.add(second);
            second.children.add(first);
    }

    public void removeDirectedEdge(final Node first, final Node second){
        first.children.remove(second);
        second.children.remove(first);
    }

    public HashSet<Node> getAllNodes(){
        return new HashSet<Node>(graph);
    }

    public HashSet<Node> getChildren(Node node){
        return this.graph.get(graph.indexOf(node)).children;
    }

    public Node getNode(final int x, final int y){
        HashSet<Node> nodes = getAllNodes();
        for (Node n : nodes){
            if (n.x == x && n.y==y)
                return n;
        }
        return null;
    }

    private Node getNode(final Node node){
        return graph.get(graph.indexOf(node));
    }

    public  HashSet<Node> getValidChildren(Node node){
        HashSet<Node> children = new HashSet<>();
        if (node.x-1 >= 0)
            children.add(getNode(node.x-1,node.y));
        if (node.x+1 < length)
            children.add(getNode(node.x+1,node.y));
        if (node.y-1 >= 0)
            children.add(getNode(node.x,node.y-1));
        if (node.y+1 < length)
            children.add(getNode(node.x,node.y+1));
        return children;
    }

}
