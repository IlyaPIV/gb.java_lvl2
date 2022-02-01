package hw2;

public class MyArraySizeException extends Exception{
    public String myDescription;

    public MyArraySizeException(String message, String myDescription) {
        super(message);
        this.myDescription = myDescription;
    }
}
