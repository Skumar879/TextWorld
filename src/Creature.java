public abstract class Creature {
    protected Room currentroom;
    protected String name;
    protected String description;

    public abstract void move();

    public abstract void act();

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrentroom() {
        return currentroom;
    }

    public void setCurrentroom(Room currentroom) {
        this.currentroom = currentroom;
    }
}
