package ttb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * �ΐ풆�̓��͂𑊎�v���C���[�ɑ���N���X
 * InputSender �� InputNetwork �ɑ΂��ăp�P�b�g�𑗂�
 * 
 * @author Kohara
 * @see InputNetwork
 */
public class InputSender {
	
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

}
