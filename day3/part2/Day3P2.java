// Advent of Code: Day 3 (Part 2)

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3P2 {
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

		// initializing alphabet (adding 0 since 0th position for proper index)
		String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// approach: arraylist of hashsets
		List<Set<Integer>> lists = new ArrayList<>();

		// add 3 hashsets for 3 elves into arraylist (unique values for different lists)
		lists.add(new HashSet<>());
		lists.add(new HashSet<>());
		lists.add(new HashSet<>());

		// keeps track of which list we want to add things to
		int listIdx = 0;

		String line;
		// reader logic
		while((line = br.readLine()) != null) {
			for(String e : line.split("")) {
				// look up alphabet index and store into currently working list (for each string)
				lists.get(listIdx).add(alphabet.indexOf(e));
			}
			// increment list index and ensure we have 3 lists
			listIdx++;
			if (listIdx < 3) {
				continue;
			}
			// this will "retain all" values that are not in get(x)'s set
			lists.get(0).retainAll(lists.get(1));
            lists.get(0).retainAll(lists.get(2));

    		// now the list will have the unique values between the 2 lists
            // reduce that to 1 score and add it up
            score += lists.get(0).stream().reduce((a, b) -> a + b).get();

            // cleanup: create a new list and new hashsets; set list index to 0
            lists = new ArrayList<>();
            lists.add(new HashSet<>());
            lists.add(new HashSet<>());
            lists.add(new HashSet<>());
            listIdx = 0;

            // after, we will read the next line
		}
		// sum of priorities of item types
		System.out.println(score);
	}
}