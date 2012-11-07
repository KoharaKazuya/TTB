package ttb;


import java.util.Random;

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
	public Table getTable() { return table; }

	public String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
								"o","p","q","r","s","t","u","v","w","x","y","z"};

	/**
	 * 得点を取得します。
	 */
	public int getScore() {
		if ( table == null ) {
			return 0;
		} else {
			return 600 - 10*table.getNumOfObtainableWords();
		}
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
		// ゲーム設定の読み込み
		GameSetting setting = GameSetting.getInstance();
		int rows = setting.getTableRows();
		int columns = setting.getTableColumns();

		table = new Table(rows, columns);
		/*画像読み込み*/
		WordList wo = WordList.getInstance();

		int len = wo.stringArray.length;
		int x, y, r;
		String enwd, jawd;
		Random rnd = new Random();
		for(int i=0;i<10000;i++){
			x = rnd.nextInt(columns);
			y = rnd.nextInt(rows);
			r = rnd.nextInt(len);
			enwd = wo.stringArray[r][0];
			jawd = wo.stringArray[r][1];
			table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.DOWN) );
			x = rnd.nextInt(columns);
			y = rnd.nextInt(rows);
			r = rnd.nextInt(len);
			enwd = wo.stringArray[r][0];
			jawd = wo.stringArray[r][1];
			table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.RIGHT) );
		}
	}

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		if ( table.obtainWord(s) ) {
			System.out.println("you got '" + s + "'!");
		}
	}
}
