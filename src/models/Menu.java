package models;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    private static Scanner scan = new Scanner(System.in);
    private static String window = "Home";
    public static String playerName;
    public static String AI;

    public static void Fullmenu() {
        
        while (true) {
            if (window == "Home") {
                clearTerminal();
                showMenu();
            } else if (window == "AI"){
                clearTerminal();
                showSubMainAI();
            } else if (window == "Solo") {
                clearTerminal();
                showSubMainSolo();
            } else if (window == "Multiplayer") {
                clearTerminal();
            } else if (window == "Top10") {
                clearTerminal();
            } else {
                return;
            }

            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    clearTerminal();
                    window = "AI";
                    break;
                case "2":
                    clearTerminal();
                    break;
                case "3":
                    clearTerminal();
                    break;
                case "a":
                    scan.close();
                    clearTerminal();

                    return;
                default:
                    System.out.println("Are you sure your answer is correct ?");
                    break;
            }
            showMenu();
        }
    }

    private static void showMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|            1: 1 Player             |");
        menus.add("|            2: 2 Players            |");
        menus.add("|            3: TOP 10               |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }
    
    private static void showAIdifficulty() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|             1: Easy                |");
        menus.add("|             2: Standard            |");
        menus.add("|             3: Hard                |");
        menus.add("|             4: Hell                |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }

    private static void showSubMainAI() {
        while (window == "AI") {
            clearTerminal();
            showAIdifficulty();

            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    AI = "Easy";
                    clearTerminal();
                    window = "Solo";
                    break;
                case "2":
                    AI = "Standard";
                    clearTerminal();
                    window = "Solo";
                    break;
                case "3":
                    AI = "Hard";
                    clearTerminal();
                    window = "Solo";
                    break;
                case "4":
                    AI = "Hell";
                    clearTerminal();
                    window = "Solo";
                    break;
                case "a":
                    clearTerminal();
                    window = "Home";
                    break;
                default:
                    System.out.println("Are you sure your answer is correct ?");
                    break;
            }
            if (window == "Home") {
                showMenu();
            } else if (window == "Solo") {
                showSubMainSolo();
            } else {
                showAIdifficulty();
            }
        }
    }

    private static void SubMainSolo() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|          Write your name :         |");
        menus.add("|                                    |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }

    private static void showSubMainSolo() {
        boolean inputName = true;
        while (window == "Solo") {
            clearTerminal();
            SubMainSolo();

            while(inputName == true) {
                playerName = scan.nextLine();
                int count = 0;
                for(int i = 0; i < playerName.length(); i++) {    
                    if(playerName.charAt(i) != ' ')    
                    count++;    
                } 
                if (count == 0) {
                    System.out.println("Give a correct player name !");
                } else if (count >= 1 ) {
                    inputName = false;
                    window = "Game";
                }
            }
        }
    }
    private static String OS = System.getProperty("os.name");

    private static void clearTerminal() {
        //Terminal clear command
        final String ANSI_CLS = "\u001b[2J";
        //Terminal delete void space return home position command terminal
        final String ANSI_HOME = "\u001b[H";
        //Execute commands
        if (OS.startsWith("Linux")) {
            //Linux
            System.out.print(ANSI_CLS + ANSI_HOME);
        } else if (OS.startsWith("Windows")) {
            //Windows
            System.out.print("\033[2J\033[1;1H");
    }
        //Avoir losing data :
        System.out.flush();
    }
}
