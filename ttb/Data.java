package ttb;

/**
 * 対戦中の文字の表や単語のリストを管理するクラスの抽象クラスです。
 * 
 * @author Kohara
 */
public abstract class Data {
	
	/**
	 * 文字列の表を一つのオブジェクトとして管理するためのクラス。
	 * 
	 * @author Kohara
	 */
	protected class Table {

		/** 各文字を配列に格納して、文字の位置を管理 */
		protected char[] letters;
		/** 単語フィールドの大きさ */
		protected int rows, columns;

		public Table(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
		}
	}
	
	/**
	 * 英単語一つを一つのオブジェクトとして管理するためのクラスです。
	 * 
	 * @author Kohara
	 */
	protected class Word {
	}
}
