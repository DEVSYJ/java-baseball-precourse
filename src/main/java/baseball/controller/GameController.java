package baseball.controller;

import static baseball.constant.GameState.*;

import baseball.constant.GameState;
import baseball.model.StrikeZone;

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
		// TODO : 사용자 입력 받기

		// TODO : 결과 출력

		// TODO : 맞으면 STOP 틀리면 재진행
	}

	public static GameState checkContinueGame() {
		// TODO : 사용자 입력 받아서 RESTART 여부 리턴

		return CONTINUE;
	}
}
