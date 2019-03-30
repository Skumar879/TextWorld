import java.util.ArrayList;

public class Player {
    String name;
    String description;
    ArrayList<Item> inventory;
    Graph.Node currentroom;

    public Player(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void addItem(Item add){inventory.add(add);}

    public Item removeItem(String name){
        Item output = new Item("doesn't exist");
        for(int i = 0; i < inventory.size(); i++){if(inventory.get(i).getName() == name) output = inventory.remove(i);}
        return output;
    }

    public boolean destroyItem(String name){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getName() == name){
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getItems(){return inventory;}

    public void displayInventory(){
        if(inventory.size() != 0) {
            System.out.println("Inventory: ");
            for (Item a : inventory) System.out.print(a.getName() + "; ");
        }
    }

    public Graph.Node getCurrentroom() {
        return currentroom;
    }

    public void setCurrentroom(Graph.Node newroom) {
        currentroom = newroom;
    }

}
