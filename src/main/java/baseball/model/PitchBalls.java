package baseball.model;

import static baseball.exception.ErrorMessage.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseball.exception.PitchException;
import lombok.Getter;
import lombok.ToString;

// 투수
@Getter
@ToString
public class PitchBalls {
	private Integer[] pitchBalls = new Integer[3];

	private static final Pattern pitchPattern = Pattern.compile("^[1-9]{3}$");

	public PitchBalls(String pitching) {
		if (!isPitchAvailable(pitching)) {
			throw new PitchException(PITCH_INPUT_FORMAT_ERROR_MESSAGE);
		}

		this.pitchBalls[0] = Character.getNumericValue(pitching.charAt(0));
		this.pitchBalls[1] = Character.getNumericValue(pitching.charAt(1));
		this.pitchBalls[2] = Character.getNumericValue(pitching.charAt(2));

		if (!isEachUnique()) {
			throw new PitchException(PITCH_INPUT_NOT_UNIQUE_EACH_ERROR_MESSAGE);
		}
	}

	private boolean isPitchAvailable(String pitching) {
		Matcher matcher = pitchPattern.matcher(pitching);
		return matcher.find();
	}

	private boolean isEachUnique() {
		return !(this.pitchBalls[0].equals(this.pitchBalls[1])
			|| this.pitchBalls[0].equals(this.pitchBalls[2])
			|| this.pitchBalls[1].equals(this.pitchBalls[2]));
	}
}
