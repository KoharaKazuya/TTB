package ttb;

/**
 * �ΐ풆�Ƀl�b�g���[�N�o�R�œ��͂��s���N���X
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
