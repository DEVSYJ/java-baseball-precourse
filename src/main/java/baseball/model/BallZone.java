package baseball.model;

import lombok.Getter;
import lombok.ToString;
import nextstep.utils.Randoms;

@Getter
@ToString
public class BallZone {
	private Integer[] strikeZones = new Integer[3];

	public BallZone() {
		this.strikeZones[0] = setUniqueStrikeZone(null, null);
		this.strikeZones[1] = setUniqueStrikeZone(this.strikeZones[0], null);
		this.strikeZones[2] = setUniqueStrikeZone(this.strikeZones[0], this.strikeZones[2]);
	}

	// TEST용
	public BallZone(Integer first, Integer second, Integer third) {
		this.strikeZones[0] = first;
		this.strikeZones[1] = second;
		this.strikeZones[2] = third;
	}

	private Integer setUniqueStrikeZone(Integer usedStrikeZone1, Integer usedStrikeZone2) {
		Integer result = Randoms.pickNumberInRange(1, 9);

		while (result.equals(usedStrikeZone1) || result.equals(usedStrikeZone2)) {
			result = Randoms.pickNumberInRange(1, 9);
		}

		return result;
	}
}
