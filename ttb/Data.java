package ttb;

/**
 * �ΐ풆�̕����̕\��P��̃��X�g���Ǘ�����N���X�̒��ۃN���X�ł��B
 * 
 * @author Kohara
 */
public abstract class Data {
	
	/**
	 * ������̕\����̃I�u�W�F�N�g�Ƃ��ĊǗ����邽�߂̃N���X�B
	 * 
	 * @author Kohara
	 */
	protected class Table {

		/** �e������z��Ɋi�[���āA�����̈ʒu���Ǘ� */
		protected char[] letters;
		/** �P��t�B�[���h�̑傫�� */
		protected int rows, columns;

		public Table(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
		}
	}
	
	/**
	 * �p�P������̃I�u�W�F�N�g�Ƃ��ĊǗ����邽�߂̃N���X�ł��B
	 * 
	 * @author Kohara
	 */
	protected class Word {
	}
}
