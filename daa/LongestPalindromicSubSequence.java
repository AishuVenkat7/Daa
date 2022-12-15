package com.program.daa;

public class LongestPalindromicSubSequence {

	public static int getLongestPalindromicSubSequenceSize(String source) {
		int n = source.length();
		int[][] LP = new int[n][n];

		// All sub strings with single character will be a plindrome of size 1
		for (int i = 0; i < n; i++) {
			LP[i][i] = 1;
		}
		// Here gap represents gap between i and j.
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0; i < n - gap; i++) {
				int j = i + gap;
				if (source.charAt(i) == source.charAt(j) && gap == 1)
					LP[i][j] = 2;
				else if (source.charAt(i) == source.charAt(j))
					LP[i][j] = LP[i + 1][j - 1] + 2;
				else
					LP[i][j] = Math.max(LP[i][j - 1], LP[i + 1][j]);
			}
		}
		return LP[0][n - 1];
	}

	/**
	 * To find longest palindrome sub-sequence It has time complexity O(N^2)
	 *
	 * @param input
	 * @return String
	 */
	public static String getLongestPalindromicSubSequence(String input) {
		int n = input.length();
		int[][] palindromeMatrix = new int[n][n];

		// All sub strings with single character will be a palindrome of size 1
		for (int i = 0; i < n; i++) {
			palindromeMatrix[i][i] = 1;
		}
		// Here gap represents gap between i and j.
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0; i < n - gap; i++) {
				int j = i + gap;
				if (input.charAt(i) == input.charAt(j) && gap == 1)
					palindromeMatrix[i][j] = 2;
				else if (input.charAt(i) == input.charAt(j))
					palindromeMatrix[i][j] = palindromeMatrix[i + 1][j - 1] + 2;
				else
					palindromeMatrix[i][j] = Math.max(palindromeMatrix[i][j - 1], palindromeMatrix[i + 1][j]);
			}
		}
		
		
		// Rebuilding string from palindrome matrix
		StringBuilder strBld = new StringBuilder();
		int x = 0;
		int y = n - 1;
		while (x < y) {
			if (input.charAt(x) == input.charAt(y)) {
				strBld.append(input.charAt(x));
				x++;
				y--;
			} else if (palindromeMatrix[x][y - 1] > palindromeMatrix[x + 1][y]) {
				y--;
			} else {
				x++;
			}
		}
		StringBuilder strBldCopy = new StringBuilder(strBld);
		if (x == y) {
			strBld.append(input.charAt(x)).append(strBldCopy.reverse());
		} else {
			strBld.append(strBldCopy.reverse());
		}
		return strBld.toString();
	}
	
	//using professors notes
	public static int getPalindromicSubSequenceSize(String s) {
		
		int n = s.length();
		int dp[][]= new int[n+1][n+1];
        int l;
        
        if(n==0)
            return 0;
        
        for(int i=0; i<=n; i++)
            dp[i][i] = 1;
        
        for(int i=2; i<=n; i++) {
            for(int j=0; j<(n-i+1); j++) {
                l = i+j-1;
                if(i==2 && s.charAt(j) == s.charAt(l))
                    dp[j][l] = 2;
                else if(s.charAt(j) == s.charAt(l))
                    dp[j][l] = dp[j+1][l-1]+2;
                else
                    dp[j][l] = Math.max(dp[j+1][l], dp[j][l-1]);
            }
        }
        return dp[0][n-1];
	}

	public static void main(String[] args) {
		 System.out.println("form first "+getLongestPalindromicSubSequenceSize("character"));
		//System.out.println(getLongestPalindromicSubSequence("character"));
		System.out.println("from second "+getPalindromicSubSequenceSize("character"));
	}

}

