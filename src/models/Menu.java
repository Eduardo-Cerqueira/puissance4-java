package models;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Menu {
    private String player;
    private String player2;

    public String getNamePlayer() {
        return player;
    }

    public void setNamePlayer(String player) throws ParseException {
        int count = 0;
        for(int i = 0; i < player.length(); i++) {    
            if(player.charAt(i) != ' ')    
            count++;    
        }
        if (count >= 1) {
            this.player = player;
        } else {
            throw new ParseException("You typed a invalid name !",0);
        }
    }

    public String getNamePlayer2() {
        return player2;
    }

    public void setNamePlayer2(String player2) throws ParseException {
        int count = 0;
        for(int i = 0; i < player2.length(); i++) {    
            if(player2.charAt(i) != ' ')    
            count++;    
        }
        if (count >= 1) {
            this.player2 = player2;
        } else {
            throw new ParseException("You typed a invalid name !",0);
        }
    }

    private String AI;

    public String getDifficultyAI() {
        return AI;
    }

    public void setDifficultyAI(String AI) {
        this.AI = AI;
    }

    private String Gamemode;

    public String getGamemode() {
        return Gamemode;
    }

    public void setGamemode(String Gamemode) {
        this.Gamemode = Gamemode;
    }

    public void save() throws IOException {
        try {
            FileWriter file = new FileWriter("score.csv", true);
            file.write(this.toString()+"\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
