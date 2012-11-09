package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 対戦中の入力を相手プレイヤーに送るクラス
 * InputSender が InputNetwork に対してパケットを送る
 * 
 * @author Kohara
 * @see InputNetwork
 */
public class InputSender implements InputListener {
	
	/** パケットの入出力時に生成するバッファのサイズ */
	private static final int BUFFER_SIZE = 50;
	/** パケットの種類 */
	private static final char TYPE_TEXT_CHANGED = 1;
	private static final char TYPE_STRING_INPUTED = 2;
	
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
	
	@Override
	/**
	 * 入力中文字列が変更されたことを伝える
	 */
	public void textChanged(String text) {
		sendStringPacket(TYPE_TEXT_CHANGED, text);
	}
	
	@Override
	/**
	 * 入力文字列が確定したことを伝える
	 */
	public void stringInputed(String s) {
		sendStringPacket(TYPE_STRING_INPUTED, s);
	}
	
	/**
	 * パケットを生成して送る
	 */
	private void sendStringPacket(char type, String str) {
		ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
		buf.put(str.getBytes());
		try {
			channel.write(buf);
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
