package ttb;

/**
 * ������̕\����̃I�u�W�F�N�g�Ƃ��ĊǗ����邽�߂̃N���X�B
 * 
 * @author Kunishige
 */
public class Table {
	
	/** �e������z��Ɋi�[���āA�����̈ʒu���Ǘ� */
	protected char[] letters;
	/** �P��t�B�[���h�̑傫�� */
	protected int rows, columns;

	public Table(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		letters = new char[rows*columns];
	}
}
