package main.May2013;
public class Frame {
	private Integer firstTrowed;
	private Integer secondTrowed;
	private Frame previousFrame;
	private static int ALL_PINS = 10;

	public Frame(Frame frame) {
		this.previousFrame = frame;
	}

	public Frame() {
	}

	public int score() {
		int score = 0;
		if (this.firstTrowed != null) {
			if (previousFrame != null
					&& (previousFrame.isStrike() || previousFrame.isSpare())) {
				score = this.firstTrowed * 2;
			} else {
				score = this.firstTrowed;
			}
		}
		if (this.secondTrowed != null) {
			if (previousFrame != null && previousFrame.isStrike()) {
				score += this.secondTrowed * 2;
			} else {
				score += this.secondTrowed;
			}
		}
		return score;
	}

	public Boolean isSpare() {
		return this.firstTrowed != null && this.secondTrowed != null
				&& this.firstTrowed + this.secondTrowed == ALL_PINS;
	}

	public boolean isComplete() {
		return this.secondTrowed != null || this.isStrike();
	}

	public boolean isStrike() {
		return this.firstTrowed != null && this.firstTrowed == ALL_PINS;
	}

	public void addThrow(int pins) {
		if (firstTrowed == null) {
			this.firstTrowed = pins;
		} else {
			this.secondTrowed = pins;
		}
	}

}
