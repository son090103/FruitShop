/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;


public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int check = Integer.parseInt(sc.nextLine().trim());
                if (check < min || check > max) {
                    throw new Exception();
                } else {
                    return check;
                }
            } catch (Exception e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]!");
                System.out.println("Enter again: ");
            }
        }
    }

    public String checkInputString(String mess) {
        System.out.println(mess);
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public int checkInt(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Double checkInputDouble(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public boolean checkInputYesNo() {
        while (true) {
            String result = checkInputString("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen ");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    public boolean checkIdExist(ArrayList<Fruit> list, int id) {
        for (Fruit fruit : list) {
            if (fruit.getId() == id) {
                System.err.println("Id exist in list!");
                return true;
            }
        }
        return false;
    }

}
