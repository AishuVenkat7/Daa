package com.program.sorting;

public class InsertionSort {

	public static int[] insertionSort(int a[]) {
		int n = a.length;
		int temp = 0, i, j;
		for (i = 1; i < n; i++) {
			j = i;
			while (j > 0 && a[j - 1] > a[j]) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				j--;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int a[] = { 5, 1, 6, 2, 4, 3 };
		int[] result = insertionSort(a);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
