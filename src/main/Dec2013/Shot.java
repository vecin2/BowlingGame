package main.Dec2013;

public class Shot {

	private int pins;
	private boolean isSpare;
	private static int TOTAL_NUMBER_OF_PINS =10;
	private int points;
	private Boolean isExtraShot;
	public Shot(int pins) {
		this.pins = pins;
		this.points = pins;
		this.isExtraShot = false;
	}

	public Shot(int pins, boolean isSpare, boolean isExtraShot) {
		this.pins = pins;
		this.points = pins;
		this.isSpare = isSpare;
		this.isExtraShot = isExtraShot;
	}

	public int score() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
		
	}

	public boolean isSpare() {
		return isSpare;
	}

	public boolean isStrike() {
		return pins == TOTAL_NUMBER_OF_PINS;
	}

	public boolean isExtraShot() {
		// TODO Auto-generated method stub
		return isExtraShot;
	}
	

}
