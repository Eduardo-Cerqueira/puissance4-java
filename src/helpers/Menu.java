package helpers;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    private static Scanner scan = new Scanner(System.in);
    private static boolean isMainMenu = true;

    public static void main(String[] args) {
        
        while (true) {
            if (isMainMenu == true) {
                clearTerminal();
                showMenu();
            } else {
                clearTerminal();
                showSubMainAI();
            }
            showMainMenu();
        }
    }

    public static void showMenu() {
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

    public static void showMainMenu() {
        String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    clearTerminal();
                    isMainMenu = false;
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
    
    public static void showAIdifficulty() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|             1: Easy                |");
        menus.add("|             2: Medium              |");
        menus.add("|             3: Hard                |");
        menus.add("|             4: Hell                |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }

    public static void showSubMainAI() {
        while (isMainMenu == false) {
            clearTerminal();
            showAIdifficulty();

            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    clearTerminal();
                    break;
                case "2":
                    clearTerminal();
                    break;
                case "3":
                    clearTerminal();
                    break;
                case "4":
                    clearTerminal();
                    break;
                case "a":
                    clearTerminal();
                    isMainMenu = true;
                    break;
                default:
                    System.out.println("Are you sure your answer is correct ?");
                    break;
            }
            if (isMainMenu == true) {
                showMenu();
            } else {
                showAIdifficulty();
            }
        }
    }

    public static void clearTerminal() {
        //Terminal clear command
        final String ANSI_CLS = "\u001b[2J";
        //Terminal delete void space return home position command terminal
        final String ANSI_HOME = "\u001b[H";
        //Execute commands
        //Linux
        System.out.print(ANSI_CLS + ANSI_HOME);
        //Windows
        System.out.print("\033[2J\033[1;1H");
        //Avoir losing data :
        System.out.flush();
    }
}
