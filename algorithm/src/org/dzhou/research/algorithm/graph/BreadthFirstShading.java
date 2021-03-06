package org.dzhou.research.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DONG ZHOU
 */
public class BreadthFirstShading {

	private int[] row0 = { 1, 2, 1, 0, 0, 0, 0, 0, 2, 3 };
	private int[] row1 = { 3, 0, 2, 0, 1, 2, 1, 0, 1, 2 };
	private int[] row2 = { 4, 0, 1, 0, 1, 2, 3, 2, 0, 1 };
	private int[] row3 = { 3, 2, 0, 0, 0, 1, 2, 4, 0, 0 };
	private int[] row4 = { 0, 0, 0, 0, 0, 0, 1, 5, 3, 0 };
	private int[] row5 = { 0, 1, 2, 1, 0, 1, 5, 4, 3, 0 };
	private int[] row6 = { 0, 1, 2, 3, 1, 3, 6, 2, 1, 0 };
	private int[] row7 = { 0, 0, 3, 4, 8, 9, 7, 5, 0, 0 };
	private int[] row8 = { 0, 0, 0, 3, 7, 8, 6, 0, 1, 2 };
	private int[] row9 = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 };

	private int[][] map = { row0, row1, row2, row3, row4, row5, row6, row7,
			row8, row9 };

	private final int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private int rows;
	private int cols;
	private int[][] book;

	private void initBook() {
		book = new int[rows][];
		for (int i = 0; i < map.length; i++)
			book[i] = map[i].clone();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				book[i][j] = 0;
	}

	public BreadthFirstShading() {
		rows = map.length;
		cols = map[0].length;
		initBook();
	}

	public class Note {
		int row, col;

		public Note(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public Queue<Note> queue = new LinkedList<>();

	public void execute() {
		queue.add(firstNote);
		book(firstNote);
		sum = 1;
		while (queue.isEmpty() == false) {
			for (int i = 0; i < next.length; i++) {
				Note note = queue.peek();
				int nextRow = note.row + next[i][0];
				int nextCol = note.col + next[i][1];
				if (isOutOfMap(nextRow, nextCol))
					continue;
				if (isInvalid(nextRow, nextCol))
					continue;
				if (isBooked(nextRow, nextCol))
					continue;
				queue.add(new Note(nextRow, nextCol));
				book(nextRow, nextCol);
				sum++;
			}
			queue.remove();
		}
	}

	private Note firstNote = new Note(5, 7);
	public int sum;

	private void book(Note note) {
		book(note.row, note.col);
	}

	private void book(int nextRow, int nextCol) {
		book[nextRow][nextCol] = 1;
	}

	private boolean isOutOfMap(int nextRow, int nextCol) {
		return nextRow < 0 || nextRow > rows - 1 || nextCol < 0
				|| nextCol > cols - 1;
	}

	private boolean isBooked(int nextRow, int nextCol) {
		return book[nextRow][nextCol] == 1;
	}

	private boolean isInvalid(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 0;
	}

	public static void main(String[] args) {
		BreadthFirstShading instance = new BreadthFirstShading();
		instance.execute();
		System.out.println(instance.sum);
	}

}