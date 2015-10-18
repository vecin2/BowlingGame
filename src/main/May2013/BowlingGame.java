package main.May2013;
import java.util.ArrayList;

public class BowlingGame {
	private ArrayList<Frame> frames = null;
 
	public void roll(int pins) {
		if (frames == null)
			this.initFrames();
		if (this.getCurrentFrame().isComplete())
			this.addNewFrame();
		this.getCurrentFrame().addThrow(pins);
	}

	private void initFrames() {
		this.frames = new ArrayList<Frame>();
		this.frames.add(new Frame());

	}

	private void addNewFrame() {
		this.frames.add(new Frame(this.getCurrentFrame()));
	}

	private Frame getCurrentFrame() {
		return (frames.isEmpty()) ? null : frames.get(frames.size() - 1);
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < frames.size(); i++) {
			score += frames.get(i).score();
		}
		return score;
		/*
		 * if ((previousFrame != null && previousFrame.isSpare()) ||
		 * (previousFrame != null && previousFrame.isStrike())) pins *= 2; if
		 * (previousFrame != null && previousFrame.isStrike()) pins *= 2;
		 */
	}

}
