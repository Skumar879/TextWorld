public class Chicken extends Creature{

    public Chicken(Room startingroom){
        setCurrentroom(startingroom);
    }


    public void act() {
        int randomRoom = (int)(Math.random()*currentroom.getNeighborArray().size());
        setCurrentroom(currentroom.getRandomNeighbor());
    }

}
