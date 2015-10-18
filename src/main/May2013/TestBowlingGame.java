package main.May2013;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowlingGame {
	BowlingGame bowlingGame;
	int rolls;
	int pins;

	@Before
	public void setup() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void gutterGameScoresZero() {
		rollMany(20, 0);
		assertEquals(0, bowlingGame.score());
	}

	@Test
	public void allOnesScoresTwenty() {
		rollMany(20, 1);
		assertEquals(20, bowlingGame.score());
	}

	@Test
	public void spareFollowedByThreePinsThenAllMissed_scores16() {
		rollMany(2, 5);
		bowlingGame.roll(3);
		rollMany(18, 0);
		assertEquals(9/2, bowlingGame.score());
	}
@Test
 public void strikeFollowedByThreeThenfourpinsThenAllmisses_scores24(){
	bowlingGame.roll(10);
	bowlingGame.roll(3);
	bowlingGame.roll(4);
	rollMany(14, 0);
	assertEquals(24, bowlingGame.score());
}
@Test
public void twelveStrikes_scores300(){
	rollMany(12, 10);
	assertEquals(300, bowlingGame.score());

}
	 
	private void rollMany(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			bowlingGame.roll(pins);
		}
	}
}
