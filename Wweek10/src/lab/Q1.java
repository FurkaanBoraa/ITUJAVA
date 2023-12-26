package lab;

public class Q1 {
	
	public static boolean checkTranspose(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double matrix[][] = {{1,4,7},
							 {4,5,6},
							 {7,6,3}};
		boolean a = checkTranspose(matrix);
		System.out.println(a);

	}

}
