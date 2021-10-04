package baseball.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

	public static boolean isMatchPattern(Pattern pattern, String checkString) {
		Matcher matcher = pattern.matcher(checkString);
		return matcher.find();
	}
}
