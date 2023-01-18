package models;

import java.text.ParseException;

public class Player {
  
    private String pseudo;
    private String pseudo2;
    private String _shape;
    private String color;
    private String color2;
    private int _playCount;
    public Boolean _isWinner = false;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String player) throws ParseException {
        int count = 0;
        for(int i = 0; i < player.length(); i++) {    
            if(player.charAt(i) != ' ')    
            count++;    
        }
        if (count >= 1) {
            this.pseudo = player;
        } else {
            throw new ParseException("You typed a invalid name !",0);
        }
    }

    public String getPseudo2() {
        return pseudo2;
    }

    public void setPseudo2(String player2) throws ParseException {
        int count = 0;
        for(int i = 0; i < player2.length(); i++) {    
            if(player2.charAt(i) != ' ')    
            count++;    
        }
        if (count >= 1) {
            this.pseudo2 = player2;
        } else {
            throw new ParseException("You typed a invalid name !",0);
        }
    }

    public String getShape() {
        return _shape;
    }
    public void setShape(String _shape) {
        this._shape = _shape;
    }
    public String getColor() {
        return color;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor(String color) {
        switch (color) {
            case "1":
                color = "\u001B[33m";
                break;
            case "2":
                color = "\u001B[34m";
                break;
            case "3":
                color = "\u001B[30m";
                break;
            case "4":
                color = "\u001B[35m";
                break;
            case "5":
                color = "\u001B[36m";
                break;
            case "6":
                color = "\u001B[32m";
                break;
            case "7":
                color = "\u001B[37m";
                break;
            case "a":
                return;
            default:
                System.out.println("Are you sure your answer is correct ?");
                break;
        }
        this.color = color;
    }

    public void setColor2(String color) {
        switch (color) {
            case "1":
                color = "\u001B[33m";
                break;
            case "2":
                color = "\u001B[34m";
                break;
            case "3":
                color = "\u001B[30m";
                break;
            case "4":
                color = "\u001B[35m";
                break;
            case "5":
                color = "\u001B[36m";
                break;
            case "6":
                color = "\u001B[32m";
                break;
            case "7":
                color = "\u001B[37m";
                break;
            case "a":
                return;
            default:
                System.out.println("Are you sure your answer is correct ?");
                break;
        }
        this.color2 = color;
    }

    public int getPlayCount() {
        return _playCount;
    }
    public void setPlayCount(int _playCount) {
        this._playCount = _playCount;
    }
    public Boolean getIsWinner() {
        return _isWinner;
    }
    public void setIsWinner(Boolean _isWinner) {
        this._isWinner = _isWinner;
    }
}
