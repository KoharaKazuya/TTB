package ttb;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

/**
 * �Q�[�������s���邽�߂̃N���X�B
 * 
 * @author Kohara
 */
public class GameStatePlayMatch extends BasicGameState {
	
	/** �X�e�[�gID */
	private int stateID;
	/** ����m�F�p�̃e�L�X�g�t�B�[���h */
	protected TextField textField;
	/** �L�[�{�[�h����̒P����� */
	protected InputWord input;
	/** �v���C���[�I�u�W�F�N�g */
	protected Player player;
	/** �G�v���C���[�I�u�W�F�N�g */
	protected Opponent opponent;
	/** GUI */
	protected GuiPlayMatch gui;

	public GameStatePlayMatch(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		/* ### ����m�F�e�X�g�p ### */
		if ( true ) {
			// �t�H���g�̗p��
			// TODO : �����̌y������X�v���C�g���p�ӂł�����ASpriteSheetFont�ɒu������
			java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24);
			Font font = new TrueTypeFont(awtFont, true);

			// �e�L�X�g�\���̈�̗p��
			textField = new TextField(container, font, 10, 10, 100, 100);
			textField.setFocus(false);
		}
		/* ### ### */
		
		// �v���C���[�̏���
		player = new Player();
		opponent = new Opponent();

		// ���͏����̗p��
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.setInputListener(player);
		
		// GUI�̗p��
		gui = new GuiPlayMatch();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		gui.render(container, g);
		textField.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		textField.setText(input.getText());
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
