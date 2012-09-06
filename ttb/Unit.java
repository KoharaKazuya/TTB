package ttb;

/**
 * プレイヤーの抽象クラス。
 * 
 * @author Kohara
 */
public abstract class Unit implements InputListener {
	
	/** 現在入力中の文字列 */
	protected String currentText = "";
	/** 自フィールドの表オブジェクト */
	protected Table table;
	
	/**
	 * 得点を取得します。
	 */
	public int getScore() {
		return -table.getNumOfObtainableWords();
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

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		if ( table.obtainWord(s) ) {
			System.out.println(table);
			System.out.println("you got '" + s + "'!");
		}
	}
}
