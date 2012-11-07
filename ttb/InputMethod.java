package ttb;

/**
 * �L�[�{�[�h��l�b�g���[�N�o�R�Ȃǂ̓��͕��@�̒��ۃN���X
 * 
 * @author Kohara
 */
public abstract class InputMethod {
	
	/** ���͂̕ω����󂯎�郊�X�i�[  */
	protected InputListener listener;
	
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
