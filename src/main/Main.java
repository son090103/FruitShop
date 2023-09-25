package main;


import controller.ManagerFruitShop;
import view.Menu;

public class Main {
     public static void main(String[] args) {
        String title= "FRUIT SHOP SYSTEM";
        String[] s= new String[] {"Create Fruit", "View order", "Shopping(for buyer)", "Exit"};
        Menu<String> menu= new ManagerFruitShop(title, s);
        menu.run();
    }   
}
