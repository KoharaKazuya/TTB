package ttb;

/**
 * �v���C���[�̒��ۃN���X�B
 * 
 * @author Kohara
 */
public abstract class Unit {
	
	/** ���ݓ��͒��̕����� */
	protected String currentText = "";
	
	/**
	 * ���_���擾���܂��B
	 */
	public int getScore() {
		// TODO
		return 0;
	}
	
	/**
	 * ������s���������������H
	 */
	public boolean hasFinished() {
		// TODO
		return false;
	}
	
	/**
	 * ���ݓ��͒��̕�������擾���܂��B
	 */
	public String getText() {
		return currentText;
	}
}
