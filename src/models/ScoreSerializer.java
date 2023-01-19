package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreSerializer  {

    private Player player;

    public ScoreSerializer(Player player) {
        this.player = player;
    }

    public static void savePlayCount(Player p) throws IOException {
        try {
            FileWriter file = new FileWriter("src/data/scores.csv", true);
            file.write(p.getPseudo()+";"+p.getPlayCount()+"\n");
            file.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

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

    public int compare(Player a, Player b) 
    { 
        return b.getPlayCount() - a.getPlayCount();
    }

    public static final String spliter = ";";

    public String toString() {
        StringBuilder construct = new StringBuilder();
        construct.append(player.getPseudo());
        construct.append(spliter);
        construct.append(player.getPlayCount());
        return construct.toString();
    }

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
}
