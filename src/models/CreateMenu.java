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
        menus.add("|        Write player "+playerNum+" name :       |");
        menus.add("|                                    |");
        menus.add("[------------------------------------]");
        return menus;
    }

    private static ArrayList<String> MenuPlayerNumColor(String playerNum) {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[------------Choose-a-color----------]");
        menus.add("|        Choose player "+playerNum+" color :     |");
        menus.add("|                                    |");
        menus.add("|             1: Yellow              |");
        menus.add("|             2: Blue                |");
        menus.add("|             3: Black               |");
        menus.add("|             4: Purple              |");
        menus.add("|             5: Cyan                |");
        menus.add("|             6: Green               |");
        menus.add("|             7: White               |");
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
        Player p = new Player();
        for (String s : MenuPlayerNumName("1")) {
            System.out.println(s);
        }
        m.setNamePlayer(scan.nextLine());

        for (String s : MenuPlayerNumColor("1")) {
            System.out.println(s);
        }
        p.setColor(scan.nextLine());

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
        Player p = new Player();
        for (String s : MenuPlayerNumName("1")) {
            System.out.println(s);
        }
        m.setNamePlayer(scan.nextLine());
        for (String s : MenuPlayerNumName("2")) {
            System.out.println(s);
        }
        for (String s : MenuPlayerNumColor("1")) {
            System.out.println(s);
        }
        p.setColor(scan.nextLine());
        for (String s : MenuPlayerNumColor("2")) {
            System.out.println(s);
        }
        p.setColor2(scan.nextLine());
    }
    
    public static void LaunchTOP10() throws ParseException {
        Menu m = new Menu();
        do {
            ArrayList<String> menus = new ArrayList<>();
            menus.add("[--------------- MENU ---------------]");
            menus.add("|                                    |");
            menus.add("|            1: 3 Player             |");
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
}
