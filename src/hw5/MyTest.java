package hw5;

public class MyTest {

    private static final int size = 10_000_000;
    private static final int halfSize = size / 2;
    private static float[] array;


    public static void main(String[] args) {
        initArray();
        firstMethod();
        initArray();
        try {
            secondMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void initArray(){
        array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
    }

    public static void firstMethod(){
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0) );
        }
        System.out.println("Время одиночного выполнения: "+(System.currentTimeMillis()-startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException{
        long startTime = System.currentTimeMillis();



        Thread tr1 = new Thread(()->{
            long startTime1 = System.currentTimeMillis();
            for (int i = 0; i < halfSize; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0) );
            }
            System.out.println("Время выполнения 1ого потока : "+(System.currentTimeMillis()-startTime1) + " ms.");
        });

        Thread tr2 = new Thread(()->{
            long startTime2 = System.currentTimeMillis();
            for (int i = halfSize; i < size; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0) );
            }
            System.out.println("Время выполнения 2ого потока : "+(System.currentTimeMillis()-startTime2) + " ms.");
        });

        tr1.start();
        tr2.start();
        tr1.join();
        tr2.join();

        System.out.println("Время параллельного выполнения: "+(System.currentTimeMillis()-startTime) + " ms.");
    }
}
