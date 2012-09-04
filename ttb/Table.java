package ttb;

import java.util.ArrayList;

/**
 * ������̕\����̃I�u�W�F�N�g�Ƃ��ĊǗ����邽�߂̃N���X�B
 * 
 * @author Kohara
 */
public class Table {
	
	/** �e������z��Ɋi�[���āA�����̈ʒu���Ǘ� */
	protected char[] letters;
	/** �P��t�B�[���h�̑傫�� */
	protected int rows, columns;
	/** �l���\�ȒP��̃��X�g */
	protected ArrayList<Word> wordList;
	/** �l���ς݂̒P�ꃊ�X�g */
	protected ArrayList<Word> obtainedList;

	public Table(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		letters = new char[rows*columns];
		wordList = new ArrayList<Word>();
		obtainedList = new ArrayList<Word>();
	}
	
	/**
	 * �P��̏㏑��
	 */
	public void addWord(Word word) {
		// �l���ςݒP��Ƌ�������Ȃ疳��
		for ( Word w : obtainedList ) {
			if ( w.conflictWith(word) ) {
				return;
			}
		}
		// �l���\�P��Ƌ�������Ȃ�㏑��
		for ( Word w : wordList ) {
			if ( w.conflictWith(word) ) {
				wordList.remove(w);
			}
		}
		rewriteLetters(word);
	}
	
	/**
	 * �l���\�ȒP��̒ǉ�
	 */
	public void addObtainableWord(Word word) {
		addWord(word);
		wordList.add(word);
	}
	
	/**
	 * �P��̊l��
	 * @return boolean �l���������������ǂ���
	 */
	public boolean obtainWord(String wordStr) {
		boolean ret = false;
		ArrayList<Word> removeList = new ArrayList<Word>();
		for ( Word w : wordList ) {
			if ( w.getString().equals(wordStr) ) {
				removeList.add(w);
				obtainedList.add(w);
				ret = true;
			}
		}
		for ( Word w : removeList ) {
			wordList.remove(w);
		}
		return ret;
	}
	
	/**
	 * �^�����P��ɑΉ�����ʒu�̕����������������
	 */
	protected void rewriteLetters(Word word) {
		int dx=0, dy=0;
		// �����̎擾
		switch ( word.getOrient() ) {
		case Word.ORIENT_RIGHT:
			dx = 1;
			break;
		case Word.ORIENT_DOWN:
			dy = 1;
			break;
		}
		// �����̏�������
		for ( char c : word.getString().toCharArray() ) {
			int x = word.getX() + dx++;
			int y = word.getY() + dy++;
			letters[x+y*columns] = c;
		}
	}
	
	/**
	 * �c��̊l���\�ȒP��̐�
	 */
	public int getNumOfObtainableWords() {
		return wordList.size();
	}
	
	/**
	 * �\�𕶎��̈ꎟ���z��ɂ��ĕԂ��܂��B
	 * ���т͍��ォ�牡�ɁB
	 */
	public char[] getLetters() {
		return letters;
	}

	@Override
	/**
	 * �\�𕶎���\���ŕԂ��܂��B
	 */
	public String toString() {
		String clrl = System.getProperty("line.separator");
		String str = "";
		
		str += super.toString();
		for ( int row=0; row<rows; ++row ) {
			String line = "";
			for ( int col=0; col<columns; ++col ) {
				line += getLetters()[row*columns + col];
			}
			str += clrl + line;
		}
		
		return str;
	}
}
