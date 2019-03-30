import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
//        Graph.Node current = g.getNode("hall");

        Player a = new Player("Bob", "pretty boring guy");
        a.setCurrentroom(g.getNode("hall"));


        String response = "";
        Scanner s = new Scanner(System.in);
        do{
            //display the room and the exits
            System.out.println("You are currently in the " + a.getCurrentroom().getName());
            System.out.println("What do you want to do? >");
            System.out.println(a.currentroom.getNeighborNames());
            response = s.nextLine();
            String[] words = response.split(" ");

            if (words[0].equals("go")){
                if(words.length > 1) {
                    Graph.Node neighbor = a.getCurrentroom().getNeighbor(restofWords(words));
                    if (neighbor.getName().equals("doesn't exist"))
                        System.out.println(restofWords(words) + " " + neighbor.getName());
                    else {
                        a.setCurrentroom(neighbor);
                        System.out.println("Player moves to the " + a.getCurrentroom().getName());
                    }
                }
            } else if (words[0].equals("look")){
                if(!a.getCurrentroom().displayItems().equals("")) System.out.println(a.getCurrentroom().displayItems());
                else{ System.out.println("Item does not contain any items.");}
            } else if (words[0].equals("add")) {
                String roomname = "";
                for(int i = 1; i < words.length; i++){
                    roomname += words[i] + " ";
                }
            } else if (words[0].equals("quit")){
                System.out.println("Goodbye.");
            } else if (words[0].equals("take")){
                if(words.length > 1){
                    Item temp = a.getCurrentroom().removeItem(restofWords(words));
                    if(temp.getName().equals("doesn't exist")) System.out.println("Room does not contain " + temp.getName());
                    else {
                        System.out.println(temp.getName() + " was taken from the " + a.getCurrentroom().getName());
                        a.addItem(temp);
                    }
                } else {System.out.println("Item name not specified");}
            } else if(words[0].equals("drop")){
                if(words.length > 1){
                    Item temp = a.removeItem(restofWords(words));
                    if(temp.getName().equals("doesn't exist")) System.out.println("Item " + temp.getName());
                    else {
                        System.out.println(temp.getName() + " was dropped in the " + a.getCurrentroom().getName());
                        a.getCurrentroom().addItem(temp);
                    }
                } else {System.out.println("Item name not specified");}
            } else{
                System.out.println("Please enter a valid command.");
            }

        } while (!response.equals("quit"));

//        //Build up a graph of connected nodes
//        Node root = new Node("hall");
//
//        root.addNeighbor(new Node ("closet"));
//        root.addNeighbor(new Node ("bedroom"));
//
//        root.getNeighbor("closet").addNeighbor(new Node("hall"));
//
//        //"game loop"  where I get user input and move the player.
//
//        Node currentRoom = root;
//
//        String response = "";
//        Scanner in = new Scanner(System.in);
//
//        do{
//            //display the room and the exits
//            System.out.println("You are currently in the " + currentRoom.getName());
//            System.out.println("You can go to the: " + currentRoom.getNeighborNames());
//
//            //ask player what they want to do
//            System.out.print("Type the name of the room you want to go to: ");
//            response = in.nextLine();
//
//            //do that
//            Node nextRoom = currentRoom.getNeighbor(response);
//            if(nextRoom == null) {
//                System.out.println("You can't go to " + response + " try again");
//            } else{
//                currentRoom = nextRoom;
//            }
//
//        } while (!response.equals("quit"));
    }

    private static String restofWords(String[] words) {
        String output = "";
        for (int i = 1; i < words.length; i++) {
            if(i != words.length - 1) output += words[i] + " ";
            else output += words[i];
        }
        return output;
    }
}
