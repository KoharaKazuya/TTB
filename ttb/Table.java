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
		
		// ### テスト用 ###
		if ( true ) {
			addObtainableWord( new Word("test", 0, 0, 0) );
		}
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
		// TODO
	}
}
