import hw1.Interfaces.CanJump;

public class Wall {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean tryToJump(Object o){
        return height<=((CanJump) o).getMaxHeight();
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height + " sm." +
                '}';
    }
}
