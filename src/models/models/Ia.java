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

    public String getSymbol() {
        return symbol;
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
        int initialX = lastX, initialY = lastY;
        int victoryY = 0;
        boolean holeDetected = false;
        int alignement = 0;

        while (lastY <= 6 && matrix[lastX][lastY].equals(lastSymbol)) {
            System.out.println(" Right victoryY == " + victoryY);
            if (matrix[lastX][lastY].equals(" ") && matrix[lastX][lastY + 1].equals(lastSymbol)) {
                holeDetected = true;
                victoryY = lastY;
            } else if (!holeDetected && lastY != 6) {
                victoryY = lastY + 1;
            }
            alignement++;
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
            alignement++;
            initialY--;
        }

        if (victoryY == 7) {
            victoryY = 3;
        }
        if (alignement >= 2 && holeDetected) {
            return victoryY;
        } else if (alignement >= 3 && !holeDetected) {
            return victoryY;
        }
        {
            return -1;
        }

    }

    public static int preventPlayerPotentialDiagonalWin(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;
        int victoryY = 0;
        boolean holeDetected = false;
        int initialX = lastX, initialY = lastY;
        // Vérifie l'alignement en bas à gauche
        while (initialX < 6 && initialY > 0 && matrix[initialX][initialY].equals(lastSymbol)) {
            if (matrix[initialX][initialY].equals(" ") && initialX < 5 && initialY > 0
                    && matrix[initialX + 1][initialY - 1].equals(lastSymbol)) {
                holeDetected = true;
                victoryY = initialY;
            } else if (!holeDetected && initialY != 0) {
                victoryY = initialY - 1;
            }
            alignement++;
            initialX++;
            initialY--;
        }
        holeDetected = false;
        // Vérifie l'alignement en haut à droite
        while (lastX >= 0 && lastY < 7 && matrix[lastX][lastY].equals(lastSymbol)) {
            if (matrix[lastX][lastY].equals(" ") && lastX > 0 && lastY < 6
                    && matrix[lastX - 1][lastY + 1].equals(lastSymbol)) {
                holeDetected = true;
                victoryY = lastY;
            } else if (!holeDetected && lastY != 7) {
                victoryY = lastY + 1;
            }
            alignement++;
            lastX--;
            lastY++;
        }

        System.out.println(victoryY);
        if (alignement >= 2 && holeDetected) {
            return victoryY;
        } else if (alignement >= 3 && !holeDetected) {
            return victoryY;
        } else {
            return -1;
        }
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
