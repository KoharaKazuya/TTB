package ttb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * �^�C�g�����
 * 
 * @author Kohara
 */
public class GameStateTitle extends BasicGameState {
	
	/** ���̃X�e�[�g */
	enum STATES {
		TITLE, PLAY_MATCH, EXIT_GAME
	}
	
	/** �X�e�[�gID */
	private int stateID;
	/** ���̃X�e�[�g */
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
			throw new SlickException("��`����Ă��Ȃ��X�e�[�g�����X�e�[�g�Ɏw�肳��܂����B");
		}
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		super.mouseClicked(button, x, y, clickCount);
		// TODO : �e�X�g�p
		switch ( button ) {
		case 0: nextState = STATES.PLAY_MATCH; break;
		case 1: nextState = STATES.EXIT_GAME; break;
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
