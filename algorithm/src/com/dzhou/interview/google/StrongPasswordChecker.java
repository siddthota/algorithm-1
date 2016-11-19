package com.dzhou.interview.google;

/**
 * 420. Strong Password Checker
 * 
 * Difficulty: Hard
 * 
 * A password is considered strong if below conditions are all met:
 * 
 * It has at least 6 characters and at most 20 characters.
 * 
 * It must contain at least one lowercase letter, at least one uppercase letter,
 * and at least one digit.
 * 
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak,
 * but "...aa...a..." is strong, assuming other conditions are met).
 * 
 * Write a function strongPasswordChecker(s), that takes a string s as input,
 * and return the MINIMUM change required to make s a strong password. If s is
 * already strong, return 0.
 * 
 * Insertion, deletion or replace of any one character are all considered as one
 * change.
 * 
 * @author zhoudong
 *
 */
public class StrongPasswordChecker {

	public int strongPasswordChecker(String s) {
		int res = 0, a = 1, A = 1, d = 1;
		char[] carr = s.toCharArray();
		int[] arr = new int[carr.length];

		for (int i = 0; i < arr.length;) {
			if (Character.isLowerCase(carr[i]))
				a = 0;
			if (Character.isUpperCase(carr[i]))
				A = 0;
			if (Character.isDigit(carr[i]))
				d = 0;

			int j = i;
			while (i < carr.length && carr[i] == carr[j])
				i++;
			arr[j] = i - j;
		}

		int total_missing = (a + A + d);

		if (arr.length < 6) {
			res += total_missing + Math.max(0, 6 - (arr.length + total_missing));

		} else {
			int over_len = Math.max(arr.length - 20, 0), left_over = 0;
			res += over_len;

			for (int k = 1; k < 3; k++) {
				for (int i = 0; i < arr.length && over_len > 0; i++) {
					if (arr[i] < 3 || arr[i] % 3 != (k - 1))
						continue;
					arr[i] -= Math.min(over_len, k);
					over_len -= k;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= 3 && over_len > 0) {
					int need = arr[i] - 2;
					arr[i] -= over_len;
					over_len -= need;
				}

				if (arr[i] >= 3)
					left_over += arr[i] / 3;
			}

			res += Math.max(total_missing, left_over);
		}

		return res;
	}

}
