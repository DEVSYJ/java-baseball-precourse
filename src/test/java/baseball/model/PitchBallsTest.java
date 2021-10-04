package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import baseball.exception.InputException;

class PitchBallsTest {

	private static final Pattern pattern = Pattern.compile("^[1-9]{3}$");    // 1~9 범위의 숫자 3자리
	private static final String[] matchRegList = {"123", "345", "173", "555"};
	private static final String[] missMatchRegList = {"abc", "1234", "12", "101"};
	private static final String[] pitchSuccessList = {"123", "345", "173"};
	private static final String[] pitchFailList = {"abc", "1234", "12", "101", "555"};

	@Test
	void matchRegexTest() {
		for (String match : matchRegList) {
			Matcher matcher = pattern.matcher(match);
			boolean result = matcher.find();

			assertThat(result)
				.isTrue();
		}
	}

	@Test
	void missMatchRegexTest() {
		for (String missMatch : missMatchRegList) {
			Matcher matcher = pattern.matcher(missMatch);
			boolean result = matcher.find();

			assertThat(result)
				.isFalse();
		}
	}

	@Test
	void pitchSuccessTest() {
		for (String pitchSuccess : pitchSuccessList) {
			PitchBalls pitchBalls = new PitchBalls(pitchSuccess);

			assertThat(pitchBalls.getPitchBalls()[0])
				.isEqualTo(Character.getNumericValue(pitchSuccess.charAt(0)));
			assertThat(pitchBalls.getPitchBalls()[1])
				.isEqualTo(Character.getNumericValue(pitchSuccess.charAt(1)));
			assertThat(pitchBalls.getPitchBalls()[2])
				.isEqualTo(Character.getNumericValue(pitchSuccess.charAt(2)));
		}
	}

	@Test
	void pitchFailTest() {
		for (String pitchFail : pitchFailList) {
			assertThrows(InputException.class, () -> {
				new PitchBalls(pitchFail);
			});
		}
	}
}
