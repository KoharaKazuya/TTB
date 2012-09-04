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
	protected Table table;
	
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
		return table.getNumOfObtainableWords() == 0;
	}
	
	/**
	 * ���ݓ��͒��̕�������擾���܂��B
	 */
	public String getText() {
		return currentText;
	}
	
	/**
	 * �\�̐���
	 */
	public void generateTable() {
		// �e�X�g�p : TODO
		if ( true ) {
			table = new Table(4, 4);
			table.addObtainableWord( new Word("test", 0, 0, Word.Orient.DOWN) );
		}
	}
}
