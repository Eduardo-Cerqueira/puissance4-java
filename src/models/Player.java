package models;
import java.text.ParseException;


public class Player {

    private String _pseudo;
    private String _shape;
    private String _color;
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
    public void setShape(String shape) throws ParseException {
        
        if (shape.equalsIgnoreCase("X") || shape.equalsIgnoreCase("O") ) {
            this._shape = shape;
        } else {
            throw new ParseException("Symbol choisis est non valide", 0);
        }
    }

    public String getColor() {
        return _color;
    }
    public void setColor(String color) throws ParseException {
        this._color = color;

        if (color.equalsIgnoreCase("red"))
            { this._color = "\u001B[31m"; }   
        else if(color.equalsIgnoreCase("yellow"))
            { this._color = "\u001B[33m"; }
        else
            { throw new ParseException("Couleur choisis est non valide", 0); }


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
