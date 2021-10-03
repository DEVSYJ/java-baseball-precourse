package baseball.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.model.StrikeZone;

class StrikeZoneTest {

	@Test
	void createInstanceTest() {
		StrikeZone strikeZone = new StrikeZone();
		Integer strikeZoneFirst = strikeZone.getFirst();
		Integer strikeZoneSecond = strikeZone.getSecond();
		Integer strikeZoneThird = strikeZone.getThird();

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
