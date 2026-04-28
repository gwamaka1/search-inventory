package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class SearchInventory {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
       Collections.sort(inventory, Comparator.comparing(Product::getName));
       listInventory(inventory);




    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        String fileName = "inventory.csv";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = bf.readLine()) != null){
                String [] parts = line.split("\\|");
                 int id= Integer.parseInt(parts[0]);
                 String name = parts[1];
                 double price = Double.parseDouble(parts[2]);

                 inventory.add(new Product(id,name,price));





            }
            bf.close();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inventory;

    }
    public static void listInventory(ArrayList<Product> inventory){
        for (Product  p:inventory){
            System.out.println(p);

        }

    }
}
