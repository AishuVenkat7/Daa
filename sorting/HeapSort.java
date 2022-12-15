package com.program.sorting;

public class HeapSort {

	public static void heapify(int a[], int n, int i) {
		int temp = 0;
		while (i <= n) {
			int largest = i, lc = 2 * i, rc = lc + 1;
			if (lc < n && a[lc] > a[largest])
				largest = lc;
			if (rc < n && a[rc] > a[largest])
				largest = rc;
			if (largest == i)
				break;
			temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			i = largest;
		}
	}

	public static void makeheap(int a[], int n) {
		for (int i = (n / 2)-1; i >= 0; i--)
			heapify(a, n, i);
	}

	public static void heapSort(int a[], int n) {
		int temp = 0;
		makeheap(a, n);
		for (int i = n-1; i > 0; i--) {
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i , 0);
		}
	}

	public static void main(String[] args) {
		int a[] = { 7,5,8,4,6 };
		heapSort(a, a.length);
		for(int i: a)
			System.out.print(i+" ");

	}

}
