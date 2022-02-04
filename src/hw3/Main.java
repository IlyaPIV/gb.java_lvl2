package hw3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        taskOne();
        System.out.println();
        taskTwo();
    }

    public static void taskOne(){
        List<String> list = new ArrayList<>();
        initList(list);
        Map<String, Integer> map = new HashMap<>();
        calculateWords(list, map);
        showResults(map);
    }

    public static void initList(List<String> myList){
        myList.add("Вася");
        myList.add("Петя");
        myList.add("Карбюратор");
        myList.add("Петя");
        myList.add("Коля");
        myList.add("Забор");
        myList.add("Арбуз");
        myList.add("Сок");
        myList.add("Петя");
        myList.add("Шпиндель");
        myList.add("Сок");
        myList.add("Галя");
        myList.add("Галя");
        myList.add("Петя");
        myList.add("Яблоко");
        myList.add("Груша");
        myList.add("Арбуз");
    }

    public static void calculateWords(List<String> list, Map<String,Integer> map){
        for (String word:
             list) {
            int value = map.getOrDefault(word,0);
            map.put(word, value+1);
        }
    }

    public static void showResults(Map<String, Integer> map){
        Set<String> set = new HashSet<>();

        System.out.println("Вхождение слов:");
        map.forEach((k,v)->{
            if (v==1) set.add(k);
            System.out.println(k+" = "+v);
        });

        System.out.println("Уникальные слова:");
        System.out.println(set);

    }

    public static void taskTwo(){
        PhoneBook pb = new PhoneBook();
        pb.addPhonenubmer("375-29-9876543","Пупкин");
        pb.addPhonenubmer("375-29-8765432","Васечкин");
        pb.addPhonenubmer("375-29-7654321","Васечкин");
        pb.addPhonenubmer("375-29-6543210","Иванов");
        pb.addPhonenubmer("375-33-9876543","Пупкин");
        pb.addPhonenubmer("375-33-8765432","Сидоров");
        pb.addPhonenubmer("375-44-8765432","Лошков");

        System.out.println("Телефонные номера Васечника:"+pb.getPhonenumbers("Васечкин"));
        System.out.println("Телефонные номера Пупкина:"+pb.getPhonenumbers("Пупкин"));

        System.out.println("Телефонный номер принадлежит: "+pb.whosThisNumber("375-29-6543210"));
        System.out.println("Телефонный номер принадлежит: "+pb.whosThisNumber("375-44-6543210"));
    }

}
