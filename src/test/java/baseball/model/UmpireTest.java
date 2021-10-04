package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.constant.UmpireState;

class UmpireTest {

	@Test
	void umpire3StrikeTest() {
		BallZone ballZone = new BallZone(1, 2, 3);
		PitchBalls pitchBalls = new PitchBalls("123");
		Umpire umpire = new Umpire(pitchBalls, ballZone);
		System.out.println(umpire);

		assertThat(umpire.getUmpireResults()[0])
			.isEqualTo(UmpireState.STRIKE);
		assertThat(umpire.getUmpireResults()[1])
			.isEqualTo(UmpireState.STRIKE);
		assertThat(umpire.getUmpireResults()[2])
			.isEqualTo(UmpireState.STRIKE);

		assertThat(umpire.getStrikeCount())
			.isEqualTo(3);
		assertThat(umpire.getBallCount())
			.isEqualTo(0);
	}

	@Test
	void umpire3BallTest() {
		BallZone ballZone = new BallZone(1, 2, 3);
		PitchBalls pitchBalls = new PitchBalls("312");
		Umpire umpire = new Umpire(pitchBalls, ballZone);
		System.out.println(umpire);

		assertThat(umpire.getUmpireResults()[0])
			.isEqualTo(UmpireState.BALL);
		assertThat(umpire.getUmpireResults()[1])
			.isEqualTo(UmpireState.BALL);
		assertThat(umpire.getUmpireResults()[2])
			.isEqualTo(UmpireState.BALL);

		assertThat(umpire.getStrikeCount())
			.isEqualTo(0);
		assertThat(umpire.getBallCount())
			.isEqualTo(3);
	}

	@Test
	void umpire3NotingTest() {
		BallZone ballZone = new BallZone(1, 2, 3);
		PitchBalls pitchBalls = new PitchBalls("456");
		Umpire umpire = new Umpire(pitchBalls, ballZone);
		System.out.println(umpire);

		assertThat(umpire.getUmpireResults()[0])
			.isEqualTo(UmpireState.NOTHING);
		assertThat(umpire.getUmpireResults()[1])
			.isEqualTo(UmpireState.NOTHING);
		assertThat(umpire.getUmpireResults()[2])
			.isEqualTo(UmpireState.NOTHING);

		assertThat(umpire.getStrikeCount())
			.isEqualTo(0);
		assertThat(umpire.getBallCount())
			.isEqualTo(0);
	}

	@Test
	void umpire1Strike2BallTest() {
		BallZone ballZone = new BallZone(1, 2, 3);
		PitchBalls pitchBalls = new PitchBalls("132");
		Umpire umpire = new Umpire(pitchBalls, ballZone);
		System.out.println(umpire);

		assertThat(umpire.getUmpireResults()[0])
			.isEqualTo(UmpireState.STRIKE);
		assertThat(umpire.getUmpireResults()[1])
			.isEqualTo(UmpireState.BALL);
		assertThat(umpire.getUmpireResults()[2])
			.isEqualTo(UmpireState.BALL);

		assertThat(umpire.getStrikeCount())
			.isEqualTo(1);
		assertThat(umpire.getBallCount())
			.isEqualTo(2);
	}

	@Test
	void umpire1Strike1Ball1NothingTest() {
		BallZone ballZone = new BallZone(1, 2, 3);
		PitchBalls pitchBalls = new PitchBalls("134");
		Umpire umpire = new Umpire(pitchBalls, ballZone);
		System.out.println(umpire);

		assertThat(umpire.getUmpireResults()[0])
			.isEqualTo(UmpireState.STRIKE);
		assertThat(umpire.getUmpireResults()[1])
			.isEqualTo(UmpireState.BALL);
		assertThat(umpire.getUmpireResults()[2])
			.isEqualTo(UmpireState.NOTHING);

		assertThat(umpire.getStrikeCount())
			.isEqualTo(1);
		assertThat(umpire.getBallCount())
			.isEqualTo(1);
	}
}
