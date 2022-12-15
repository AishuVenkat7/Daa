package com.program.sorting;

public class SelectionSort {

	public static int[] selectionSort(int[] a) {
		int n = a.length;
		int i, j, minIndex = 0, temp = 0;
		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < n; j++) {
				if (a[j] < a[minIndex])
					minIndex = j;
			}
			temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int a[] = { 5, 1, 6, 2, 4, 3 };
		int[] result = selectionSort(a);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
