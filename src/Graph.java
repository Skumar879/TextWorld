import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph(){
        nodes = new ArrayList<>();
    }

    public void addNode(String name) {
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = /*get Node for name 1*/;
        Node n2 = /*get Node for name 2*/;
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
    }

    public Node getNode(String name) {
    }

    public class Node{
        private String name;
        private ArrayList<Node> neighbors;

        private Node(String name){
            neighbors = new ArrayList<Node>();
            this.name = name;
        }

        private void addNeighbor(Node n){
            //add this node as a neighbor
        }

        /**
         * Returns a String of the names of all the neighbors of this node
         * @return
         */
        public String getNeighborNames(){
            return " ";
        }

        /**
         * Return neighbor whose name is name. Returns null otherwise.
         * @param name name of neighboring node to return
         * @return returns neighboring node with correct name
         */
        public Node getNeighbor(String name){
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
