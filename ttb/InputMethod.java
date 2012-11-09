package ttb;

import java.util.ArrayList;

/**
 * �L�[�{�[�h��l�b�g���[�N�o�R�Ȃǂ̓��͕��@�̒��ۃN���X
 * 
 * @author Kohara
 */
public abstract class InputMethod {
	
	/** ���͂̕ω����󂯎�郊�X�i�[  */
	protected ArrayList<InputListener> listeners = new ArrayList<InputListener>();
	
	/** ���͒��̕����� */
	protected String text;
	
	/**
	 * @return String ���ݓ��͒��̕�����
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * ���͂̃��X�i�[�̓o�^
	 */
	public void addInputListener(InputListener listener) {
		listeners.add(listener);
	}

	/**
	 * ���͒��̕�����̕ύX�͂����ōs���B
	 * @param newText �V�����e�L�X�g
	 */
	protected void changeText(String newText) {
		text = newText;
		for ( InputListener listener : listeners ) {
			listener.textChanged(text);
		}
	}
	
	/**
	 * ������̊m��͂����ōs���B
	 * @param text �m�肵��������
	 */
	protected void inputString(String text) {
		for ( InputListener listener : listeners ) {
			listener.stringInputed(text);
		}
	}

}
