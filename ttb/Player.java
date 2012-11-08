package ttb;

/**
 * 自プレイヤーのクラス。
 * 
 * @author Kohara
 */
public class Player extends Unit {

	/** 入力を対戦相手に伝える */
	private InputSender sender;
	
	public Player(InputSender sender) {
		this.sender = sender;
	}
}
