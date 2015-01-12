package org.dzhou.research.datastructure;

public class BinaryTree {

	private static int[] tree = null;
	private static int index = 0;

	public static void insert(int value) {
		tree[index] = value;
		recursiveSort(index);
		index++;
	}

	private static void recursiveSort(int childIndex) {
		if (isParentExist(childIndex) == false)
			return;
		if (parentValue(childIndex) >= tree[childIndex])
			return;
		swap(childIndex, parentIndex(childIndex));
		recursiveSort(parentIndex(childIndex));
	}

	private static boolean isParentExist(int childIndex) {
		if (parentIndex(childIndex) < 0)
			return false;
		else
			return true;
	}

	private static int parentValue(int childIndex) {
		return tree[parentIndex(childIndex)];
	}

	private static int parentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private static void swap(int i, int j) {
		int temp = tree[i];
		tree[i] = tree[j];
		tree[j] = temp;
	}

	private static void printTree() {
		for (int i : tree)
			System.out.println(i);
	}

	public static void main(String args[]) {
		int[] input = { 5, 6, 9, 13, 12, 26, 0, 3, 1, 8, 7, 2, 4 };
		tree = new int[input.length];
		for (int i : input)
			insert(i);
		printTree();
	}

}