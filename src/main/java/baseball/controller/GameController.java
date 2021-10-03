package baseball.controller;

import static baseball.constant.GameState.*;
import static baseball.model.Umpire.*;

import baseball.constant.GameState;
import baseball.model.Pitcher;
import baseball.model.StrikeZone;
import baseball.model.Umpire;

public class GameController {

	public static void start() {
		GameState gameState = CONTINUE;

		while (gameState.equals(CONTINUE)) {
			StrikeZone strikeZone = new StrikeZone();
			playBall(strikeZone);
			gameState = checkContinueGame();
		}
	}

	private static void playBall(StrikeZone strikeZone) {
		Pitcher pitcher = new Pitcher();
		Umpire.UmpireResult umpireResult = umpire(pitcher.pitch(), strikeZone);
		while (!checkContinuePitch(umpireResult)) {
			playBall(strikeZone);
		}
	}

	public static GameState checkContinueGame() {
		// TODO : 사용자 입력 받아서 RESTART 여부 리턴

		return CONTINUE;
	}
}
