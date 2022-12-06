// Advent of Code: Day 4 (Part 1 and 2)

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
	public static void main(String[] args) throws Exception {

		// test data
		// String testdata = """
		// 2-4,6-8
		// 2-3,4-5
		// 5-7,7-9
		// 2-8,3-7
		// 6-6,4-6
		// 2-6,4-8
		// """;

		// reading our file input
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		// counter for fully contained (part 1) and overlapped values (total - no overlap: part 2)
		int count = 0;
		int no_overlap_count = 0;
		int total_count = 0;

		// reading through each line
		String line;
		while ((line = br.readLine()) != null) {
			// assignment for each array's range values
			String[] elfassign = line.split(",");
			String[] assign1 = elfassign[0].split("-");
			String[] assign2 = elfassign[1].split("-");
			int assign1low = Integer.parseInt(assign1[0]);
			int assign1high = Integer.parseInt(assign1[1]);
			int assign2low = Integer.parseInt(assign2[0]);
			int assign2high = Integer.parseInt(assign2[1]);

			// part 1: checking for pairs that are fully contained within the range
			if(assign1low <= assign2low && assign1high >= assign2high){
				count++;
			} else if(assign1low >= assign2low && assign1high <= assign2high){
				count++;
			}
			// part 2: checking for pairs that DON'T overlap
			if(assign1low > assign2high) {
				no_overlap_count++;
			} else if (assign2low > assign1high) {
				no_overlap_count++;
			}
			// subtract total pairs with pairs that DON'T overlap
			total_count++;
		}

		System.out.println("Total number of pairs: " + total_count);

		// part 1
		System.out.println("Number of pairs that fully overlap with their counterpart pairs: " + count);

		// non-overlap values
		System.out.println("Number of pairs that don't overlap their counterpart pairs: " + no_overlap_count);

		// part 2
		System.out.println("Number of pairs that partially-to-fully overlap with their counterpart pairs: " + (total_count - no_overlap_count));
	}
}