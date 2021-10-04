package baseball.view;

import static baseball.view.ConsoleOutput.*;

public class InputConsole {
	private static final String WAITING_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printMessageForWaitingInput() {
		printMessage(WAITING_INPUT_MESSAGE);
	}

	public static void printMessageForRestart() {
		printMessage(RESTART_MESSAGE);
	}
}
