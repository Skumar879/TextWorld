public class Chicken extends Creature{

    public Chicken(Room startingroom){
        setCurrentroom(startingroom);
    }

    @Override
    public void move() {
        int randomRoom = (int)(Math.random()*currentroom.getNeighborArray().size());
        setCurrentroom(currentroom.getRandomNeighbor());
    }

    @Override
    public void act() {
        move();
    }
}
