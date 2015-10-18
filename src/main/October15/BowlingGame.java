package main.October15;
import java.util.ArrayList;

public class BowlingGame {

	private ArrayList<Integer> rolls = new ArrayList<Integer>();

	public void roll(int pins) {
		rolls.add(pins);

	}

	public int score() {
		int result = 0;
		int i = 0;
		while (i < rolls.size() - 1) {
			if (isSpare(i)){
				result += frameScore(i) + rolls.get(i+2);
				i = i + 2;
			}
			else if (isStrike(i)){
				result += rolls.get(i); 
				 if(i+1<=10)
					 result += rolls.get(i+1); 
			     if(i+2<=10)
			    	 result += rolls.get(i+2);
				i++;
			}
			
			else {
				result += frameScore(i);
				i = i + 2;
			}

		}
		return result;
	}

	private boolean isStrike(int i) {
		return rolls.get(i)==10;
	}

	private Integer frameScore(int i) {
		return rolls.get(i) + rolls.get(i+1);
	}

	private boolean isSpare(int i) {
		return rolls.get(i) + rolls.get(i + 1) == 10;
	}

}
// [5 5] [3 0] [0 0] ...0 0 0 0
// 16
// [10] [10] [10] [10]
// 10 20 20 20
// 10 10 10 10 10 10 10 10 10 10 10 10 
//   30 30 30 30 30 30 30 30 20 10 10 10 
   
//spare en la decima
