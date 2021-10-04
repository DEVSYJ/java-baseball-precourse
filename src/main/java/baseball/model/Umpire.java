package baseball.model;

import static baseball.constant.UmpireState.*;

import baseball.constant.UmpireState;
import lombok.Getter;
import lombok.ToString;

// 심판
@Getter
@ToString
public class Umpire {
	private UmpireState[] umpireResults = new UmpireState[3];
	private int strikeCount;
	private int ballCount;

	public Umpire(PitchBalls pitchBalls, BallZone ballZone) {
		for (int umpireIndex = 0; umpireIndex < umpireResults.length; umpireIndex++) {
			this.umpireResults[umpireIndex] = umpire(umpireIndex, pitchBalls.getPitchBalls(),
				ballZone.getStrikeZones());
		}

		setUmpireTotal(this.umpireResults);
	}

	private UmpireState umpire(int umpireIndex, Integer[] pitchBalls, Integer[] ballZone) {
		if (pitchBalls[umpireIndex].equals(ballZone[umpireIndex])) {
			return STRIKE;
		}

		UmpireState result = NOTHING;
		for (int ballZoneIndex = 0; ballZoneIndex < ballZone.length && result != BALL; ballZoneIndex++) {
			result = checkBallZone(umpireIndex, ballZoneIndex, pitchBalls, ballZone);
		}
		return result;
	}

	private UmpireState checkBallZone(int umpireIndex, int strikeZoneIndex, Integer[] pitchBalls, Integer[] ballZone) {
		if (pitchBalls[umpireIndex].equals(ballZone[strikeZoneIndex])) {
			return BALL;
		}
		return NOTHING;
	}

	private void setUmpireTotal(UmpireState[] umpireResults) {
		for (int i = 0; i < umpireResults.length; i++) {
			countingResult(umpireResults[i]);
		}
	}

	private void countingResult(UmpireState umpireResult) {
		if (umpireResult.equals(STRIKE)) {
			this.strikeCount++;
			return;
		}
		if (umpireResult.equals(BALL)) {
			this.ballCount++;
		}
	}

	public static boolean checkContinuePitch(Umpire umpire) {
		return umpire.getStrikeCount() == 3;
	}

}
