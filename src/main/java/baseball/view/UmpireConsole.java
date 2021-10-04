package baseball.view;

import static baseball.view.ConsoleOutput.*;

import baseball.model.Umpire;

public class UmpireConsole {
	private static final String STRIKE_STRING = "스트라이크";
	private static final String BALL_STRING = "볼";
	private static final String NOTHING_STRING = "낫싱";

	private static final String SUCCESS_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

	public static void printUmpireResult(Umpire umpire) {
		String umpireResult = getMessage(umpire);
		printlnMessage(umpireResult);
	}

	public static void printSuccessGame() {
		printlnMessage(SUCCESS_GAME);
	}

	private static String getMessage(Umpire umpire) {
		if (umpire.getStrikeCount() == 0 && umpire.getBallCount() == 0) {
			return NOTHING_STRING;
		}

		return getHitMessage(umpire);
	}

	private static String getHitMessage(Umpire umpire) {
		String result = "";
		if (umpire.getStrikeCount() > 0) {
			result += umpire.getStrikeCount() + STRIKE_STRING + " ";
		}
		if (umpire.getBallCount() > 0) {
			result += umpire.getBallCount() + BALL_STRING;
		}
		return result;
	}
}
