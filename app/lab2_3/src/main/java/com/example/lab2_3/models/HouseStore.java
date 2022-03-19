package com.example.lab2_3.models;

import java.util.ArrayList;

public class HouseStore {
    private static ArrayList<House> houses;

    static {
        houses = new ArrayList<>();

        houses.add(new House("1", "42a", 233, 2, 3, "Lenina", "Dacha", 1));
        houses.add(new House("2", "11", 45, 9, 4, "Samataka", "Apartment", 2));
        houses.add(new House("3", "3b", 343, 6, 1, "Sobaka", "Apartment", 1));
        houses.add(new House("4", "5", 87, 11, 3, "Kittikova", "Apartment", 3));
        houses.add(new House("5", "16", 91, 1, 5, "Jukova", "Apartment", 1));
        houses.add(new House("6", "71", 54, 2, 4, "AliExpress", "Apartment", 3));
        houses.add(new House("7", "4a", 34, 6, 2, "PonyExpress", "Dacha", 2));
        houses.add(new House("8", "34", 23, 7, 1, "GloriaJeans", "Dacha", 1));
        houses.add(new House("9", "1", 12, 4, 5, "Success", "Dacha", 3));
        houses.add(new House("0", "9", 78, 13, 2, "OneTheWay", "Dacha", 1));
    }

    public ArrayList<House> getHouse(){
        return houses;
    }

    public House get(int position){
        return houses.get(position);
    }

    public void remove(int position){
        houses.remove(position);
    }

    public void add(House book){
        houses.add(book);
    }

    public void replace(int position, House book){
        houses.remove(position);
        houses.add(book);
    }
}
