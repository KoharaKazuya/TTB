package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
	/** �Q�[�����W�b�N�I�u�W�F�N�g */
	protected LogicPlayMatch logic;
	/** �l�b�g���[�N�Ǘ��I�u�W�F�N�g */
	protected InputNetwork network;
	/** GUI */
	protected GuiPlayMatch gui;
	
	public GameStatePlayMatch(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		// �e�X�g�p : TODO
		if ( true ) {
			// �t�H���g�̗p��
			// TODO : �����̌y������X�v���C�g���p�ӂł�����ASpriteSheetFont�ɒu������
			java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24);
			Font font = new TrueTypeFont(awtFont, true);

			// �e�L�X�g�\���̈�̗p��
			textField = new TextField(container, font, 285, 545, 420, 30);
			textField.setFocus(false);
		}
		
		// �v���C���[�̏���
		try {
			player = new Player(getChannel());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		opponent = new Opponent();
		
		// �Q�[�����W�b�N�̗p��
		logic = new LogicPlayMatch(player, opponent);
		
		// �l�b�g���[�N�Ǘ��I�u�W�F�N�g�̗p��
		network = new InputNetwork();
		network.setInputListener(opponent);

		// ���͏����̗p��
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.setInputListener(player);
		
		// GUI�̗p��
		gui = new GuiPlayMatch(new Unit[] { player, opponent });
		
		// �Q�[���X�^�[�g
		logic.start();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		gui.render(container, g);
		//�e�L�X�g
		g.setColor(Color.black);
		textField.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		logic.update();
		textField.setText(input.getText());
	}
	
	@Override
	public int getID() {
		return stateID;
	}
	
	/**
	 * �ΐ푊��Ɏ����̓��͂𑗐M����`�����l���̍쐬
	 * ����͕ʂ̃X�e�[�g�Ń`�����l�����m�����Ȃ���΂Ȃ�Ȃ����A�e�X�g�p
	 */
	private DatagramChannel getChannel() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.connect(new InetSocketAddress("localhost", 9000));
		return channel;
	}

}
