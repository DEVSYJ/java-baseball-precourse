package baseball.model;

import lombok.Getter;
import nextstep.utils.Randoms;

@Getter
public class StrikeZone {
	private Integer first;
	private Integer second;
	private Integer third;

	public StrikeZone() {
		first = setUniqueStrikeZone(null, null);
		second = setUniqueStrikeZone(first, null);
		third = setUniqueStrikeZone(first, second);
	}

	private Integer setUniqueStrikeZone(Integer usedStrikeZone1, Integer usedStrikeZone2) {
		Integer result = Randoms.pickNumberInRange(1, 9);

		while (result.equals(usedStrikeZone1) || result.equals(usedStrikeZone2)) {
			result = Randoms.pickNumberInRange(1, 9);
		}

		return result;
	}
}
