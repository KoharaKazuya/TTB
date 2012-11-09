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

	@Override
	public void textChanged(String text) {
		super.textChanged(text);
		sender.sendTextChanged(text);
	}

	@Override
	public void stringInputed(String s) {
		super.stringInputed(s);
		sender.sendStringInputed(s);
	}
}
