import java.util.*;

public class GraphSearch {
    public Graph graph;
    boolean found;

    public GraphSearch(Graph graph){
        this.graph = graph;
        this.found = false; //Indicated weather a paritiular search yeilded a vaild path and the destination node is found
    }

    public ArrayList<Node> DFSRec(final Node start, final Node end){
        ArrayList<Node> order = new ArrayList<>();

        HashSet<Node> visited = new HashSet<>();


        DFSRec(start, end, visited,order);
        if (this.found)
            return order;
        return null;
    }
    private void DFSRec(final Node start, final Node end, HashSet<Node> visited, ArrayList<Node> order){
        if (start == end) {
            order.add(start);
            this.found = true;
            return;
        }
        order.add(start);
        visited.add(start);
        HashSet<Node>  children = graph.getChildren(start);
        for(Node child : children){
            if (!visited.contains(child))
                DFSRec(child,end,visited,order);
        }
    }

    public ArrayList<Node> DFSIter(final Node start, final Node end){
        Stack<Node> s = new Stack<>();
        ArrayList<Node> order = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        this.found = false;

        Node curr;
        s.push(start);
        while (!s.empty()){
            curr = s.pop();
            order.add(curr);
            visited.add(curr);
            if (curr == end){
                this.found = true;
                return order;
            }
            for(Node child : graph.getChildren(curr)){
                if (!visited.contains(child)){
                    visited.add(child);
                    s.add(child);
                }
            }
        }
        return null;
    }

    public ArrayList<Node> BFSRec(Graph graphh){
        Queue<Node> toVisit = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        ArrayList<Node> order = new ArrayList<>();
        this.found = false;
        for (Node node : graphh.getAllNodes()){
            if (!visited.contains(node)){
                toVisit.add(node);
                visited.add(node);
                BFSRec(node,toVisit, visited, order);
            }
        }
        return order;
    }
    private void BFSRec(final Node start, Queue<Node> toVisit, HashSet<Node> visitied, ArrayList<Node> order){
        if (!toVisit.isEmpty()){
            Node curr = toVisit.poll();
            order.add(curr);
            for (Node child : graph.getChildren(curr)){
                if (!visitied.contains(child)){
                    visitied.add(child);
                    toVisit.add(child);
                }
            }
            BFSRec(start,toVisit,visitied,order);
        }
    }
    public ArrayList<Node> BFSIterative(Graph graphh){
        Queue<Node> toVisit = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        ArrayList<Node> order = new ArrayList<>();
        this.found = false;
        for(Node node : graphh.getAllNodes()){
            if (!visited.contains(node)){
                toVisit.add(node);
                visited.add(node);
            }
            while(!toVisit.isEmpty()){
                Node curr = toVisit.poll();

                order.add(curr);
                HashSet<Node> children = graph.getChildren(curr);
                for (Node child : children) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        toVisit.add(child);
                    }
                }

            }
        }
        return order;
    }

}
