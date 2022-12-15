package com.program.greedy;

import java.util.ArrayList;

public class CoinChange {

	static int denominations[] = { 1, 5, 10, 25 };

	static int n = denominations.length;

	static ArrayList<Integer> minCoin(int num) {
		ArrayList<Integer> coinDenom = new ArrayList<Integer>();

		// Traverse through all denominations
		for (int i = n - 1; i >= 0; i--) {
			while (num >= denominations[i]) {
				num -= denominations[i];
				coinDenom.add(denominations[i]);
			}
		}
		return coinDenom;
	}

	public static void main(String[] args) {
		int n = 68;
		ArrayList<Integer> coinDenom = minCoin(n);
		System.out.println("minimum number of coins needed" + coinDenom.size());
		for (int i : coinDenom)
			System.out.print(i + " ");
	}

}
