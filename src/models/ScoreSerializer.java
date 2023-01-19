package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreSerializer  {
    // Variable to host player objects
    private Player player;

    // Contructor for player class
    public ScoreSerializer(Player player) {
        this.player = player;
    }


    /**
     * Function to save the player score (PlayCount)
     * Open a FileWrite to create a file at "src/data/scores.csv" and edit
     * The line created at scores.csv is going to be PlayerPseudo;PlayerPlayCount like -> Me;15
     * @param p player who win and need to have his data (name + playCount) serialized
     * @throws IOException
     */
    public static void savePlayCount(Player p) throws IOException {
        try {
            FileWriter file = new FileWriter("src/data/scores.csv", true);
            file.write(p.getPseudo()+";"+p.getPlayCount()+"\n");
            file.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * Function to sort Players by Score using a ArrayList from the function allScores
     * The function sort only 10 players because of i < 10 and 
     * because Collections.sort sort Players by Score, 
     * we only get the top 10 best players
     */
    public static void sortByScore() {
        ArrayList<Player> listScore;
        try {
            listScore = allScores();
            Collections.sort(listScore, new Player());
            int i = 0;
            for (Player player : listScore) {
                if (i < 10) {
                    System.out.println("TOP -> "+ player.getPseudo() + " " + player.getPlayCount());
                    i++;
                } else {
                    break;
                }
            }
        } catch (IOException error) {
            System.out.println("\nNo score to show !\n");
        }
    }

    // Where to split the data in csv
    public static final String spliter = ";";

    // Function to create a string like this -> "PlayerPseudo;PlayerPlayCount" using data from player
    public String toString() {
        StringBuilder construct = new StringBuilder();
        construct.append(player.getPseudo());
        construct.append(spliter);
        construct.append(player.getPlayCount());
        return construct.toString();
    }

    /* Function to get all the scores from scores.csv and add them to the ArrayList "list"
     * if a new ligne of scores exist, the program split the line using the spliter and 
     * create a player using the data of the line that is saved to "list"
    */
    public static ArrayList<Player> allScores() throws IOException {
        String spliter = ";";

        ArrayList<Player> list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("src/data/scores.csv"));
        try {
            String ligne = buffer.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(spliter);
                Player player = new Player();
                player.setPseudo(tab[0]);
                player.setPlayCount(Integer.valueOf(tab[1]));
                list.add(player);
                ligne = buffer.readLine();
            }
        } catch (IOException error) {
            System.out.println("Error : can't read the file, check it exists");
        } finally {
            buffer.close();
        }
        return list;
    }


    /**
     * lauch the function that serialized the player info and take care of exeptions
     * @param joueurWinner the player to serialized
     */
    public static void lauchScoreSerializer(Player joueurWinner){
        try {
            savePlayCount(joueurWinner);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
