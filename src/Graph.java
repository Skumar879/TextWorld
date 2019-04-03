import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
//    private ArrayList<Node> nodes;
    private HashMap<String, Node> nodes;


    public Graph(){
//      nodes = new ArrayList<>();
        nodes = new HashMap<>();
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
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
        return nodes.get(name);
    }

    public class Node{
        private String name;
//        private ArrayList<Node> neighbors;
        private HashMap<String, Node> neighbors;
        private ArrayList<Item> items;

        private Node(String name){
//            neighbors = new ArrayList<Node>();
            neighbors = new HashMap<>();
            this.name = name;
        }

        private void addNeighbor(Node n){
            neighbors.put(n.getName(), n);
        }

        /**
         * Returns a String of the names of all the neighbors of this node
         * @return
         */
        public String getNeighborNames(){
            if(neighbors.size() == 0) return "No Neighbors";
            String output = "";
            for(String a : neighbors.keySet()) output += a + "; " ;
            return output;
        }

        /**
         * Return neighbor whose name is name. Returns null otherwise.
         * @param name name of neighboring node to return
         * @return returns neighboring node with correct name
         */
        public Node getNeighbor(String name){
            if (neighbors.get(name) == null) return new Node("doesn't exist");
            return neighbors.get(name);
        }

        public String getName(){
            return name;
        }

        public String displayItems(){
            String output = "";
            if(items.size() != 0) {
                output += "Items in room: ";
                for (Item a : items) output += a.getName() + "; ";
            }
            return output;
        }

        public void addItem(Item add){items.add(add);}

        public void addItem(String name){
            items.add(new Item(name));
        }

        public void addItem(String name, String description){
            Item temp = new Item(name);
            temp.setDescription(description);
            items.add(temp);
        }

        public Item removeItem(String name){
            Item output = new Item("doesn't exist");
            for(int i = 0; i < items.size(); i++){if(items.get(i).getName() == name) output = items.remove(i);}
            return output;
        }

        public boolean destroyItem(String name){
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).getName() == name){
                    items.remove(i);
                    return true;
                }
            }
            return false;
        }

        public Node getRandomNeighbor(){
            ArrayList<Node> helpmysoul = new ArrayList<>(neighbors.values());
            Node random = helpmysoul.get((int)(helpmysoul.size() * Math.random()));
            return random;
        }

        public HashMap<String, Node> getNeighborArray(){
            return neighbors;
        }
    }
}
