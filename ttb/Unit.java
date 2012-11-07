package ttb;


import java.util.Random;

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
	public Table getTable() { return table; }

	public String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
								"o","p","q","r","s","t","u","v","w","x","y","z"};

	/**
	 * ���_���擾���܂��B
	 */
	public int getScore() {
		if ( table == null ) {
			return 0;
		} else {
			return 600 - 10*table.getNumOfObtainableWords();
		}
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
		// �Q�[���ݒ�̓ǂݍ���
		GameSetting setting = GameSetting.getInstance();
		int rows = setting.getTableRows();
		int columns = setting.getTableColumns();

		table = new Table(rows, columns);
		/*�摜�ǂݍ���*/
		WordList wo = WordList.getInstance();

		int len = wo.stringArray.length;
		int x, y, r;
		String enwd, jawd;
		Random rnd = new Random();
		for(int i=0;i<10000;i++){
			x = rnd.nextInt(columns);
			y = rnd.nextInt(rows);
			r = rnd.nextInt(len);
			enwd = wo.stringArray[r][0];
			jawd = wo.stringArray[r][1];
			table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.DOWN) );
			x = rnd.nextInt(columns);
			y = rnd.nextInt(rows);
			r = rnd.nextInt(len);
			enwd = wo.stringArray[r][0];
			jawd = wo.stringArray[r][1];
			table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.RIGHT) );
		}
	}

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		if ( table.obtainWord(s) ) {
			System.out.println("you got '" + s + "'!");
		}
	}
}
