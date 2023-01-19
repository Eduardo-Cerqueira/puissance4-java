package models;
import java.text.ParseException;
import java.util.Comparator;

// implements Comparator to compare itself for score
public class Player implements Comparator<Player> {

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
    /**
     * Vérifie que la valeur passé est bien éguale a "X" ou "O", sinon renvoie une erreur.
     * @throws ParseException
     */
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
    /**
     * Vérifie que la valeur passé correspond bien a "red" ou "yellow" comme indiqué dans le menu.
     * et affecte le bon code couleur ANSI en fonction de la saisie.
     * @throws ParseException
     */
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

    // Compare score of 2 players objects and find if 'player a' have a bigger score than 'player b'
    public int compare(Player a, Player b) 
    {
        return a.getPlayCount() - b.getPlayCount();
    }
}
