// Advent of Code: Day 3 (Part 1)

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3P1 {
	public static void main(String[] args) throws Exception {

		// test data
		// String testdata = ""
		// 	vJrwpWtwJgWrhcsFMMfFFhFp
		// 	jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
		// 	PmmdzqPrVvPwwTWBwg
		// 	wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
		// 	ttgJtRGJQctTZtZT
		// 	CrZsJsPPZsGzwwsLwLmpwMDw
		// 	";

		// reading our file input
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		// score counter
		int score = 0;

		// initializing alphabet (adding 0 since 0th position is not interesting)
		String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// read each line
		String line;
		while((line = br.readLine()) != null) {
			// item array with a bunch of chars
			int[] chars = new int[line.length()];
			int i = 0;
			// split every char
			for(String e : line.split("")) {
				chars[i] = alphabet.indexOf(e);
				i++;
			}

			// first and second half of each array line (split into 2)
			int[] firstArray = Arrays.copyOfRange(chars, 0, chars.length / 2);
			int[] secondArray = Arrays.copyOfRange(chars, chars.length /2, chars.length);
		
			// used to add array of scores into one
			// only values that are unique- which is why a hashset is used
			Set<Integer> scores = new HashSet<>();

			for(int k = 0; k < firstArray.length; k++) {
				for(int j = 0; j < secondArray.length; j++) {
					if(firstArray[k] == secondArray[j]){
						// appending matched values into first array
						scores.add(firstArray[k]);
					}
				}
			}
			// bunch of ints in an array, reduces down into 1 int (sum)
			score += scores.stream().reduce((a, b) -> a + b).get(); 
		}
		// sum of priorities of item types
		System.out.println(score);
	}
}