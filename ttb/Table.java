package ttb;

import java.util.ArrayList;
import java.util.Iterator;

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
		//�ǂƂԂ������疳��
		if(word.conflictwall(rows, columns)){
			return;
		}
		// �l���ςݒP��Ƌ�������Ȃ疳��
		for ( Word w : obtainedList ) {
			if ( w.conflictWith(word) ) {
				return;
			}
		}
		// �l���\�P��Ƌ�������Ȃ�㏑��
		// �����ɂ����������܂��������B�C������Ώ㏑���ł����邩������Ȃ����ǁE�E?????
		for ( Word w : wordList ) {
			if ( w.conflictWith(word) ) {
				//wordList.remove(w);
				return;
			}
		}
		//���ɓ����P�ꂪ�o�^����Ă����疳��
		for(Word w : wordList){
			if (w.getString().equals(word.getString())){
				return;
			}
		}
		rewriteLetters(word);
		wordList.add(word);
		//�m�F�p
//		System.out.println(word.getString());
	}
	
	/**
	 * �l���\�ȒP��̒ǉ�
	 */
	public void addObtainableWord(Word word) {
		addWord(word);
	}
	
	/**
	 * �P��̊l��
	 * @return boolean �l���������������ǂ���
	 */
	public boolean obtainWord(String wordStr) {
		boolean ret = false;
		Iterator<Word> ite = wordList.iterator();
		while ( ite.hasNext() ) {
			Word w = (Word)ite.next();
			if ( w.getString().equals(wordStr) ) {
				ret = true;
				obtainedList.add(w);
				ite.remove();
			}
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
		case RIGHT: dx = 1; break;
		case DOWN: dy = 1; break;
		}
		// �����̏�������
		int x = word.getX();
		int y = word.getY();
		for ( char c : word.getString().toCharArray() ) {
			letters[x+y*columns] = c;
			x += dx; y += dy;
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
	
	/**
	 * �\�̃}�X�ڂ����ꂼ��l���ς݂��ǂ������ꎟ���z��ɂ��ĕԂ��܂��B
	 * ���т͍��ォ�牡�ɁB
	 */
	public boolean[] getIsObtainedTable() {
		boolean[] table = new boolean[rows*columns];
		for ( Word w : obtainedList ) {
			int x = w.getX();
			int y = w.getY();
			int dx = 0;
			int dy = 0;
			switch ( w.getOrient() ) {
			case RIGHT: dx = 1; break;
			case DOWN: dy = 1; break;
			}
			for ( int i=0; i<w.getLength(); ++i ) {
				table[x+columns*y] = true;
				x += dx; y+= dy;
			}
		}
		return table;
	}
	
	/**
	 * �Ō�Ɋl�������P���Ԃ��܂��B
	 * �ЂƂ��l�����Ă��Ȃ��ꍇ�� null ��Ԃ��܂��B
	 * @return Word or null
	 */
	public Word getLastObtainedWord() {
		if ( obtainedList.isEmpty() ) {
			return null;
		} else {
			return obtainedList.get(obtainedList.size()-1);
		}
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
