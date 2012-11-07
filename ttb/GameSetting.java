package ttb;

/**
 * �Q�[���I�v�V�����ȂǂŐݒ�ł���ݒu�l���Ǘ����܂��B
 * 
 * @author Kohara
 */
public class GameSetting {
	
	// �V���O���g���p�^�[��
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
