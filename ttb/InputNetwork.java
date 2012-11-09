package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static ttb.NetworkStatics.*;

/**
 * 対戦中にネットワーク経由で入力を行うクラス
 * 
 * @author Kohara
 */
public class InputNetwork extends InputMethod {
	
	/** 相手プレイヤーの入力を受信するチャネル */
	private DatagramChannel channel;
	
	public InputNetwork() throws IOException {
		channel = getChannel();
	}
	
	/**
	 * 対戦相手の入力を受信するチャンネルの作成
	 * これは別のステートでチャンネルを確立しなければならないが、テスト用
	 */
	private DatagramChannel getChannel() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.connect(new InetSocketAddress("localhost", 9001));
		return channel;
	}
	
	/**
	 * 更新処理
	 */
	public void update() {
		receivePacket();
	}
	
	/**
	 * パケットを受信し、処理する
	 */
	private void receivePacket() {
		ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
		try {
			// 受信処理
			channel.read(buf);
			char type = buf.getChar();
			int len = buf.getInt();
			byte[] strBuf = new byte[len];
			buf.get(strBuf);
			String str = new String(strBuf);
			// パケット処理
			switch ( type ) {
			case TYPE_TEXT_CHANGED: receivePacketTextChanged(str); break;
			case TYPE_STRING_INPUTED: receivePacketStringInputed(str); break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void receivePacketTextChanged(String text) {
		for ( InputListener listener : listeners ) {
			listener.textChanged(text);
		}
	}
	
	private void receivePacketStringInputed(String text) {
		for ( InputListener listener : listeners ) {
			listener.stringInputed(text);
		}
	}

}
