package com.program.searching;

public class BinarySearch {

	// using recursion
	public static int binarySearch(int arr[], int first, int last, int key) {
		if (first <= last) {
			int mid = (first + last) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				return binarySearch(arr, first, mid - 1, key);// search in left subarray
			} else {
				return binarySearch(arr, mid + 1, last, key);// search in right subarray
			}
		}
		return -1;
	}

	// using iteration
	public static int binarySearch1(int arr[], int first, int last, int key) {
		while (first <= last) {
			int mid = (first + last) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {

		// data must be sorted
		int arr[] = { 10, 20, 30, 40, 50 };
		int key = 40;
		int last = arr.length - 1;
		//recursion call
		int index = binarySearch(arr, 0, last, key);
		//iteration call
		//int index = binarySearch1(arr, 0, last, key);
		if (index == -1)
			System.out.println("Element " + key + " not found");
		else
			System.out.println("Element " + key + " found at " + (index + 1));
	}

}
