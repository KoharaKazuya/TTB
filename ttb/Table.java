package ttb;

import java.util.ArrayList;
import java.util.Iterator;

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
		//壁とぶつかったら無効
		if(word.conflictwall(rows, columns)){
			return;
		}
		// 獲得済み単語と競合するなら無効
		for ( Word w : obtainedList ) {
			if ( w.conflictWith(word) ) {
				return;
			}
		}
		// 獲得可能単語と競合するなら上書き
		// 無効にした方がうまくいった。修正すれば上書きでいけるかもしれないけど・・?????
		for ( Word w : wordList ) {
			if ( w.conflictWith(word) ) {
				//wordList.remove(w);
				return;
			}
		}
		//既に同じ単語が登録されていたら無効
		for(Word w : wordList){
			if (w.getString().equals(word.getString())){
				return;
			}
		}
		rewriteLetters(word);
		wordList.add(word);
		//確認用
//		System.out.println(word.getString());
	}
	
	/**
	 * 獲得可能な単語の追加
	 */
	public void addObtainableWord(Word word) {
		addWord(word);
	}
	
	/**
	 * 単語の獲得
	 * @return boolean 獲得が成功したかどうか
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
	 * 与えた単語に対応する位置の文字列を書き換える
	 */
	protected void rewriteLetters(Word word) {
		int dx=0, dy=0;
		// 方向の取得
		switch ( word.getOrient() ) {
		case RIGHT: dx = 1; break;
		case DOWN: dy = 1; break;
		}
		// 文字の書き換え
		int x = word.getX();
		int y = word.getY();
		for ( char c : word.getString().toCharArray() ) {
			letters[x+y*columns] = c;
			x += dx; y += dy;
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
	
	/**
	 * 表のマス目がそれぞれ獲得済みかどうかを一次元配列にして返します。
	 * 並びは左上から横に。
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
	 * 最後に獲得した単語を返します。
	 * ひとつも獲得していない場合は null を返します。
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
