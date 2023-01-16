import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        showMenu();
        
        while (true) {
            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    clearTerminal();
                    break;
                case "2":
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

    public static void showMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|            1: 1 Player             |");
        menus.add("|            2: 2 Player             |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
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