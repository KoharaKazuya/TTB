package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static ttb.NetworkStatics.*;

/**
 * �ΐ풆�Ƀl�b�g���[�N�o�R�œ��͂��s���N���X
 * 
 * @author Kohara
 */
public class InputNetwork extends InputMethod {
	
	/** ����v���C���[�̓��͂���M����`���l�� */
	private DatagramChannel channel;
	
	public InputNetwork() throws IOException {
		channel = getChannel();
	}
	
	/**
	 * �ΐ푊��̓��͂���M����`�����l���̍쐬
	 * ����͕ʂ̃X�e�[�g�Ń`�����l�����m�����Ȃ���΂Ȃ�Ȃ����A�e�X�g�p
	 */
	private DatagramChannel getChannel() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.connect(new InetSocketAddress("localhost", 9001));
		return channel;
	}
	
	/**
	 * �X�V����
	 */
	public void update() {
		receivePacket();
	}
	
	/**
	 * �p�P�b�g����M���A��������
	 */
	private void receivePacket() {
		ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
		try {
			// ��M����
			channel.read(buf);
			char type = buf.getChar();
			int len = buf.getInt();
			byte[] strBuf = new byte[len];
			buf.get(strBuf);
			String str = new String(strBuf);
			// �p�P�b�g����
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
