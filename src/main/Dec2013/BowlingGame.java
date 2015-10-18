package main.Dec2013;
import java.util.ArrayList;

public class BowlingGame {
	private int score = 0;
	private ArrayList<Frame> frames = new ArrayList<Frame>();


	public void roll(int pins) {
		saveShot(pins);

	}

	private void saveShot(int pins) {
		Shot lastShot = getLastShot();
		if (lastShot != null && (lastShot.isSpare() || lastShot.isStrike())) {
			getLastShot().addPoints(pins);
		}
		if (isSecondLastShotStrike()) {
			getSecondLastShot().addPoints(pins);
		}

		Frame currentFrame = obtainCurrentFrame();
		currentFrame.addPins(pins, frames.size());

	}

	private boolean isSecondLastShotStrike() {
		return getSecondLastShot() != null && getSecondLastShot().isStrike();
	}

	private Shot getSecondLastShot() {
		if (getShotsList().size() < 2)
			return null;
		else
			return getShotsList().get(getShotsList().size() - 2);
	}

	private Frame obtainCurrentFrame() {
		if (frames.isEmpty() || getCurrentFrame().isCompleted()) {
			addFrame(new Frame());
		}
		return getCurrentFrame();
	}

	private Frame getCurrentFrame() {
		if (frames.isEmpty()) {
			return null;
		}
		return frames.get(frames.size() - 1);
	}

	private Shot getLastShot() {
		if (getShotsList().isEmpty())
			return null;
		return getShotsList().get(getShotsList().size() - 1);
	}

	private void addFrame(Frame frame) {
		frames.add(frame);
	}

	public int score() {
		for (Shot shot : getShotsList()) {
			if (!shot.isExtraShot())
				score += shot.score();
		}
		return score;

	}

	private ArrayList<Shot> getShotsList() {
		ArrayList<Shot> shotList = new ArrayList<Shot>();
		for (Frame frame : frames) {
			shotList.addAll(frame.getShots());
		}
		return shotList;
	}

	public int scoreFrame(int frameNumber) {
		return frames.get(frameNumber - 1).score();
	}

	public Object currentNumberOfFramesPlayed() {
		return frames.size();
	}
}
