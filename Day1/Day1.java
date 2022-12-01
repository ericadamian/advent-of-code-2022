// Advent of Code: Day 1, Part 2

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
	public static void main(String[] args) throws Exception{

		// create a list for top 3 elves
		List<Integer> list = new ArrayList<>();

		// reading our file input
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		// calories variable acts as our pointer to compare with mostCalories
		int calories = 0;
		int mostCalories = 0;
		String line;

		// loop through each elf

		// checks the available values
		while((line = br.readLine()) != null) {
			// checks the omitted string
			String strCal = line.trim();
			// assigning mostCalories as greater value for elf
			if(strCal.isBlank()) {
				if(mostCalories < calories) {
					mostCalories = calories;
				}
				// adding our calories to our list
				list.add(calories);

				// remove prior calories and continue looping through each elf
				calories = 0;
				continue;
			}
			// continue looping to find mostCalories based on calories value
			calories += Integer.parseInt(strCal);
		}
		// outputting elf with most calories
		System.out.println("The elf with the most calories has " + mostCalories + " calories.");

		// sort with comparator (b - a for largest value first)
		list.sort((a, b) -> b - a);
		System.out.print("The top 3 elves carrying the most calories have ");
		System.out.print(list.get(0) + list.get(1) + list.get(2));
		System.out.println(" calories combined.");
	}
}