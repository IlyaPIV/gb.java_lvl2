package hw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static String[][] mass = new String[4][4];

    public static void main(String[] args) {
        try {
            testTaskOne();
            testTaskTwo();
        } catch (MyArraySizeException e){
            System.out.println(e.myDescription);
            System.out.println(e.getClass());
        } catch (MyArrayDataException e){
            System.out.println(e.myDescription);
            System.out.println(e.getClass());
        }
    }

    public static void testTaskOne() throws MyArraySizeException{
        try {
            initMassive(false);
            //initMassive(true);
        } catch (MyArraySizeException e) {
            throw e;
        }
    }

    public static void initMassive(boolean exception) throws MyArraySizeException{
        try {
            if (exception) {
                mass[0] = new String[]{"12", "17", "-5","0"};
                mass[1] = new String[]{"5", "1","-20","-3", "50"};
                mass[2] = new String[]{"-5","-3","3","5"};
                mass[3] = new String[]{"15", "17", "19", "-50", "0"};
                mass[4] = new String[]{"0", "0","0"};
            } else
            {
                mass[0] = new String[]{"12", "17", "-5","0"};
                mass[1] = new String[]{"5", "1","-20","-3"};
                mass[2] = new String[]{"-5","-3","3","5"};
                mass[3] = new String[]{"15", "17", "19", "-50"};
            }

        } catch (Exception e) {
//            System.out.println("произошла неведомая фигня");
            throw new MyArraySizeException(e.getMessage(), "ошибка размера массива в testTaskOne() [original: "
                    +e.getClass()+"]");
        }

    }

    public static void testTaskTwo() throws MyArrayDataException{
        int summ = 0;

        //делаем косяк в данных
  //      mass[0][3] = "lol";

        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    summ+=Integer.parseInt(mass[i][j]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new MyArrayDataException(e.getMessage(), "Ошибка данных в testTaskTwo() [original: "
                    +e.getClass()+"]");
        }
        System.out.println("Сумма всех элементов массива: " + summ);
    }
}
