package models;

public class Player {
  
    private String _pseudo;
    private String _shape;
    private String color;
    private String color2;
    private int _playCount;
    public Boolean _isWinner = false;

    public String getPseudo() {
        return _pseudo;
    }
    public void setPseudo(String _pseudo) {
        this._pseudo = _pseudo;
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
                color = "\u001B[43m";
                break;
            case "2":
                color = "\u001B[44m";
                break;
            case "3":
                color = "\u001B[40m";
                break;
            case "4":
                color = "\u001B[45m";
                break;
            case "5":
                color = "\u001B[46m";
                break;
            case "6":
                color = "\u001B[42m";
                break;
            case "7":
                color = "\u001B[47m";
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
                color = "\u001B[43m";
                break;
            case "2":
                color = "\u001B[44m";
                break;
            case "3":
                color = "\u001B[40m";
                break;
            case "4":
                color = "\u001B[45m";
                break;
            case "5":
                color = "\u001B[46m";
                break;
            case "6":
                color = "\u001B[42m";
                break;
            case "7":
                color = "\u001B[47m";
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
