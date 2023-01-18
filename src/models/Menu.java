package models;

import java.text.ParseException;

public class Menu {

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

    public void setGamemode(String Gamemode) throws ParseException {
        switch (Gamemode) {
            case "1":
                Gamemode = "Singleplayer";
                CreateMenu.LaunchSingleplayer();
                break;
            case "2":
                Gamemode = "Multiplayer";
                CreateMenu.LaunchMultiplayer();
                break;
            case "3":
                Gamemode = "TOP10";
                CreateMenu.LaunchTOP10();
                break;
            case "a":
                return;
            default:
                System.out.println("Are you sure your answer is correct ?");
                break;
        }
        this.Gamemode = Gamemode;
    }
}
