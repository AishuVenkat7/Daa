package com.program.searching;

public class LinearSearch {

	public static int linearSearch(int a[], int target) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int a[] = { 3, -5, 9, 10, 92, 77, 90 };
		int target = 90;
		int index = linearSearch(a, target);
		if (index == -1)
			System.out.println("Element " + target + " not found");
		else
			System.out.println("Element " + target + " found at " + (index + 1));

	}

}
