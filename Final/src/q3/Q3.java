package q3;

import java.security.SecureRandom;
import java.util.Scanner;

public class Q3 {
	public static void FindTrace(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum *= matrix[i][i];
		}
		System.out.println("Trace of matrix is: " + sum);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SecureRandom random = new SecureRandom();
		System.out.println(random.nextInt(3));
		System.out.println("Enter size of the matrix n: ");

		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = random.nextInt(51);
			}
		}
		FindTrace(matrix);

	}

}
