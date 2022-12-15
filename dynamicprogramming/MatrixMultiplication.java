package com.program.dynamicprogramming;

//matrix multiplication using tabulation(iterative approach)
public class MatrixMultiplication {

	public static char name;

	public static void matrixMultiplication(int dimensions[]) {

		int n = dimensions.length;
		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		int i, j, k, d, q, min;

		// outer loop is for diagonal
		for (d = 1; d < n - 1; d++) {
			for (i = 1; i < n - d; i++) {
				j = i + d;
				min = Integer.MAX_VALUE;
				for (k = i; k < j; k++) {
					q = m[i][k] + m[k + 1][j] + (dimensions[i - 1] * dimensions[k] * dimensions[j]);
					if (q < min) {
						min = q;
						s[i][j] = k;
					}
				}
				m[i][j] = min;
			}
		}
		System.out.println("the number number of multiplications needed: " + m[1][n - 1]);
		name = 'A';

		System.out.print("Optimal Parenthesization is: ");
		printParenthesis(1, n - 1, n, s);
	}

	static void printParenthesis(int i, int j, int n, int[][] bracket) {
		// If only one matrix left in current segment
		if (i == j) {
			System.out.print(name++);
			return;
		}

		System.out.print('(');
		printParenthesis(i, bracket[i][j], n, bracket);
		printParenthesis(bracket[i][j] + 1, j, n, bracket);
		System.out.print(')');
	}

	public static void main(String[] args) {

		int dimensions[] = { 5, 10, 3, 12, 5, 50, 6 };
		matrixMultiplication(dimensions);
	}

}
