package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * 対戦中の入力を相手プレイヤーに送るクラス
 * InputSender が InputNetwork に対してパケットを送る
 * 
 * @author Kohara
 * @see InputNetwork
 */
public class InputSender {
	
	/** プレイヤーの入力を相手プレイヤーに送信するチャネル */
	private DatagramChannel channel;
	
	public InputSender() throws IOException {
		channel = getChannel();
	}
	
	/**
	 * 対戦相手に自分の入力を送信するチャンネルの作成
	 * これは別のステートでチャンネルを確立しなければならないが、テスト用
	 */
	private DatagramChannel getChannel() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.connect(new InetSocketAddress("localhost", 9000));
		return channel;
	}

}
