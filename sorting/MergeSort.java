package com.program.sorting;

public class MergeSort {

	public static void mergeSort(int[] a, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(a, low, mid);
		mergeSort(a, mid + 1, high);
		merge(a, low, mid, high);

	}

	private static void merge(int[] a, int low, int mid, int high) {
		int n = high - low + 1;
		int i = low, j = mid + 1;
		int b[] = new int[n];
		int k = 0;
		for (k = 0; k < n; k++) {
			if (j > high)
				b[k] = a[i++];
			else if (i > mid)
				b[k] = a[j++];
			else
				b[k] = (a[i] < a[j]) ? a[i++] : a[j++];
		}
		// copying back from array b to array a
		for (i = high; i >= low; i--)
			a[i] = b[--k];

	}

	public static void main(String[] args) {

		int a[] = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

}
