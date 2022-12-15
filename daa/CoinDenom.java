package com.program.daa;

public class CoinDenom {
	
	static String isDiv(int[] denomination, int[] noOfCoins) {
		int totalAmount = 0;
		// calculating the total amount
		for (int i = 0; i < denomination.length; i++) {
			totalAmount += (noOfCoins[i] * denomination[i]);
		}
		// dividing the the amount into half
		int oneHalf = totalAmount / 2;
		System.out.println(oneHalf);
		int k = denomination.length - 1;
		// calculating the number of coins required for half the amount
		while (k >= 0 && oneHalf >= 0) {
			if (noOfCoins[k] != 0 && denomination[k] <= oneHalf) {
				oneHalf -= denomination[k];
				noOfCoins[k]--;
			} else {
				k--;
			}
		}
		System.out.println(oneHalf);
		int anotherHalf = 0;
		// calculating the remaining amount using number of coins left
		for (int i = 0; i < denomination.length; i++) {
			anotherHalf += (noOfCoins[i] * denomination[i]);
		}
		System.out.println(anotherHalf);
		// checking if the divided amount is equal
		if ((totalAmount / 2) == anotherHalf) {
			System.out.println("amount can be divided equally");
			return "yes";
		}
		return "no";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// denomination -x,y
		int[] denomination = { 2, 5};
		// number of coins in each denomination - nx,ny
		int[] noOfCoins = { 2, 2 };
		String result = isDiv(denomination, noOfCoins);
		System.out.println(result);

	}

}
