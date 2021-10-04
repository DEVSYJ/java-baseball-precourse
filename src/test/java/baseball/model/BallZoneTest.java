package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BallZoneTest {

	@Test
	void createInstanceTest() {
		BallZone ballZone = new BallZone();
		Integer strikeZoneFirst = ballZone.getStrikeZones()[0];
		Integer strikeZoneSecond = ballZone.getStrikeZones()[1];
		Integer strikeZoneThird = ballZone.getStrikeZones()[2];

		System.out.println(strikeZoneFirst);
		System.out.println(strikeZoneSecond);
		System.out.println(strikeZoneThird);

		assertThat(strikeZoneFirst)
			.isGreaterThanOrEqualTo(1)
			.isLessThanOrEqualTo(9)
			.isNotEqualTo(strikeZoneSecond)
			.isNotEqualTo(strikeZoneThird);
		assertThat(strikeZoneSecond)
			.isGreaterThanOrEqualTo(1)
			.isLessThanOrEqualTo(9)
			.isNotEqualTo(strikeZoneFirst)
			.isNotEqualTo(strikeZoneThird);
		assertThat(strikeZoneThird)
			.isGreaterThanOrEqualTo(1)
			.isLessThanOrEqualTo(9)
			.isNotEqualTo(strikeZoneFirst)
			.isNotEqualTo(strikeZoneSecond);
	}
}
