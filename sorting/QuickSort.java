package com.program.sorting;

public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {

		if (low >= high)
			return;
		int p = partition(a, low, high);
		quickSort(a, low, p - 1);
		quickSort(a, p + 1, high);
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {

			// If current element is smaller than the pivot
			if (arr[j] < pivot) {
				// Increment index of smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int a[] = { 38, 27, 43, 3, 9, 82, 10 };
		quickSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
