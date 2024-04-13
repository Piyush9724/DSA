package LinkedLists;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Fruit {
    String name;
    int id;
    Fruit(String fruit, int id) {
        this.name = fruit;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object fruit) {
        if(this == fruit) return true;
        if(fruit == null || getClass() != fruit.getClass()) return false;
        Fruit fruit1 = (Fruit) fruit;
        if(fruit1.name.equals(this.name)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.id % 6;
    }
}

public class HashDemo {
    public static void main(String[] args) {
        Map<Fruit, String> fruits = new HashMap<>(6, 0.75f);
        fruits.put(new Fruit("apple", 3), "Apple");
        fruits.put(new Fruit("banana", 1), "Banana");
        fruits.put(new Fruit("cherry", 5), "Cherry");
        fruits.put(new Fruit("chiku", 5), "Chiku");
        fruits.put(new Fruit("orange", 4), "Orange");
        fruits.put(new Fruit("angur", 3), "Angur");
        fruits.put(new Fruit("apricot", 3), "Apricot");
        fruits.put(new Fruit("pear", 2), "Pear");


        for(Map.Entry fruit : fruits.entrySet()) {
            System.out.println(fruit.getKey() + "  " + fruit.getValue());
        }



        Map<String, String> countries = new HashMap<>();
        countries.put("United States", "Washington, D.C.");
        countries.put("Canada", "Ottawa");
        countries.put("Brazil", "Brasília");
        countries.put("Russia", "Moscow");
        countries.put("India", "New Delhi");
        countries.put("China", "Beijing");
        countries.put("Australia", "Canberra");
        countries.put("South Africa", "Pretoria");

        Scanner sc = new Scanner(System.in);
        String ipCountry = sc.next();
        if (countries.containsKey(ipCountry)) {
            System.out.printf("Yes the country %s is present and its capital is %s",ipCountry, countries.get(ipCountry));
        }else {
            System.out.printf("No the country %s is not Present", ipCountry);
        }
    }
}
