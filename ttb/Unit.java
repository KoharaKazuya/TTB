package ttb;

/**
 * �v���C���[�̒��ۃN���X�B
 * 
 * @author Kohara
 */
public abstract class Unit implements InputListener {
	
	/** ���ݓ��͒��̕����� */
	protected String currentText = "";
	/** ���t�B�[���h�̕\�I�u�W�F�N�g */
	protected Table table;
	
	/**
	 * ���_���擾���܂��B
	 */
	public int getScore() {
		return -table.getNumOfObtainableWords();
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

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		if ( table.obtainWord(s) ) {
			System.out.println(table);
			System.out.println("you got '" + s + "'!");
		}
	}
}
