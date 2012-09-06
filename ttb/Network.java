package ttb;

/**
 * パケットの送受信を管理するクラス。
 * 
 * @author Kohara
 */
public class Network {
	
	/** 入力イベントを受け取るリスナー */
	private InputListener listener;
	
	/**
	 * 対戦中にパケットを受信した時に入力イベントを発生させます。
	 * @param listener
	 */
	public void addInputListener(InputListener listener) {
		this.listener = listener;
	}
	
	private void receivePacketTextChanged(String text) {
		listener.textChanged(text);
	}
	
	private void receivePacketStringInputed(String text) {
		listener.stringInputed(text);
	}

}
