package com.program.dynamicprogramming;

public class FloydWarshall {

	final static int INF = 99999;

	void floydWarshall(int a[][]) {

		int i, j, k;
		int V = a[0].length;
		for (k = 0; k < V; k++) {
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					if (a[i][k] + a[k][j] < a[i][j])
						a[i][j] = a[i][k] + a[k][j];
				}
			}
		}
		printSolution(a, V);
	}

	void printSolution(int dist[][], int V) {
		System.out.println("matrix shows the shortest distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.println(Character.toString('\u221E')); // unicode infinity symbol
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int a0[][] = { { 0, 3, INF, 7 }, { 8, 0, 2, INF }, { 5, INF, 0, 1 }, { 2, INF, INF, 0 } };
		FloydWarshall fw = new FloydWarshall();
		fw.floydWarshall(a0);
	}

}
