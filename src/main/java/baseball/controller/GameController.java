package baseball.controller;

import static baseball.constant.GameState.*;
import static baseball.model.Umpire.*;
import static baseball.view.ConsoleOutput.*;
import static baseball.view.InputConsole.*;
import static baseball.view.UmpireConsole.*;
import static nextstep.utils.Console.*;

import baseball.constant.GameState;
import baseball.exception.PitchException;
import baseball.model.BallZone;
import baseball.model.PitchBalls;
import baseball.model.Umpire;

public class GameController {

	public static void start() {
		GameState gameState = CONTINUE;

		while (gameState.equals(CONTINUE)) {
			playBall();
			gameState = checkContinueGame();
		}
	}

	private static void playBall() {
		BallZone ballZone = new BallZone();
		startRound(ballZone);
	}

	private static void startRound(BallZone ballZone) {
		PitchBalls pitchBalls = setPitchBalls();
		Umpire umpireResults = umpire(pitchBalls, ballZone);

		if (checkContinuePitch(umpireResults)) {
			printSuccessGame();
			printMessageForRestart();
			return;
		}

		startRound(ballZone);
	}

	private static PitchBalls setPitchBalls() {
		PitchBalls pitchBalls;
		try {
			printMessageForWaitingInput();
			pitchBalls = new PitchBalls(readLine());
		} catch (PitchException e) {
			printlnMessage(e.getMessage());
			return setPitchBalls();
		}
		return pitchBalls;
	}

	private static Umpire umpire(PitchBalls pitchBalls, BallZone ballZone) {
		Umpire result = new Umpire(pitchBalls, ballZone);
		printUmpireResult(result);
		return result;
	}

	public static GameState checkContinueGame() {
		// TODO : 사용자 입력 받아서 RESTART 여부 리턴

		return CONTINUE;
	}
}
