package hw3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String,String> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void showBook() {
        System.out.println(phonebook);
    }

    public void addPhonenubmer(String number, String secondName){
        phonebook.put(number,secondName);
    }

    public String whosThisNumber(String number){
        return phonebook.getOrDefault(number," unknown number");
    }

    public Set<String> getPhonenumbers(String secondName){
        Set<String> numbers = new HashSet<>();
        phonebook.forEach((k,v)->{
            if (v.equals(secondName)) numbers.add(k);
        });
        return numbers;
    }
}
