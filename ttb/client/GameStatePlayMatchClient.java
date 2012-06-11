package ttb.client;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

import ttb.GameStatePlayMatch;

public class GameStatePlayMatchClient extends GameStatePlayMatch {
	
	protected TextField textField;
	protected InputWord input;
	protected PlayerClient me, you;

	public GameStatePlayMatchClient(int stateID) {
		super(stateID);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		// �t�H���g�̗p��
		// TODO : �����̌y������X�v���C�g���p�ӂł�����ASpriteSheetFont�ɒu������
		java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24);
		Font font = new TrueTypeFont(awtFont, true);
		
		// �e�L�X�g�\���̈�̗p��
		textField = new TextField(container, font, 10, 10, 100, 100);
		textField.setFocus(false);
		
		// �v���C���[�̏���
		me = new PlayerClient();
		you = new PlayerClient();

		// ���͏����̗p��
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.setInputListener(me);
		
		// GUI�̗p��
//		gui = new PlayMatchGui();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
//		gui.render(container, g);
		textField.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		textField.setText(input.getText());
	}

}
