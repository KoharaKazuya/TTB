package ttb;

/**
 * ゲームオプションなどで設定できる設置値を管理します。
 * 
 * @author Kohara
 */
public class GameSetting {
	
	// シングルトンパターン
	private static GameSetting instance = new GameSetting();
	private GameSetting() {}
	public static GameSetting getInstance() { return instance; }
	
	private int tableRows = 18;
	private int tableColumns = 22;
	
	public int getTableRows() {
		return tableRows;
	}
	public int getTableColumns() {
		return tableColumns;
	}
}
