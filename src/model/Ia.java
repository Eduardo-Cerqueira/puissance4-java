package model;

import java.lang.reflect.Constructor;

public class Ia {

    private String name;
    private String symbol;
    private String difficulty;
    private MatrixGen matrice;

    public Ia(String name, String symbol, String difficulty, MatrixGen matrix) {

        name = name;
        symbol = symbol;
        difficulty = difficulty;
        matrix = matrix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }

    public int randomColumn() {

        int column = (int) Math.floor(Math.random() * (6 - 0 + 1) + 0);

        return column;
    }

}
