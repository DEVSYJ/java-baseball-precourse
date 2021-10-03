package baseball.exception;

public enum ErrorMessage {
	PITCH_INPUT_FORMAT_ERROR_MESSAGE("[ERROR] 입력은 3글자인 0을 미포함한 숫자형식이어야 합니다."),
	PITCH_INPUT_NOT_UNIQUE_EACH_ERROR_MESSAGE("[ERROR] 입력한 세 숫자는 각각 달라야 합니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
