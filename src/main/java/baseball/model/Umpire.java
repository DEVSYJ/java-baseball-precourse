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

	public Umpire(PitchBalls pitchBalls, BallZone ballZone) {
		// TODO : 사용자가 입력한 숫자에 대한 결과 출력

		for (int umpireIndex = 0; umpireIndex < umpireResults.length; umpireIndex++) {
			this.umpireResults[umpireIndex] = umpire(umpireIndex, pitchBalls.getPitchBalls(),
				ballZone.getStrikeZones());
		}
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

	public static boolean checkContinuePitch(UmpireState[] umpireResults) {
		// TODO : 다 맞으면 게임 종료
		return true;
	}

}
