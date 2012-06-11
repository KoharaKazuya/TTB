package ttb;

import org.newdawn.slick.state.BasicGameState;

/**
 * 試合実行中のゲームステートのクラス。
 * 
 * @author Kohara
 */
public abstract class GameStatePlayMatch extends BasicGameState {
	
	private int stateID;
	
	public GameStatePlayMatch(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

}
