package ttb;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * �L�[�{�[�h����̓��͂��󂯕t���A���͒��̕�����A���͂��m�肵���P����Ǘ����܂��B
 * 
 * @author Kohara
 */
public class InputWord implements KeyListener {
	
	/** �A���t�@�x�b�g����p������ */
	protected final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/** ���͒��̕����� */
	protected String text;
	/** ���͂̕ω����󂯎�郊�X�i�[�iPlayerClient�N���X������j */
	protected InputListener listener;
	
	public InputWord() {
		text = "";
	}
	
	/**
	 * @return String ���ݓ��͒��̕�����
	 */
	public String getText() {
		return text;
	}

	@Override
	/**
	 * �g���܂���B
	 * �C�x���g�𔭐�������Input�C���X�^���X��o�^���܂��B
	 */
	public void setInput(Input input) {
	}

	@Override
	/**
	 * �g���܂���B
	 * ���̃C���v�b�g���X�i�[�����͂��󂯕t���邩�ǂ����m�F���܂��B
	 */
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	/**
	 * �g���܂���B
	 * �S�ẴC���v�b�g�C�x���g�̑��M�������������Ƃ�m�点�܂��B
	 */
	public void inputEnded() {
	}

	@Override
	/**
	 * �g���܂���B
	 * �C���v�b�g�̏����̊J�n��m�点�܂��B
	 */
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
		// Enter��Space�Ŋm��&�폜
		if ( key == Keyboard.KEY_RETURN || key == Keyboard.KEY_SPACE ) {
			if ( !"".equals(text) ) {
				inputString(text);
			}
			changeText("");
		// BackSpace�ňꕶ���폜�i���s�[�g�͂��Ȃ��j
		} else if ( key == Keyboard.KEY_BACK ) {
			changeText(text.substring(0, Math.max(text.length()-1, 0)));
		// ���̑��ŕ������́B�p�������ȊO�͂͂���
		} else {
			if ( ALPHABET.indexOf(c) != -1 ) {
				changeText(text + c);
			}
		}
	}
	
	@Override
	public void keyReleased(int key, char c) {
	}
	
	/**
	 * ���͂̃��X�i�[�̓o�^
	 */
	public void setInputListener(InputListener listener) {
		this.listener = listener;
	}

	/**
	 * ���͒��̕�����̕ύX�͂����ōs���B
	 * @param newText �V�����e�L�X�g
	 */
	protected void changeText(String newText) {
		text = newText;
		listener.textChanged(text);
	}
	
	/**
	 * ������̊m��͂����ōs���B
	 * @param text �m�肵��������
	 */
	protected void inputString(String text) {
		listener.stringInputed(text);
	}

}
