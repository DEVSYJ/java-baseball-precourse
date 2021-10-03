package baseball.exception;

public class CustomException extends RuntimeException {
	private ErrorMessage errorMessage;

	public CustomException(ErrorMessage errorMessage) {
		super(errorMessage.getErrorMessage());
		this.errorMessage = errorMessage;
	}
}
