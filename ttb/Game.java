package ttb;

import ttb.client.GameStatePlayMatchClient;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * �v���O�����S�̂̊Ǘ����s���B
 * �Q�[���X�e�[�g�̕ω��ȂǁB
 * 
 * @author Kohara
 */
public class Game extends StateBasedGame {
	
	public static final int PLAY_MATCH_STATE_ID = 0;

	public Game() {
		super("Table Typing Battle");
		
		addState( new GameStatePlayMatchClient(PLAY_MATCH_STATE_ID) );
		
		enterState(PLAY_MATCH_STATE_ID);
	}

	/**
	 * �v���O���������s���ꂽ�ŏ��̂݌Ăяo�����B
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer( new Game() );
		app.setDisplayMode(800, 600, false);
		app.setTargetFrameRate(60);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(PLAY_MATCH_STATE_ID).init(container, this);
	}

}
