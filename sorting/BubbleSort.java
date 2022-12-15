package com.program.sorting;

public class BubbleSort {

	public static int[] bubbleSort(int a[]) {
		int n = a.length;
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag)
				break;
		}
		return a;
	}

	public static void main(String[] args) {

		int a[] = { 5, 1, 4, 2, 8 };
		int result[] = bubbleSort(a);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
