package models;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Genere un affichage console d'un écrant d'acceuil pour permettre au joueur de selectionné son mode de jeu
     */
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

    /**
     * Demande a l'utilisateur une saisie console du mode de jeu souhaiter, récupérè cette information, 
     * et lance les fonctions pour démarer le mode selectionné
     */
    public static void MenuStart() {
        displayMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("-------- joueur 1 - indiquer vos informations --------");
                    Player joueur1 = CreatePlayer();
                    System.out.println("-------- joueur 2 - indiquer vos informations --------");
                    System.out.println("Saisir le pseudo:");
                    Player joueur2 = createAdversary(joueur1, scan.nextLine());
                    
                    LaunchMultiplayerGame(joueur1, joueur2);
                    break;
                case "2":
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

    /**
     * Créer une nouvelle instance de joueur et remplie des champs en récupérant des saisie utilisateurs
     * @return la référence sur l'objet player instancié.
     */
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

    /**
     * Crée une instance de joueur dont les champs seront définie en opposition a ceux du player1
     * (l'adversaire n'a pas le choix pour sa création afin d'éviter les doublons et conflicts, à l'exeption du nom)
     * @param joueur1 le premier joueur instancié
     * @param name le nom que devra prendre l'adversaire du joueur1
     * @return la référence sur l'objet player Adversary instancié
     */
    private static Player createAdversary(Player joueur1, String name){
        Player adversary = new Player();
        try {
            if (joueur1.getColor().equalsIgnoreCase("\u001B[31m")) //red
            {
                adversary.setColor("yellow");
            }
            else
            {
                adversary.setColor("red");
            }

            if (joueur1.getShape().equalsIgnoreCase("x"))
            {
                adversary.setShape("o");
            }
            else
            {
                adversary.setShape("x");
            }

            adversary.setPseudo(name);
        }
        catch (Exception e){
            System.out.println("probleme recupération donné pour la construction de l'adversaire");
        }

        return adversary;
    }

    /**
     * Creer une nouvelle instance de Game et tourne en boucle sur les fonctions qui constitue 
     * le déroulement d'une partie Joueur contre Joueur tout en gérant les exeption qui peuvent survenir.
     * @param joueur1
     * @param joueur2
     */
    private static void LaunchMultiplayerGame(Player joueur1, Player joueur2) {
        Game multiGame = new Game(joueur1, joueur2);
        multiGame.InitialiseMatrix();
        multiGame.print2dArray();

        while (multiGame.CheckForFullBoard() == false) {
            System.out.println("Saisisser le numéro de la colonne pour votre jeton:");
            // recupération de la saisie utilisateur avec Scanner et conversion du string
            // récupéré en Int avec Integer
            do {
                try {
                    multiGame.addElement(Integer.parseInt(scan.nextLine()));
                    //augmentation du playCount du joueur pour chaque jeton placé
                    if (multiGame.getPlayerOneTurn())
                    {joueur1.setPlayCount(joueur1.getPlayCount() + 1);} 
                    else
                    {joueur2.setPlayCount(joueur2.getPlayCount() + 1);}
                    break;
                } catch (ParseException e) {
                    System.out.println("saisie incorrect");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            
            //vérification de victoire et sérialisation du gagnant si il y en a un
            if (multiGame.checkForVictory()) {
                if (multiGame.getPlayerOneTurn()) {
                    System.out.println(joueur1.getPseudo() + " a gagné !");
                    ScoreSerializer.lauchScoreSerializer(joueur1);
                    break;
                } else {
                    System.out.println(joueur2.getPseudo() + " a gagné !");
                    ScoreSerializer.lauchScoreSerializer(joueur2);
                    break;
                }
            }

            System.out.println("--------------- Changement de joueur ! ---------------");
            multiGame.ChangePlayer();
        }

    }

    /**
     * La fonction displayIALevelSelectionMenu affiche un menu permettant de
     * sélectionner le niveau de difficulté de l'IA
     */

    private static void displayIALevelSelectionMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[---------Choose-a-difficulty--------]");
        menus.add("|                                    |");
        menus.add("|             1: Easy                |");
        menus.add("|             2: Standard            |");
        menus.add("|                                    |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }

    /**
     * La fonction MenuIA permet de lancer une partie contre une IA en sélectionnant
     * le niveau de difficulté
     */
    public static void MenuIA() {
        displayIALevelSelectionMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    lauchGameWithIA("Easy");
                    break;
                case "2":
                    lauchGameWithIA("Standard");
                    break;
                default:
                    System.out.println("Selection erroné!!!!");
                    break;
            }
            displayIALevelSelectionMenu();
        }
    }

    /**
     * Creer une nouvelle instance de Game et tourne en boucle sur les fonctions qui constitue 
     * le déroulement d'une partie Joueur contre IA tout en gérant les exeption qui peuvent survenir.
     * @param difficulty Niveau de difficulté de l'IA
     */
    private static void lauchGameWithIA(String difficulty) {
        // Initialisation des objets joueur et IA
        Ia robot = new Ia(difficulty, Game.matrix);
        Player joueur1 = CreatePlayer();
        Player joueurIA = createAdversary(joueur1, robot.getName());

        // Initialisation d'une nouvelle partie avec les joueurs créés
        Game iaGame = new Game(joueur1, joueurIA);
        iaGame.InitialiseMatrix();
        iaGame.print2dArray();
        // Boucle de jeu
        while (iaGame.CheckForFullBoard() == false) {
            // Tour du joueur 1
            if (iaGame.getPlayerOneTurn()) {
                System.out.println("Saisisser le numéro de la colonne pour votre jeton:");
                do {
                    try {
                        iaGame.addElement(Integer.parseInt(scan.nextLine()));
                        joueur1.setPlayCount(joueur1.getPlayCount() + 1);
                        break;
                    } catch (ParseException e) {
                        System.out.println("saisie incorrect");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                // Tour de l'IA
            } else {
                do {
                    try {
                        iaGame.addElement(robot.iaColumn(Game.matrix, iaGame.getLastX(), iaGame.getLastY(),
                                iaGame.getLastSymbolPlayed()));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
            }
            // Vérifie si un joueur a gagné
            //spécificité lauchGameWithAi : on ne sérialise pas le joueur2 (joueurIA) si il gagne 
            if (iaGame.checkForVictory()) {
                if (iaGame.getPlayerOneTurn()) {
                    System.out.println(joueur1.getPseudo() + " a gagné !");
                    ScoreSerializer.lauchScoreSerializer(joueur1);
                    break;
                } else {
                    System.out.println(joueurIA.getPseudo() + " a gagné ! ");
                    break;
                }
            }
            System.out.println("--------------- Changement de joueur ! ---------------");
            iaGame.ChangePlayer();
        }
    }


}