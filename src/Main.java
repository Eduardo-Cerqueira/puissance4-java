import java.util.ArrayList;
import java.util.Scanner;

import models.CreateMenu;

public class Main {
    // Scanner init
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        afficherMenu();
        
        while (true) {
            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    CreateMenu.LaunchSingleplayer();
                    break;
                case "2":
                    CreateMenu.LaunchMultiplayer();
                    break;
                case "3":
                    break;
                case "a":
                    scan.close();
                    return;
                default:
                    System.out.println("Are you sure your answer is correct ?");
                    break;
            }
            //afficherMenuTxt("menu.txt");
            afficherMenu();
        }
    }

    public static void afficherMenu() {
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
}