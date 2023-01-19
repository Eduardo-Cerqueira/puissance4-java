package models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Scanner scan = new Scanner(System.in);

    public static void displayMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("|            1: 2 Player             |");
        menus.add("|            2: 1 Players (AI)       |");
        menus.add("|            3: TOP 10               |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }


    public static void MenuStart(){
        displayMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("-------- joueur 1 - indiquer vos informations --------");
                    Player joueur1 = CreatePlayer();
                    System.out.println("-------- joueur 2 - indiquer vos informations --------");
                    Player joueur2 = CreatePlayer();
                    LaunchMultiplayerGame(joueur1, joueur2);
                    break;
                case "2":
                    //CreatePlayer();
                    //LauchSoloGame();
                    MenuIA();
                    break;
                case "3":
                    ScoreSerializer.sortByScore();
                    break;
                case "a":
                    scan.close();
                    return;
                default:
                    System.out.println("Selection érroné");
                    break;
            }
            displayMenu();
        }
    }


    private static Player CreatePlayer() {

        Player player = new Player();
        System.out.println("Saisir le pseudo:");
        player.setPseudo(scan.nextLine());

        do {
            try {
                System.out.println("Saisir le Symbole: (X/O)");
                player.setShape(scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


        do {
            try {
                System.out.println("Saisir la couleur: (red/yellow)");
                player.setColor(scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return player;
    }


    private static void LaunchMultiplayerGame(Player joueur1, Player joueur2)
    {
        Game multiGame = new Game(joueur1, joueur2);
        multiGame.InitialiseMatrix();
        multiGame.print2dArray();

        while (multiGame.CheckForFullBoard() == false)
        {
            System.out.println("Saisisser le numéro de la colonne pour votre jeton:");
            //recupération de la saisie utilisateur avec Scanner et conversion du string récupéré en Int avec Integer

            // try {
            //     multiGame.addElement(  Integer.parseInt(scan.nextLine())          ) ;
            // }
            // catch (NumberFormatException ex){
            //     ex.printStackTrace();
            // }

            do {
                try {
                    multiGame.addElement(  Integer.parseInt(scan.nextLine())       ) ;
                    break;
                } catch (ParseException e) {
                    System.out.println("saisie incorrect");
                }catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (true);



            System.out.println("--------------- Changement de joueur ! ---------------");
            multiGame.ChangePlayer();
        }
    }


    private static void displayIALevelSelectionMenu()
    {
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
    }


    public static void MenuIA(){
        displayIALevelSelectionMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    lauchGameWithIA(1);
                    break;
                case "2":
                    lauchGameWithIA(2);
                    break;
                case "3":
                    lauchGameWithIA(3);
                    break;
                case "4":
                    lauchGameWithIA(4);
                    break;
                default:
                    System.out.println("Boulet!!!!");
                    break;
            }
            displayIALevelSelectionMenu();
        }
    }


    private static void lauchGameWithIA(int difficulty)
    {

    }














    //test
    public static void LauchSoloGame()
    {
        Player J1 = new Player();
        Player J2 = new Player();

        J1.setPseudo("tartuffe");
        try {
            J1.setShape("x");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        J1.setPseudo("tartuffe");
        try {
            J1.setShape("x");
        } catch (ParseException e) {
            e.printStackTrace();
        }



        Game puissance4 = new Game(J1, J2);
        puissance4.InitialiseMatrix();
        puissance4.print2dArray();



        while (puissance4.isBoardFull() == false)
        {
            System.out.println("Saisisser le numéro de la colonne pour votre jeton:");
            //recupération de la saisie utilisateur avec Scanner et conversion du string récupéré en Int avec Integer

            try {
                //puissance4.addElement(  Integer.parseInt(scan.nextLine())          ) ;
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }

            System.out.println("--------------- Changement de joueur ! ---------------");
            puissance4.ChangePlayer();
        }
        //if (puissance4.checkForVictory == true)
        //    { }
        //else
        //{System.out.println("partie nul");}

    }



}