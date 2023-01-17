package model;

import java.io.Console;
import java.lang.reflect.Constructor;

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

        while (lastY < 5 && matrix[lastX][lastY] == lastSymbol) {
            alignement++;
            lastY++;
        }

        while (initialY >= 0 && matrix[initialX][initialY] == lastSymbol) {
            alignement++;
            initialY--;
        }
        alignement--;
        System.out.println(alignement);
        return alignement;
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

    public static void main(String[] args) {
        String[][] matrix = createMatrice();
        matrix[5][3] = "X";
        matrix[4][3] = "X";
        matrix[3][3] = "X";

        matrix[0][0] = "X";
        matrix[0][1] = "O";
        matrix[0][2] = "X";
        matrix[0][3] = "X";
        verifVerticalAlignement(matrix, 3, 3, "X");
        verifHorizontalAlignement(matrix, 0, 1, "X");
    }

}
