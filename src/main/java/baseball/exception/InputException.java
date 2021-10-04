package baseball.exception;

public class InputException extends CustomException {
	public InputException(ErrorMessage errorMessage) {
		super(errorMessage);
	}
}
