package com.wagner.europace.bowling_game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingGameApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void scoreCalculatorTest() {
		ScoreCalculator calculator = new ScoreCalculator();
		assertEquals("Calculated score is 133", calculator.calc("1,4", "4,5", "6,4", "5,5", "10,0", "0,1", "7,3", "6,4", "10,0", "2,8,6"));
		assertEquals("Calculated score is 300", calculator.calc("10,0", "10,0", "10,0", "10,0", "10,0", "10,0", "10,0", "10,0", "10,0", "10,10,10"));
		assertEquals("Calculated score is 190", calculator.calc("9,1", "9,1", "9,1", "9,1", "9,1", "9,1", "9,1", "9,1", "9,1", "9,1,9"));
	}

}
