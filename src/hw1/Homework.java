package hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homework {
    public static void main(String[] args) {
        makeTest(10, 5);
    }

    private static void makeTest(int countSportsmans, int countObstacles){
        List<Object> sportsmen = generateSportsmans(countSportsmans);
        System.out.println("Our sportsmen are:");
        System.out.println(sportsmen.toString());
        List<Object> obstacles = generateObstacles(countObstacles);
        System.out.println("They should pass:");
        System.out.println(obstacles.toString());

        System.out.println();
        System.out.println(3);
        System.out.println(2);
        System.out.println(1);
        System.out.println("START!!!");
        System.out.println();

        for (Object member:
             sportsmen) {
            System.out.println(member.toString() + " is on start lane.");
            int count = 0;
            for (Object obst:
                 obstacles) {
                if (!makeAttempt(member, obst)) {
                    System.out.println("LOOOOOSER! Couldn't pass "+obst.toString());
                    break;
                } else {
                    System.out.println("Successfully passed "+obst.toString());
                    count++;
                }
            }
            if (count==obstacles.size()) System.out.println("All is passed!!! CONGRATULATIONS!!!");
        }
        System.out.println();
        System.out.println("FINISH!!!");

    }

    private static List<Object> generateSportsmans(int count){
        List<Object> team = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            team.add(generateMember(rnd.nextInt(3), rnd.nextInt(200), rnd.nextInt(200)));
        }

        return team;
    }

    private static Object generateMember(int type, int height, int length){

        switch (type){
            case 0: return new Human("hw1.Human",height,length);
            case 1: return new Robot("hw1.Robot", height, length);
            case 2: return new Cat("hw1.Cat", height, length);
            default: return null;
        }
    }

    private static List<Object> generateObstacles(int count){
        List<Object> obstacles = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < count; i++) {
            if (rnd.nextBoolean()) obstacles.add(new Track(50+rnd.nextInt(120)));
                else obstacles.add(new Wall(10+rnd.nextInt(150)));
        }

        return obstacles;
    }

    private static boolean makeAttempt(Object member, Object obst) {
        if (obst instanceof Track) {
            ((CanRun) member).tryToRun();
            return ((Track) obst).tryToRun(member);
        } else {
            ((CanJump) member).tryToJump();
            return ((Wall) obst).tryToJump(member);
        }
    }
}
