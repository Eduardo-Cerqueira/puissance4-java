package models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateMenu {
    private static Scanner scan = new Scanner(System.in);

    private static ArrayList<String> Home() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|            1: 1 Player             |");
        menus.add("|            2: 2 Players            |");
        menus.add("|            3: TOP 10               |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        return menus;
    }

    private static ArrayList<String> MenuPlayerNumName(String playerNum) {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|     Write player "+playerNum+" name :          |");
        menus.add("|                                    |");
        menus.add("[------------------------------------]");
        return menus;
    }

    private static ArrayList<String> MenuPlayerName() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|          Write your name :         |");
        menus.add("|                                    |");
        menus.add("[------------------------------------]");
        return menus;
    }

    public static void LaunchHome() throws ParseException {
        Menu m = new Menu();

        do {
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
            m.setGamemode(scan.nextLine());
            break; 
        } while (true);
    }

    public static void LaunchSingleplayer() throws ParseException {
        Menu m = new Menu();
        for (String s : MenuPlayerName()) {
            System.out.println(s);
        }
        m.setNamePlayer(scan.nextLine());

        do {
            ArrayList<String> menus = new ArrayList<>();
            menus.add("[---------Choose-a-difficulty--------]");
            menus.add("|                                    |");
            menus.add("|             1: Easy                |");
            menus.add("|             2: Standard            |");
            menus.add("|             3: Hard                |");
            menus.add("|             4: Hell                |");
            menus.add("|                                    |");
            menus.add("[------------------------------------]");
            for (String s : menus) {
                System.out.println(s);
            }
            m.setDifficultyAI(scan.nextLine());
            break;
        } while (true);
    }

    public static void LaunchMultiplayer() throws ParseException {
        Menu m = new Menu();
        for (String s : MenuPlayerNumName("1")) {
            System.out.println(s);
        }
        m.setNamePlayer(scan.nextLine());
        for (String s : MenuPlayerNumName("2")) {
            System.out.println(s);
        }
        m.setNamePlayer2(scan.nextLine());
    }
}
