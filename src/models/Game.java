package models;
import java.util.Arrays;

public class Game {

    //définition du tableau pour notre grille de jeu
    public static String[][] matrix = new String[6][7];
	
    //provisoire en dure pour test
    private String symbolJoueur = "@";
    private String symbolJoueur2 = "=";

    //ensemble des compteur représentant le remplissage de chacune des colones
    private int[] CompteursColone ={5, 5, 5, 5, 5, 5, 5};
    //variable pour garder le suivi du tour de jeu
    boolean isPlayerOneTurn = true;


    private int lastX;
    public int getLastX() {return lastX;}

    private int lastY;
    public int getLastY() {return lastY;}

    private boolean isBoardFull = false;
    public boolean isBoardFull() {return isBoardFull;}

    private Player _player1;
    private Player _player2;


    public Game(Player player1, Player player2) {
        _player1 = player1;
        _player2 = player2;
    }

    //surcharge du constructeur
    public Game(Player player1, Ia ia) {
        _player1 = player1;
        _player2 = new Player();
        try {
            _player2.setColor(ia.getSymbol());
            _player2.setShape(ia.getSymbol());
        }
        catch (Exception e){
            System.out.println("probleme recupération parametre ia");
        }
    }



    /**
     * Méthode pour afficher notre grille dans son état actuel.
     */
    public void print2dArray() {
		
		for (int r = 0; r < matrix.length; r++) {
			if (r == 0) {
				//Print top
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
			if (r < matrix.length-1) {
				System.out.println(" |---+---+---+---+---+---+---|");
			} else {
				//Print bottom
				System.out.println(" \\===========================/");
				System.out.println("Joueur Bob, choisisser votre colonne?\n");
			}
		}
	}

    /**
     * Affectation de chaine vide pour tout les element de la grille.
     */
    public void InitialiseMatrix(){
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				//Contenu par défault de la matrice
				matrix[r][c] = " ";
			}
		}
    }
    
    
    public void ChangePlayer()
    {
        isPlayerOneTurn = !isPlayerOneTurn;
    }
    
    /**
     * Vérifie si le compteur de la colonne selectioné n'est pas négatif,
     * Ajoute le symbol du joueur en cours dans la colonne selectionné
     * @param choixJoueur [in] Int index de la colonne selectionné par le joueur pour placer un pion.
     * @return [out] Boolean indiquant si la colone choisis est déjà pleine.
     */
    public boolean addElement(int choixJoueur) throws Exception { 

        choixJoueur --;
        boolean isFull = false; 
        
        //tant que le compteur d'une colonne n'est pas dans le négatif, on peut placer dedans
        if (CompteursColone[choixJoueur] >= 0)
        {
            //On alterne le symbole placer a chaque fois que la fonction add element est appelé
            if (isPlayerOneTurn == true)
                {matrix[CompteursColone[choixJoueur]][choixJoueur] = (_player1.getColor() + _player1.getShape() + "\u001B[0m");}
            else
                {matrix[CompteursColone[choixJoueur]][choixJoueur] = (_player2.getColor() + _player2.getShape() + "\u001B[0m");}

            System.out.println(CompteursColone);
            CompteursColone[choixJoueur] -- ;
            print2dArray();
            System.out.println("compteur actuel de la colone = " + CompteursColone[choixJoueur] );
            
            //on garde en mémoire des donné utile pour le reste du programme
            lastX = choixJoueur;
            lastY = CompteursColone[choixJoueur];

            //changement de jour
            //ChangePlayer();

        }
        else
        {
            //si le compteur de la colonne est négatif , on ne peut plus jouer dedans
            System.out.println("la colonne est pleine !");
            isFull = true;
            throw new Exception("la colonne est pleine !");
        }
       
        //CheckForFullBoard();
        //est ce que je return isFull ou je modifie le champs isFull de la class Jeu qui serait accésible en public ?
        return isFull;
    }

    public boolean CheckForFullBoard()
    {
        if (CompteursColone[0] == -1)
        {
            //si tout les compteur de mes colonnes sont éguale, cela signifie qu'il sont éguale a CompteursColone[0] == -1 , alors la grille est pleine.
            if ( Arrays.stream(CompteursColone).allMatch(t -> t == CompteursColone[0]) )
            {
                System.out.println("TABLEAU REMPLIE PARTIE TERMINE");
                isBoardFull = true;
                return true; //ici le return est pour mettre fin a la fonction
            }
        }
        System.out.println("Tour suivant : la partie continue");
        return false;
    }



}