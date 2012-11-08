package ttb;

import java.nio.channels.DatagramChannel;


/**
 * 自プレイヤーのクラス。
 * 
 * @author Kohara
 */
public class Player extends Unit {

	/** プレイヤーの入力を相手プレイヤーに送信するチャネル */
	private DatagramChannel channel;
	
	public Player(DatagramChannel channel) {
		this.channel = channel;
	}
}
