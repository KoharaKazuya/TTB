package ttb;

import java.util.ArrayList;

/**
 * 文字列の表を一つのオブジェクトとして管理するためのクラス。
 * 
 * @author Kohara
 */
public class Table {
	
	/** 各文字を配列に格納して、文字の位置を管理 */
	protected char[] letters;
	/** 単語フィールドの大きさ */
	protected int rows, columns;
	/** 獲得可能な単語のリスト */
	protected ArrayList<Word> wordList;
	/** 獲得済みの単語リスト */
	protected ArrayList<Word> obtainedList;

	public Table(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		letters = new char[rows*columns];
		wordList = new ArrayList<Word>();
		obtainedList = new ArrayList<Word>();
	}
	
	/**
	 * 単語の上書き
	 */
	public void addWord(Word word) {
		// 獲得済み単語と競合するなら無効
		for ( Word w : obtainedList ) {
			if ( w.conflictWith(word) ) {
				return;
			}
		}
		// 獲得可能単語と競合するなら上書き
		for ( Word w : wordList ) {
			if ( w.conflictWith(word) ) {
				wordList.remove(w);
			}
		}
		rewriteLetters(word);
	}
	
	/**
	 * 獲得可能な単語の追加
	 */
	public void addObtainableWord(Word word) {
		addWord(word);
		wordList.add(word);
	}
	
	/**
	 * 単語の獲得
	 * @return boolean 獲得が成功したかどうか
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
	 * 与えた単語に対応する位置の文字列を書き換える
	 */
	protected void rewriteLetters(Word word) {
		int dx=0, dy=0;
		// 方向の取得
		switch ( word.getOrient() ) {
		case Word.ORIENT_RIGHT:
			dx = 1;
			break;
		case Word.ORIENT_DOWN:
			dy = 1;
			break;
		}
		// 文字の書き換え
		for ( char c : word.getString().toCharArray() ) {
			int x = word.getX() + dx++;
			int y = word.getY() + dy++;
			letters[x+y*columns] = c;
		}
	}
	
	/**
	 * 残りの獲得可能な単語の数
	 */
	public int getNumOfObtainableWords() {
		return wordList.size();
	}
	
	/**
	 * 表を文字の一次元配列にして返します。
	 * 並びは左上から横に。
	 */
	public char[] getLetters() {
		return letters;
	}

	@Override
	/**
	 * 表を文字列表現で返します。
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
