package ttb;

/**
 * �v���C���[�̒��ۃN���X�B
 * 
 * @author Kohara
 */
public abstract class Unit {
	
	/** ���ݓ��͒��̕����� */
	protected String currentText = "";
	/** ���t�B�[���h�̕\�I�u�W�F�N�g */
	protected Table table = new Table(4, 4);
	
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
