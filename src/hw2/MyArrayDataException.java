package hw2;

public class MyArrayDataException extends Exception{
    public String myDescription;

    public MyArrayDataException(String message, String myDescription) {
        super(message);
        this.myDescription = myDescription;
    }
}
