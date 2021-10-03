package baseball.model;

import static baseball.view.ConsoleOutput.*;
import static nextstep.utils.Console.*;

// 투수
public class Pitcher {
	private Integer pitchedFirst;
	private Integer pitchedSecond;
	private Integer pitchedThird;

	public Pitcher pitch() {
		printMessageForWaitingInput();
		String pitching = readLine();
		// TODO : set pitchball
		return this;
	}

}
