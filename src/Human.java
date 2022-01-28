import hw1.Interfaces.*;

public class Human implements CanJump, CanRun {

    private String name;
    private int maxHeight;
    private int maxLength;

    private static int value;

    public Human(String name) {
        this.name = name+"_"+value;
        value++;
    }

    public Human(String name, int height, int length) {
        this.name = name+"_"+value;
        this.maxHeight = height;
        this.maxLength = length;
        value++;
    }

    @Override
    public void tryToJump() {
        System.out.println("Cat { "+name+" } is trying to jump.");
    }

    @Override
    public void tryToRun() {
        System.out.println("Human { "+name+" } is trying to run.");
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                "maxLength='" + maxLength + " m." +
                "maxHeight='" + maxHeight + " sm." +
                '}';
    }
}
