package org.dzhou.research.algorithm;

/**
 * @author DONG ZHOU
 */
public class FindSmallestNumber {

	private int[] array = { -1, 1, 3, 5, 6, 9, 10, 45, 28, 6 };

	public int execute() {
		int result = array[0];
		for (int i : array)
			if (i < result)
				result = i;
		return result;
	}

	public static void main(String[] args) {
		FindSmallestNumber instance = new FindSmallestNumber();
		System.out.println(instance.execute());
	}

}