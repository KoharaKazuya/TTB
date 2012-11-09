package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static ttb.NetworkStatics.*;

/**
 * �ΐ풆�̓��͂𑊎�v���C���[�ɑ���N���X
 * InputSender �� InputNetwork �ɑ΂��ăp�P�b�g�𑗂�
 * 
 * @author Kohara
 * @see InputNetwork
 */
public class InputSender implements InputListener {
	
	/** �v���C���[�̓��͂𑊎�v���C���[�ɑ��M����`���l�� */
	private DatagramChannel channel;
	
	public InputSender() throws IOException {
		channel = getChannel();
	}
	
	/**
	 * �ΐ푊��Ɏ����̓��͂𑗐M����`�����l���̍쐬
	 * ����͕ʂ̃X�e�[�g�Ń`�����l�����m�����Ȃ���΂Ȃ�Ȃ����A�e�X�g�p
	 */
	private DatagramChannel getChannel() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.connect(new InetSocketAddress("localhost", 9000));
		return channel;
	}
	
	@Override
	/**
	 * ���͒������񂪕ύX���ꂽ���Ƃ�`����
	 */
	public void textChanged(String text) {
		sendStringPacket(TYPE_TEXT_CHANGED, text);
	}
	
	@Override
	/**
	 * ���͕����񂪊m�肵�����Ƃ�`����
	 */
	public void stringInputed(String s) {
		sendStringPacket(TYPE_STRING_INPUTED, s);
	}
	
	/**
	 * �p�P�b�g�𐶐����đ���
	 */
	private void sendStringPacket(char type, String str) {
		ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
		byte[] strBuf = str.getBytes();
		buf.putChar(type);
		buf.putInt(strBuf.length);
		buf.put(strBuf);
		try {
			channel.write(buf);
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
