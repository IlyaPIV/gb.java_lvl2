import hw1.Interfaces.CanRun;

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
        return "Track{" +
                "length=" + length + " m." +
                '}';
    }
}
