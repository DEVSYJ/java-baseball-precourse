package baseball.controller;

import static baseball.constant.GameState.*;
import static baseball.exception.ErrorMessage.*;
import static baseball.model.Umpire.*;
import static baseball.utils.InputValidator.*;
import static baseball.view.ConsoleOutput.*;
import static baseball.view.InputConsole.*;
import static baseball.view.UmpireConsole.*;
import static nextstep.utils.Console.*;

import java.util.regex.Pattern;

import baseball.constant.GameState;
import baseball.exception.InputException;
import baseball.model.BallZone;
import baseball.model.PitchBalls;
import baseball.model.Umpire;

public class GameController {

	private static final Pattern pitchPattern = Pattern.compile("^[1-9]{3}$");
	private static final Pattern restartPattern = Pattern.compile("^[1-2]$");

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
		printMessageForWaitingInput();
		String pitching = readLine();

		PitchBalls pitchBalls;
		try {
			checkMatchPitchPattern(pitching);
			pitchBalls = new PitchBalls(pitching);
		} catch (InputException e) {
			printlnMessage(e.getMessage());
			return setPitchBalls();
		}
		return pitchBalls;
	}

	private static void checkMatchPitchPattern(String pitching) {
		if (!isMatchPattern(pitchPattern, pitching)) {
			throw new InputException(PITCH_INPUT_FORMAT_ERROR_MESSAGE);
		}
	}

	private static Umpire umpire(PitchBalls pitchBalls, BallZone ballZone) {
		Umpire result = new Umpire(pitchBalls, ballZone);
		printUmpireResult(result);
		return result;
	}

	public static GameState checkContinueGame() {
		String restartAnswer = readLine();

		try {
			checkMatchRestartPattern(restartAnswer);
		} catch (InputException e) {
			printlnMessage(e.getMessage());
			return checkContinueGame();
		}

		return isContinue(restartAnswer);
	}

	private static GameState isContinue(String restartAnswer) {
		if (Integer.parseInt(restartAnswer) == 1) {
			return CONTINUE;
		}
		return GAMEOVER;
	}

	private static void checkMatchRestartPattern(String restartAnswer) {
		if (!isMatchPattern(restartPattern, restartAnswer)) {
			throw new InputException(RESTART_INPUT_FORMAT_ERROR_MESSAGE);
		}
	}
}
