package ttb;

/**
 * 対戦中にネットワーク経由で入力を行うクラス
 * 
 * @author Kohara
 */
public class InputNetwork extends InputMethod {
	
	private void receivePacketTextChanged(String text) {
		listener.textChanged(text);
	}
	
	private void receivePacketStringInputed(String text) {
		listener.stringInputed(text);
	}

}
