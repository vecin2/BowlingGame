package main.Dec2013;
import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.core.IsNull;

public class Frame {
	private Integer firstThrow = null;
	private Integer secondThrow = null;
	private Shot firstShot;
	private Shot secondShot;

	private static int TOTAL_NUMBER_OF_PINS = 10;

	public Frame() {

	}

	public int score() {
		if (isCompleted())
			return firstThrow + secondThrow;
		else
			return 0;
	}

	public boolean isCompleted() {
		return (firstShot != null && secondShot != null) || isStrike();
	}

	public boolean isStrike() {
		return firstShot.isStrike();
	}

	public void addPins(int pins, int frameNumber) {
		if (firstShot == null) {
			if (frameNumber > 10)
				firstShot = new Shot(pins, false, true);
			else
				firstShot = new Shot(pins, false, false);
		} else if (secondShot == null) {
			if (firstShot.score() + pins == TOTAL_NUMBER_OF_PINS) {
				if (frameNumber > 10)
					secondShot = new Shot(pins, true, true);
				else
					secondShot = new Shot(pins, true, false);
			} else if (frameNumber > 10)
				secondShot = new Shot(pins, false, true);
			else
				secondShot = new Shot(pins, false, false);
		}

	}

	public ArrayList<Shot> getShots() {
		ArrayList<Shot> shotlist = new ArrayList<Shot>();
		if (firstShot != null)
			shotlist.add(this.firstShot);
		if (secondShot != null)
			shotlist.add(this.secondShot);
		return shotlist;
	}

}
