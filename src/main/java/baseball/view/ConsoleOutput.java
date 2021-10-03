package baseball.view;

public class ConsoleOutput {
	private static final String WAITING_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	public static void printMessageForWaitingInput() {
		printMessage(WAITING_INPUT_MESSAGE);
	}

	private static void printMessage(String message) {
		System.out.print(message);
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
