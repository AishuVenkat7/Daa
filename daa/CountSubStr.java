package com.program.daa;

public class CountSubStr {
	static int countSubstr(String str, int n, char x, char y) {

		int tot_count = 0;
		int count_x = 0;

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == x) {
				count_x++;
			}
			if (str.charAt(i) == y) {
				tot_count += count_x;
			}
		}
		return tot_count;
	}

	static int[] countSubstrDiv(String str, int low, int high, char x, char y) {
		int count[] = { 0, 0, 0 };
		int startSeen = 0;
		int endSeen = 0;
		int total = 0;

		assert(low <= high);
		
		if (low == high) {

			if (str.charAt(low) == x) {
				startSeen++;
				count[0] = startSeen;
			}
			if (str.charAt(low) == y) {
				endSeen++;
				count[1] = endSeen;
				total += count[0];
				count[2] = total;
			}

			return count;
		}
		

		int mid = (low + high) / 2;
		int count_left[] = countSubstrDiv(str, low, mid, x, y);
		int count_right[] = countSubstrDiv(str, mid + 1, high, x, y);
		count= merge(count_left,count_right);
		return count;
	}
	

	private static int[] merge(int[] count_left, int[] count_right) {
		// TODO Auto-generated method stub
		int count[] = {0, 0, 0};
		count[2] = count_left[2] + count_right[2];
		count[2] += count_left[0] * count_right[1];
		count[0] = count_left[0] + count_right[0];
		count[1] = count_left[1] + count_right[1];
		return count;
	}

	static int[] recCountSubstr(String str, char x, char y) {

		// Declare local vars. count records eseen, total
		//
		int count[] = { 0, 0 };
		int endSeen = 0;
		int total = 0;

		// Base case
		//
		if (str.length() == 1) {
			if (str.charAt(0) == y) {
				++endSeen;
				count[0] = endSeen;
			}

			if (str.charAt(0) == x) {
				total += count[0];
				count[1] = total;
			}
			return count;
		}

		// Recursive loop
		//
		char pivot = str.charAt(0);
		str = str.substring(1);
		count = recCountSubstr(str, x, y);

		if (pivot == y) {
			++endSeen;
			count[0] = count[0] + endSeen;
		}

		// Look at pivot now
		//
		if (pivot == x) {
			total += count[0];
			count[1] = count[1] + total;
		}

		return count;
	}
	
	
	
	static int countSubstr1(String str, int n, char x, char y) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == x) {
				if (x == y)
					count++;
				for (int j = i + 1; j < n; j++) {
					if (str.charAt(j) == y) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		String str = "abacda";
		int n = str.length();
		char x = 'a', y = 'a';
		//exhaustive search
		System.out.println("Count = " + countSubstr1(str, n, x, y));
		
		//decrease and conquer
		int count[] = recCountSubstr(str, x, y);
		System.out.println("total = " + count[1]);
		
		//divide and conquer
		int divCount[] = countSubstrDiv(str,0,n-1, x, y);
		System.out.println("Count div= " + divCount[2]);
	}
}

