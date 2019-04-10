import java.util.ArrayList;
import java.util.HashMap;

public class Room {
        private String name;
        //        private ArrayList<Node> neighbors;
        private HashMap<String, Room> neighbors;
        private ArrayList<Item> items;

        public Room(String name){
//            neighbors = new ArrayList<Node>();
            neighbors = new HashMap<>();
            this.name = name;
        }

        public void addNeighbor(Room n){
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
        public Room getNeighbor(String name){
            if (neighbors.get(name) == null) return new Room("doesn't exist");
            return neighbors.get(name);
        }

        public String getName(){
            return name;
        }

        public String displayItems(){
            String output = "";
            if(items != null && items.size() != 0) {
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

        public Room getRandomNeighbor(){
            ArrayList<Room> helpmysoul = new ArrayList<>(neighbors.values());
            Room random = helpmysoul.get((int)(helpmysoul.size() * Math.random()));
            return random;
        }

        public HashMap<String, Room> getNeighborArray(){
            return neighbors;
        }

    }
