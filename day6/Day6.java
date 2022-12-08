// Advent of Code: Day 6 (Part 1 and 2)

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {
	public static void main(String[] args) throws Exception {

		// test data
		String testdata = """ 
		mjqjpqmgbljsphdztnvjfqwrcgsmlb
		bvwbjplbgvbhsrlpgdmjqwftvncz
		nppdvjthqldpwncqszvftbrmjlhg
		nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg
		zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw
		""";

		// reading our file input
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		String line;
		while ((line = br.readLine()) != null) {
		// used for testdata (match results to prompt)
		// for (String line : testdata.split("\n")) {
			// took in all the characters
			String[] characters = line.split("");

			// created a buffer that is a list
			List<String> buffer = new ArrayList<>();

			int index = 0;
			// go through each character
			for (String s : characters) {
				// if the list is larger than 3
				if(buffer.size() > 3) {
				// PART 2: if(buffer.size() > 13) {
					// creating a hashset with buffer
					if(buffer.size() == new HashSet<>(buffer).size()) {
						break;
					}		
					buffer.add(s);
					buffer.remove(0);		
				} else {
					// add them to the list
					buffer.add(s);
				}	
				// increase the index
				index++;
			}
			System.out.println("Number of characters processed before the first start-of-packet marker detection: " + index);
			// PART 2: System.out.println("Number of characters processed before the first start-of-message marker detection: " + index);
		}	
	}
}