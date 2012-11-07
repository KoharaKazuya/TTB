package ttb;

/**
 * �p�P�b�g�̑���M���Ǘ�����N���X�B
 * 
 * @author Kohara
 */
public class Network {
	
	/** ���̓C�x���g���󂯎�郊�X�i�[ */
	private InputListener listener;
	
	/**
	 * �ΐ풆�Ƀp�P�b�g����M�������ɓ��̓C�x���g�𔭐������܂��B
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
