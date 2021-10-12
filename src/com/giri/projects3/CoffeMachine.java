package com.giri.projects3;

import java.util.Scanner;

public class CoffeMachine {
    static int water = 400;
    static int milk  = 540;
    static int coffee = 120;
    static int cup = 9;
    static int price = 550;
    static String action ="";
    static boolean print = false;
    static int count = 0;
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        if(!print) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            process(action);
        }
    }


    private static void process(String action) {
        Scanner scanner1 = new Scanner(System.in);
        switch (action) {
            case "buy":
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String n = scanner1.nextLine();
                buy(n);
                break;

            case "fill":
                System.out.println();
                System.out.println("Write how many ml of water you want to add: ");
                water +=scanner1.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                milk += scanner1.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                coffee += scanner1.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                cup += scanner1.nextInt();
                System.out.println();
                start();
                break;

            case "take":
                System.out.println();
                int takemoney = price;
                System.out.print("I gave you $"+takemoney);
                price -= takemoney;
                System.out.println();
                System.out.println();
                start();
                //state();
                break;

            case "remaining":
                System.out.println();
                state();
                System.out.println();
                start();
                break;
            case "exit":
                print = true;

        }
    }

    private static void buy(String n) {
        switch (n) {
            case "1":
                if(water >= 250 ) {
                    checkCondition(n);
                } else {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    start();
                }
                break;
            case "2":
                if(water >= 350 ) {
                    checkCondition(n);
                } else {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    start();
                }
                break;

            case "3":
                if(water >=  200 ) {
                    checkCondition(n);
                } else {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                    start();
                }
                break;
            case "back":
                start();
                break;
        }
    }

    private static void checkCondition(String n) {
        switch (n) {
            case "1":
                water = water - 250;
                coffee = coffee - 16;
                price = price + 4;
                cup = cup - 1;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();
                start();
                break;
            case "2":
                water = water - 350;
                milk = milk - 75;
                coffee = coffee - 20;
                price = price + 7;
                cup = cup - 1;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();
                start();
                break;
            case "3" :
                water = water - 200;
                milk = milk - 100;
                coffee = coffee - 12;
                price = price + 6;
                cup = cup - 1;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();
                start();
                break;
        }

    }

    private static void state() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee+" g of coffee beans");
        System.out.println(cup+" disposable cups");
        System.out.println("$"+price+" of money");
    }
}

