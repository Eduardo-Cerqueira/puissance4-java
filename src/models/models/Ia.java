package models;

public class Ia {

    private String name;
    private String symbol;
    private String difficulty;
    private String[][] matrice;

    public Ia(String symbol, String difficulty, String[][] matrix) {

        this.name = "Michel";
        this.symbol = symbol;
        this.difficulty = difficulty;
        this.matrice = matrix;
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

    public static int randomColumn() {
        int column = (int) (Math.random() * 7 + 1);
        return column;
    }

    public static int verifVerticalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {

        // Haut en bas
        int alignement = 0;

        while (lastX < 6 && matrix[lastX][lastY] == lastSymbol) {
            alignement++;
            lastX++;
        }
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

    public static int preventPlayerPotentialHorizontalWin(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int initialX = lastX;
        int initialY = lastY;
        int victoryY = 0;
        boolean holeDetected = false;

        while (lastY <= 6 && matrix[lastX][lastY].equals(lastSymbol)) {
            System.out.println(" Right victoryY == " + victoryY);
            if (matrix[lastX][lastY].equals(" ") && matrix[lastX][lastY + 1].equals(lastSymbol)) {
                holeDetected = true;
                victoryY = lastY;
            } else if (!holeDetected && lastY != 6) {
                victoryY = lastY + 1;
            }
            lastY++;
        }
        holeDetected = false;

        while (initialY >= 0 && matrix[initialX][initialY].equals(lastSymbol)) {
            System.out.println(" Right victoryY == " + victoryY);
            if (initialY > 1) {
                if (matrix[initialX][initialY - 1].equals(" ") && matrix[initialX][initialY - 2].equals(lastSymbol)) {
                    holeDetected = true;
                    victoryY = initialY - 1;
                } else if (!holeDetected && lastY != 0) {
                    victoryY = lastY;
                }
            }
            initialY--;
        }

        if (victoryY == 7) {
            victoryY = 3;
        }
        return victoryY;

    }

    public static int preventPlayerVictory(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int column = 0;

        System.out.println(verifVerticalAlignement(matrix, lastX, lastY, lastSymbol));

        if (verifVerticalAlignement(matrix, lastX, lastY, lastSymbol) == 3) {

            System.out.println("Align");
            column = lastY + 1;

        } else if (preventPlayerPotentialHorizontalWin(matrix, lastX, lastY, lastSymbol) != -1) {
            column = preventPlayerPotentialHorizontalWin(matrix, lastX, lastY, lastSymbol) + 1;
        } else {
            System.out.println("not align");
            column = randomColumn();
        }
        return column;
    }

    public int iaColumn(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int column = 0;
        switch (this.getDifficulty()) {
            case "Easy":
                column = this.randomColumn();
                break;
            case "Standard":
                column = this.preventPlayerVictory(matrix, lastX, lastY, lastSymbol);
                break;
            case "Hard":
                break;
            case "Hell":
                break;
            default:
                break;
        }
        return column;
    }

}
