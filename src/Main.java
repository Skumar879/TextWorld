import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Level g = new Level();
        g.addNode("Hall");
        g.addNode("Closet");
        g.addNode("Dungeon");

        g.addUndirectedEdge("Hall", "Dungeon");
        g.addUndirectedEdge("Hall", "Closet");
        g.addUndirectedEdge("Closet", "Dungeon");
//        Graph.Node current = g.getNode("hall");
        Chicken c = new Chicken(g.getNode("Closet"));
        Player a = new Player("Bob", "pretty boring guy");
        a.setCurrentroom(g.getNode("Hall"));


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
                    Room neighbor = a.getCurrentroom().getNeighbor(restofWords(words));
                    if (neighbor.getName().equals("doesn't exist"))
                        System.out.println(restofWords(words) + " " + neighbor.getName());
                    else {
                        a.setCurrentroom(neighbor);
                        System.out.println("Player moves to the " + a.getCurrentroom().getName());
                    }
                }
            } else if (words[0].equals("look")){
                if(!a.getCurrentroom().displayItems().equals("")) System.out.println(a.getCurrentroom().displayItems());
                else{ System.out.println(a.getCurrentroom().getName() + " does not contain any items.");}
                System.out.println("Chicken is in " + c.getCurrentroom().getName());
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
        c.act();
        } while (!response.equals("quit"));

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
