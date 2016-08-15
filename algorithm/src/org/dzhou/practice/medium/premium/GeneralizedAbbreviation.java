package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example:
 * 
 * Given word = "word", return the following list (order does not matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * @author zhoudong
 *
 */
public class GeneralizedAbbreviation {

	public class Solution {

		public List<String> generateAbbreviations(String word) {
			if (word == null || word.length() == 0)
				return Collections.emptyList();

			List<String> result = new ArrayList<>();

			return result;
		}

	}

}