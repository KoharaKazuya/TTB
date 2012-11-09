package ttb;

/**
 * 対戦中にネットワーク経由で入力を行うクラス
 * 
 * @author Kohara
 */
public class InputNetwork extends InputMethod {
	
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
