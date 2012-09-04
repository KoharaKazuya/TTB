package ttb;

/**
 * プレイヤーの抽象クラス。
 * 
 * @author Kohara
 */
public abstract class Unit {
	
	/** 現在入力中の文字列 */
	protected String currentText = "";
	/** 自フィールドの表オブジェクト */
	protected Table table;
	
	/**
	 * 得点を取得します。
	 */
	public int getScore() {
		// TODO
		return 0;
	}
	
	/**
	 * あらゆる行動をやりつくしたか？
	 */
	public boolean hasFinished() {
		return table.getNumOfObtainableWords() == 0;
	}
	
	/**
	 * 現在入力中の文字列を取得します。
	 */
	public String getText() {
		return currentText;
	}
	
	/**
	 * 表の生成
	 */
	public void generateTable() {
		// テスト用 : TODO
		if ( true ) {
			table = new Table(4, 4);
			table.addObtainableWord( new Word("test", 0, 0, Word.Orient.DOWN) );
		}
	}
}
