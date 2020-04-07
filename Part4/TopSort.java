import java.util.*;

public class TopSort {
    public TopSort(){};

    public static ArrayList<Node> Khans(final DirectedGraph graph){
        ArrayList<Node> out = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> degrees = graph.getIndegrees();
        addZeroIndegree(queue, degrees);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            out.add(curr);
            decrementChildrenDegree(curr, degrees);
            addZeroIndegreeChildren(queue, curr, degrees);
        }
        return out;
    }

    public static ArrayList<Node> mDFS(final DirectedGraph graph){
        ArrayList<Node> order = new ArrayList<>();

        HashSet<Node> visited = new HashSet<>();
        for (Node n : graph.getAllNodes()){
            DFSRec(n, visited,order);
        }
        Collections.reverse(order);
        return order;
    }
    private static void DFSRec(final Node node, HashSet<Node> visited, ArrayList<Node> order){
        visited.add(node);
        for(Node child : node.children){
            if (!visited.contains(child))
                DFSRec(child,visited,order);
        }
        if (!order.contains(node))
            order.add(node);
    }

    /**
     * Adds all nodes who's indegree is 0 to a queue
     * @param q the queue to add to
     * @param degrees the list of nodes to inspect
     */
    private static void addZeroIndegree(Queue<Node> q, HashMap<Node,Integer> degrees){
        for (Node node: degrees.keySet()){
            if (degrees.get(node) == 0){
                q.add(node);
            }
        }
    }

    private static void addZeroIndegreeChildren(Queue<Node> q, Node node, HashMap<Node,Integer> degrees){
        for (Node n: node.children){
            if (degrees.get(n) == 0){
                q.add(n);
            }
        }
    }

    /**
     * Decrements the indegree of all the children nodes
     * @param node the node to decrement the children of
     */
    private static void decrementChildrenDegree(Node node, HashMap<Node, Integer> degrees){
        for (Node child : node.children){
            degrees.put(child, degrees.get(child)-1);
        }
    }
}
