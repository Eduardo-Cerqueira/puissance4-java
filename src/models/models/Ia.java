package models;

public class Ia {

    private String name;
    private String symbol;
    private String difficulty;

    public Ia(String symbol, String difficulty, String[][] matrix) {

        this.name = "Michel";
        this.symbol = symbol;
        this.difficulty = difficulty;
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

    public static int randomColumn() {
        int column = (int) (Math.random() * 7 + 1);
        return column;
    }

    /**
     * La fonction verifVerticalAlignement vérifie s'il y a un alignement vertical
     * de jetons d'un joueur donné à partir d'une position donnée sur le plateau de
     * jeu
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return Le nombre de jetons alignés verticalement
     */
    public static int verifVerticalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;
        // Vérifie l'alignement en haut en bas
        while (lastX < 6 && matrix[lastX][lastY].equals(lastSymbol)) {
            alignement++;
            lastX++;
        }
        return alignement;
    }

    /**
     * La fonction verifHorizontalAlignement vérifie s'il y a un alignement
     * horizontal de jetons d'un joueur donné à partir d'une position donnée sur le
     * plateau de jeu
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant
     * @return Le nombre de jetons alignés horizontalement
     */
    public static int verifHorizontalAlignement(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;
        int initialX = lastX;
        int initialY = lastY;

        // Vérifie l'alignement de gauche à droite
        while (lastY < 7 && matrix[lastX][lastY].equals(lastSymbol)) {
            alignement++;
            lastY++;
        }

        // Vérifie l'alignement de droite à gauche
        while (initialY >= 0 && matrix[initialX][initialY].equals(lastSymbol)) {
            alignement++;
            initialY--;
        }
        alignement--;
        return alignement;
    }

    /**
     * La fonction verifRightDiagonalAlignement vérifie s'il y a un alignement
     * diagonal (bas-gauche, haut-droite) de jetons d'un joueur donné à partir d'une
     * position donnée sur le plateau de jeu.
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return Le nombre de jetons alignés en diagonale (bas-gauche, haut-droite)
     */
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

    /**
     * La fonction verifLeftDiagonalAlignement vérifie s'il y a un alignement
     * diagonal de jetons d'un joueur donné à partir d'une position donnée sur le
     * plateau de jeu (diagonale gauche)
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return Le nombre de jetons alignés diagonalement
     */

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

    /**
     * La fonction preventPlayerPotentialHorizontalWin vérifie s'il y a une victoire
     * potentielle d'un joueur sur le plateau de jeu (alignement horizontal) et
     * renvoie la colonne à jouer pour empêcher cette victoire.
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return La colonne à jouer pour empêcher une victoire potentielle (colonne de
     *         1 à 7) ou -1 si aucune victoire potentielle n'est détectée
     */

    public static int preventPlayerPotentialHorizontalWin(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int initialX = lastX, initialY = lastY;
        int victoryY = 0;
        boolean holeDetected = false;
        int alignement = 0;

        while (lastY <= 6 && matrix[lastX][lastY].equals(lastSymbol)) {
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
        } else {
            return -1;
        }
    }

    /**
     * La fonction preventPlayerPotentialDiagonalWin vérifie s'il y a une victoire
     * potentielle d'un joueur sur le plateau de jeu (alignement diagonal) et
     * renvoie la colonne à jouer pour empêcher cette victoire.
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return La colonne à jouer pour empêcher une victoire potentielle (colonne de
     *         1 à 7) ou -1 si aucune victoire potentielle n'est détectée
     */

    public static int preventPlayerPotentialDiagonalWin(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int alignement = 0;
        int victoryY = 0;
        boolean holeDetected = false;
        int initialX = lastX, initialY = lastY;
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

    /**
     * La fonction preventPlayerVictory vérifie s'il y a une victoire potentielle
     * d'un joueur sur le plateau de jeu et renvoie la colonne à jouer pour empêcher
     * cette victoire.
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return La colonne à jouer pour empêcher une victoire potentielle (colonne de
     *         1 à 7) ou une colonne aléatoire (colonne de 1 à 7) si aucune victoire
     *         potentielle n'est détectée
     */

    public static int preventPlayerVictory(String[][] matrix, int lastX, int lastY, String lastSymbol) {
        int column = 0;

        System.out.println(verifVerticalAlignement(matrix, lastX, lastY, lastSymbol));

        if (verifVerticalAlignement(matrix, lastX, lastY, lastSymbol) == 3) {
            column = lastY + 1;
        } else if (preventPlayerPotentialHorizontalWin(matrix, lastX, lastY, lastSymbol) != -1) {
            column = preventPlayerPotentialHorizontalWin(matrix, lastX, lastY, lastSymbol) + 1;
        } else {
            column = randomColumn();
        }
        return column;
    }

    /**
     * La fonction iaColumn sélectionne une colonne à jouer pour l'IA en fonction de
     * la difficulté choisie.
     * 
     * @param matrix     Plateau de jeu (grille de 6 lignes et 7 colonnes)
     * @param lastX      Coordonnée en X de la dernière case jouée
     * @param lastY      Coordonnée en Y de la dernière case jouée
     * @param lastSymbol Symbole du joueur courant ('X' ou 'O')
     * @return La colonne sélectionnée pour jouer (colonne de 1 à 7)
     */

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
