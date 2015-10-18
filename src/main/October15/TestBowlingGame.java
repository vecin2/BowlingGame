package main.October15;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


public class TestBowlingGame {

	private BowlingGame bowlingGame;
	@Before
	public void setUp() throws Exception {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void testGutterGame() {
		rollMany(0,20);
		assertEquals(0, bowlingGame.score());
	}

	@Test
	public void testAllOnes(){
		rollMany(1,20);
		assertEquals(20, bowlingGame.score());
	}
	@Test
	public void testSpare(){
		rollSpare();
		roll(3);
		rollMany(0, 13);
		assertEquals(16, bowlingGame.score());
	}
	@Test
	public void testStrike(){
		rollStrike();
		roll(3);
		roll(4);
		rollMany(0, 7);
		assertEquals(24, bowlingGame.score());
	}

	@Test
	public void perfectGame(){
		rollMany(10, 12);
		assertEquals(300, bowlingGame.score());
	}
	private void rollStrike() {
		roll(10);
	}

	private void roll(int pins) {
		bowlingGame.roll(pins);
	}

	private void rollSpare() {
		rollMany(5, 2);
	}
	
	private void rollMany(int pins, int times) {
		for(int i=0; i<times; i++){
			bowlingGame.roll(pins);
		}
	}

}
