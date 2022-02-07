package hw1;

import hw1.CanJump;
import hw1.CanRun;

public class Robot implements CanRun, CanJump {

    private String name;
    private int maxHeight;
    private int maxLength;

    private static int value;

    public Robot(String name) {
        this.name = name+"_"+value;
        value++;
    }

    public Robot(String name, int height, int length) {
        this.name = name+"_"+value;
        this.maxHeight = height;
        this.maxLength = length;
        value++;
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
    public void tryToJump() {
        System.out.println("hw1.Robot { "+name+" } is trying to jump.");
    }

    @Override
    public void tryToRun() {
        System.out.println("hw1.Robot { "+name+" } is trying to run.");
    }

    @Override
    public String toString() {
        return "hw1.Robot{" +
                "name='" + name + '\'' +
                ", maxLength=" + maxLength + " m." +
                ", maxHeight=" + maxHeight + " sm." +
                '}';
    }
}
