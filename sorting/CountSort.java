package com.program.sorting;

public class CountSort {

	public static int[] countSort(int[] a) {
		int n = a.length;
		int m = a[0];
		for (int i = 1; i < n; ++i)
			m = Math.max(m, a[i]);

		int[] c = new int[m + 1];
		int[] b = new int[n];

		// count the number of occurrence
		for (int i = 0; i < a.length; ++i)
			c[a[i]]++;

		// Find rightmost position of each block of values
		for (int i = 1; i <= m; ++i)
			c[i] += c[i - 1];

		for (int i = a.length - 1; i >= 0; --i)
			b[--c[a[i]]] = a[i];

		return b;
	}

	public static void main(String[] args) {

		int[] a = { 3, 3, 0, 1, 4, 2, 4 };
		int[] result = countSort(a);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
