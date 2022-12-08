// Advent of Code: Day 2 (Part 1 and 2)

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

	// declaring final score variables rock/paper/scissors and loss/draw/win
	static final int rock = 1;
	static final int paper = 2;
	static final int scissors = 3;

	static final int loss = 0;
	static final int draw = 3;
	static final int win = 6;

	public static void main(String[] args) throws Exception {
		// mapping our values for rock, paper, and scissors
		Map<String, Integer> shapes = new HashMap<>();
		// opponent's play (based on input)
		shapes.put("A", rock);
		shapes.put("B", paper);
		shapes.put("C", scissors);

		// your play (based on input)
		shapes.put("X", rock);
		shapes.put("Y", paper);
		shapes.put("Z", scissors);

		// test data
		String testdata = """
		A Y
		B X
		C Z
		""";

		// reading our file input
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		// Part 1: your added final counter score based on input
		int score = 0;

		// Part 2: your predicion score counter
		int predscore = 0;

		String line;
		while ((line = br.readLine()) != null) {
		// for (String line : testdata.split("\n")) {
			String[] match = line.trim().split(" ");

			// handling empty row at end
			if(match.length != 2) {
				continue;
			}

			// match[0] is the opponent
			// match[1] is you

			// draw
			if (shapes.get(match[0]) == shapes.get(match[1])) {
				score += draw;
			// win
			} else if (shapes.get(match[0]) == rock && shapes.get(match[1]) == paper) {
				score += win;
			// win
			} else if (shapes.get(match[0]) == paper && shapes.get(match[1]) == scissors) {
				score += win;
			// win
			} else if (shapes.get(match[0]) == scissors && shapes.get(match[1]) == rock) {
				score += win;
			// lose
			} else {
				score += loss;
			}

			// adding up your score
			score += shapes.get(match[1]);

			// calculating the prediction score
			// for Part 2, X means you lose, Y means draw, and Z means you win
			// using match[0] to match your results against opponents

			// X means that you lose
			if(match[1].equals("X")) {
				predscore += loss;

				// you want it to predict a loss
				if(shapes.get(match[0]) == rock) {
					predscore += scissors;
				}
				if(shapes.get(match[0]) == paper) {
					predscore += rock;
				}
				if(shapes.get(match[0]) == scissors) {
					predscore += paper;
				}
			}

			// Y means there is a draw
			if(match[1].equals("Y")) {
				predscore += draw;
				predscore += shapes.get(match[0]);
			}

			// Z means that you win
			if(match[1].equals("Z")) {
				predscore += win;

				// you want to predict a win
				if(shapes.get(match[0]) == rock) {
					predscore += paper;
				}
				if(shapes.get(match[0]) == paper) {
					predscore += scissors;
				}
				if(shapes.get(match[0]) == scissors) {
					predscore += rock;
				}
			}
		}

		System.out.println("Your total score based on your strategy guide: " + score);
		System.out.println("Your total score based on the elf's instructions: " + predscore);
	}
}