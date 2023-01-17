package models;

import java.io.Console;
import java.lang.reflect.Constructor;

import javax.swing.GroupLayout.Alignment;

public class Ia {

    private String name;
    private String symbol;
    private String difficulty;
    private MatrixGen matrice;

    public Ia(String symbol, String difficulty, MatrixGen matrix) {

        name = "Michel";
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

    public MatrixGen getMatrice() {
        return matrice;
    }

    public void setMatrice(MatrixGen matrice) {
        this.matrice = matrice;
    }

    public static String[][] createMatrice() {
        int row = 6;
        int column = 7;

        String[][] matrix = new String[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                // Contenu par défault de la matrice
                matrix[r][c] = " ";
            }
        }

        return matrix;
    }

    public int randomColumn() {
        int column = (int) Math.floor(Math.random() * (6 - 0 + 1) + 0);
        return column;
    }

    public static int verifVerticalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {

        // Haut en bas
        int alignement = 0;

        while (lastX < 6 && matrix[lastX][lastY] == "X") {
            alignement++;
            lastX++;
        }
        System.out.println(alignement);
        return alignement;
    }

    public static int verifHorizontalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;

        int initialX = lastX;
        int initialY = lastY;

        // Gauche à droite
        while (lastY < 7 && matrix[lastX][lastY] == lastSymbol) {
            alignement++;
            lastY++;
        }

        // Droite à gauche
        while (initialY >= 0 && matrix[initialX][initialY] == lastSymbol) {
            alignement++;
            initialY--;
        }
        alignement--;
        System.out.println(alignement);
        return alignement;
    }

    public static int verifRightDiagonalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;

        int initialX = lastX;
        int initialY = lastY;

        // bas en haut
        while (lastX >= 0 && lastY < 7 && matrix[lastX][lastY] == lastSymbol) {
            alignement++;
            lastX--;
            lastY++;
        }

        // haut en bas
        while (initialX < 7 && initialY >= 0 && matrix[initialX][initialY] == lastSymbol) {
            alignement++;
            initialX++;
            initialY--;
        }

        System.out.println(alignement - 1);
        return alignement - 1;
    }

    public static int verifLeftDiagonalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;

        int initialX = lastX;
        int initialY = lastY;

        // bas en haut
        while (lastX < 7 && lastY < 7 && matrix[lastX][lastY] == lastSymbol) {
            alignement++;
            lastX++;
            lastY++;
        }

        // haut en bas
        while (initialY >= 0 && initialX >= 0 && matrix[initialX][initialY] == lastSymbol) {
            alignement++;
            initialY--;
            initialX--;
        }

        System.out.println(alignement - 1);
        return alignement - 1;
    }

    public void iaColumn() {

        switch (getDifficulty()) {
            case "1":
                randomColumn();
                break;

            case "2":

                break;
            default:
                break;
        }
        ;
    }

}
