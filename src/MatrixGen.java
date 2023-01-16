public class MatrixGen {

	public static void main(String[] args) {
		int row = 6;
		int column = 7;

		String[][] matrix = new String[row][column];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				//Contenu par défault de la matrice
				matrix[r][c] = " ";
			}
		}
		print2dArray(matrix);
	}

	private static void print2dArray(String[][] matrix) {
		
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
}