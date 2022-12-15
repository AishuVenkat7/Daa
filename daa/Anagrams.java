package com.program.daa;

import java.util.Arrays;
import java.util.HashSet;

public class Anagrams {

	public static void findAllAnagrams(String[] arr, int n) {
		String[][] str = new String[n][2];
		for (int i = 0; i < n; i++) {
			str[i][0] = arr[i];
			str[i][1] = sortString(arr[i]);
		}

		String temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// to compare one string with other strings
				if (str[i][1].compareTo(str[j][1]) > 0) {
					// swapping
					temp = str[i][1];
					str[i][1] = str[j][1];
					str[j][1] = temp;

					temp = str[i][0];
					str[i][0] = str[j][0];
					str[j][0] = temp;
				}
			}
		}

		HashSet<HashSet<String>> ans = new HashSet<HashSet<String>>();
		HashSet<String> a = new HashSet<String>();
		a.add(str[0][0]);
		for (int i = 1; i < n; ++i) {
			if (str[i][1].equalsIgnoreCase(str[i - 1][1]))
				a.add(str[i][0]);
			else {
				ans.add(a);
				a = new HashSet<String>();
				a.add(str[i][0]);
			}
		}
		ans.add(a);

		for (HashSet<String> s : ans) {
			System.out.print("Anagrams are: ");
			for (String rs : s) {
				System.out.print(rs + " ");
			}
			System.out.println();
		}
	}

	public static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	public static void main(String[] args) {

		String arr[] = { "art", "apt", "rat", "tap", "tar" };
		int n = arr.length;
		findAllAnagrams(arr, n);
	}

}
