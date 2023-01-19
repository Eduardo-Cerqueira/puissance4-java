
package models;

import java.util.Arrays;

public class Game {

    // définition du tableau pour notre grille de jeu
    public static String[][] matrix = new String[6][7];

    // ensemble des compteur représentant le remplissage de chacune des colones
    private int[] CompteursColone = { 5, 5, 5, 5, 5, 5, 5 };
    // variable pour garder le suivi du tour de jeu
    private boolean isPlayerOneTurn = true;

    public boolean getPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    //on garde en mémoire les coordonné du dernier jeton placé pour les besoin de l'ia
    private int lastX;

    public int getLastX() {
        return lastX;
    }

    private int lastY;

    public int getLastY() {
        return lastY;
    }

    //on garde en mémoire le string exact representant le dernier symbole placé pour les besoin de l'ia
    private String lastSymbolPlayed;

    public String getLastSymbolPlayed() {
        return lastSymbolPlayed;
    }

    private boolean isBoardFull = false;

    public boolean isBoardFull() {
        return isBoardFull;
    }

    private Player _player1;
    private Player _player2;

    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
    }


    /**
     * Méthode pour afficher notre grille dans son état actuel.
     */
    public void print2dArray() {

        for (int r = 0; r < matrix.length; r++) {
            if (r == 0) {
                // Print top
                System.out.println("   1   2   3   4   5   6   7 \n");
            }
            for (int c = 0; c < matrix[0].length; c++) {
                if (c == 0) {
                    System.out.print(" | " + matrix[r][c] + " | ");
                } else {
                    System.out.print(matrix[r][c] + " | ");
                }
            }
            System.out.println();
            if (r < matrix.length - 1) {
                System.out.println(" |---+---+---+---+---+---+---|");
            } else {
                // Print bottom
                System.out.println(" \\===========================/");
                System.out.println("Joueur Bob, choisisser votre colonne?\n");
            }
        }
    }

    /**
     * Affectation de chaine vide pour tout les element de la grille.
     */
    public void InitialiseMatrix() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                // Contenu par défault de la matrice
                matrix[r][c] = " ";
            }
        }
    }

    /**
     * Permet d'alterner entre les deux joueur qui sont associé a la partie.
     */
    public void ChangePlayer() {
        isPlayerOneTurn = !isPlayerOneTurn;
    }

    /**
     * Vérifie si le compteur de la colonne selectioné n'est pas négatif,
     * Ajoute le symbol du joueur en cours dans la colonne selectionné
     * 
     * @param choixJoueur [in] Int index de la colonne selectionné par le joueur
     *                    pour placer un pion.
     * @return [out] Boolean indiquant si la colone choisis est déjà pleine.
     */
    public boolean addElement(int choixJoueur) throws Exception {

        //réduction de -1 car notre matrice en code commence a l'index 0 et non pas vraiment à 1 comme affiché au joueur
        choixJoueur--;
        boolean isFull = false;

        // tant que le compteur d'une colonne n'est pas dans le négatif, on peut placer dedans
        if (CompteursColone[choixJoueur] >= 0) {
            // On alterne le symbole placer a chaque fois que la fonction add element est
            // appelé
            if (isPlayerOneTurn == true) {
                matrix[CompteursColone[choixJoueur]][choixJoueur] = (_player1.getColor() + _player1.getShape()
                        + "\u001B[0m");
                lastSymbolPlayed = _player1.getColor() + _player1.getShape() + "\u001B[0m";
            } else {
                matrix[CompteursColone[choixJoueur]][choixJoueur] = (_player2.getColor() + _player2.getShape()
                        + "\u001B[0m");
                lastSymbolPlayed = _player2.getColor() + _player2.getShape() + "\u001B[0m";
            }

            System.out.println(CompteursColone);
            CompteursColone[choixJoueur]--;
            print2dArray();
            System.out.println("compteur actuel de la colone = " + CompteursColone[choixJoueur]);

            // on garde en mémoire des donné utile pour le reste du programme (ia)
            lastX = CompteursColone[choixJoueur] + 1;
            lastY = choixJoueur;

        } else {
            // si le compteur de la colonne est négatif , on ne peut plus jouer dedans
            System.out.println("la colonne est pleine !");
            isFull = true;
            throw new Exception("la colonne est pleine !");
        }

        // CheckForFullBoard();
        // est ce que je return isFull ou je modifie le champs isFull de la class Jeu
        // qui serait accésible en public ?
        return isFull;
    }

    /**
     * Vérifie la valeur de nos Compteurs de colones , si et seulement si 
     * celui de la premiere colonne est passé en négatif, alors on vérifie si tout les autre compteur sont eux aussi a la meme valeur.
     * Si tout les compteur de colonne sont en effet passé en négatif, alors la grille est pleine.
     * @return [out] Boolean indiquant si la grille de jeu est pleine
     */
    public boolean CheckForFullBoard() {
        if (CompteursColone[0] == -1) {
            // si tout les compteur de mes colonnes sont éguale, cela signifie qu'il sont
            // éguale a CompteursColone[0] == -1 , alors la grille est pleine.
            if (Arrays.stream(CompteursColone).allMatch(t -> t == CompteursColone[0])) {
                System.out.println("TABLEAU REMPLIE PARTIE TERMINE");
                isBoardFull = true;
                return true; // ici le return est pour mettre fin a la fonction
            }
        }
        System.out.println("Tour suivant : la partie continue");
        return false;
    }


    /**
     * Réutilise les methode de detection d'alignement de symbole créer pour la prise de décision de l'IA 
     * mais cette fois ci pour detecté une victoire dans le cas ou la detection nous renvoie que 4 symbol sont aligné 
     * @return true si on detecte un alignement de 4 symbole, sinon return false
     */
    public boolean checkForVictory() {
        if (Ia.verifVerticalAlignement(matrix, lastX, lastY, lastSymbolPlayed) >= 4) {
            return true;
        } else if (Ia.verifHorizontalAlignement(matrix, lastX, lastY, lastSymbolPlayed) >= 4) {
            return true;
        } else if (Ia.verifLeftDiagonalAlignement(matrix, lastX, lastY, lastSymbolPlayed) >= 4) {
            return true;
        } else if (Ia.verifRightDiagonalAlignement(matrix, lastX, lastY, lastSymbolPlayed) >= 4) {
            return true;
        }

        return false;
    }

}