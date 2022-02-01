package hw1;

import hw1.CanRun;

public class Track {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public boolean tryToRun(Object o){
        return length<=((CanRun) o).getMaxLength();
    }

    @Override
    public String toString() {
        return "hw1.Track{" +
                "length=" + length + " m." +
                '}';
    }
}
