package ttb;

/**
 * 文字列の表を一つのオブジェクトとして管理するためのクラス。
 * 
 * @author Kunishige
 */
public class Table {
	
	/** 各文字を配列に格納して、文字の位置を管理 */
	protected char[] letters;
	/** 単語フィールドの大きさ */
	protected int rows, columns;

	public Table(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		letters = new char[rows*columns];
	}
}
