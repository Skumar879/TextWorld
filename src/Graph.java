import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph(){
        nodes = new ArrayList<>();
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {
        for(Node a : nodes) if(a.getName().equals(name)) return a;
        return null;
    }

    public class Node{
        private String name;
        private ArrayList<Node> neighbors;

        private Node(String name){
            neighbors = new ArrayList<Node>();
            this.name = name;
        }

        private void addNeighbor(Node n){
            neighbors.add(n);
        }

        /**
         * Returns a String of the names of all the neighbors of this node
         * @return
         */
        public String getNeighborNames(){
            if(neighbors.size() == 0) return "No Neighbors";
            String output = "";
            for(Node a : neighbors) output += ", " + a.getName();
            return output;
        }

        /**
         * Return neighbor whose name is name. Returns null otherwise.
         * @param name name of neighboring node to return
         * @return returns neighboring node with correct name
         */
        public Node getNeighbor(String name){
            for(Node a : nodes) if(a.getName().equals(name)) return a;
            return null;
        }
        public Node getNode(Node j){
            return null;
        }

        public String getName(){
            return name;
        }
    }
}
