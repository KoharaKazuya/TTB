package ttb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * タイトル画面
 * 
 * @author Kohara
 */
public class GameStateTitle extends BasicGameState {
	
	/** 次のステート */
	enum STATES {
		TITLE, PLAY_MATCH, EXIT_GAME
	}
	
	/** ステートID */
	private int stateID;
	/** 次のステート */
	private STATES nextState = STATES.TITLE;
	
	public GameStateTitle(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		switch ( nextState ) {
		case TITLE:
			break;
		case PLAY_MATCH:
			game.enterState(Game.PLAY_MATCH_STATE_ID);
			break;
		case EXIT_GAME:
			container.exit();
			break;
		default:
			throw new SlickException("定義されていないステートが次ステートに指定されました。");
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
