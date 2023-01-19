package models;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

    public void savePlayCount(int _playCount) throws IOException {
        try {
            //create FileOutputStream object
           FileOutputStream file = new FileOutputStream("src/data/scores.csv", true);
           /*
           * To create DataOutputStream object from FileOutputStream use,
           * DataOutputStream(OutputStream os) constructor.
           */
           DataOutputStream dos = new DataOutputStream(file);
           dos.writeInt(_playCount);
           dos.close();
       } catch (IOException error) {
           error.printStackTrace();
       }
    }

    public Boolean getIsWinner() {
        return _isWinner;
    }
    public void setIsWinner(Boolean _isWinner) {
        this._isWinner = _isWinner;
    }

    public static final String spliter = ";";

    public String toString() {
        StringBuilder construct = new StringBuilder();
        construct.append(getPseudo());
        construct.append(spliter);
        construct.append(getPlayCount());
        return construct.toString();
    }

    public static ArrayList<Player> Top10Scores() throws IOException {
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
    
    public static void sortByScore() {
        ArrayList<Player> listScore;
        try {
            listScore = Top10Scores();
            Collections.sort(listScore, new Player());
            for (Player player : listScore) {
                System.out.println("TOP -> "+ player.getPseudo() + " " + player.getPlayCount());
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public int compare(Player a, Player b) 
    { 
        return b.getPlayCount() - a.getPlayCount(); 
    } 
}
