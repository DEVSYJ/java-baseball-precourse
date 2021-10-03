package baseball.model;

// 심판
public class Umpire {
	public static class UmpireResult {
		private Integer first;
		private Integer second;
		private Integer third;
	}

	public static UmpireResult umpire(PitchBalls pitchBalls, StrikeZone strikeZone) {
		// TODO : 사용자가 입력한 숫자에 대한 결과 출력
		return new UmpireResult();
	}

	public static boolean checkContinuePitch(UmpireResult umpireResult) {
		// TODO : 다 맞으면 게임 종료
		return true;
	}

}
