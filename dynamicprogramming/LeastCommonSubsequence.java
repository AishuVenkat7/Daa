package com.program.dynamicprogramming;

public class LeastCommonSubsequence {

	public static void leastCommonSubsequence(String s, String t) {
		int n = s.length(), m = t.length();
		int comSub[][] = new int[n + 1][m + 1];
		StringBuilder strBld = new StringBuilder();
		for (int j = 0; j <= m; ++j)
			comSub[0][j] = 0;
		for (int i = 0; i <= n; ++i)
			comSub[i][0] = 0;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					comSub[i][j] = 1 + comSub[i - 1][j - 1];
				else
					comSub[i][j] = Math.max(comSub[i - 1][j], comSub[i][j - 1]);
			}
		}
		System.out.println("least common subsequence length: " + comSub[n][m]);
		int i = n, j = m;
		while (i > 0 && j > 0) {
			if (s.charAt(i - 1) == t.charAt(j - 1)) {
				strBld.append(s.charAt(i - 1));
				i--;
				j--;
			} else if (comSub[i - 1][j] > comSub[i][j - 1])
				i--;
			else
				j--;

		}
		System.out.print("least common subsequence of " + s + " and " + t + " is " + strBld.reverse());
	}

	public static void main(String[] args) {

		leastCommonSubsequence("abcbdab", "bdcaba");
	}

}
