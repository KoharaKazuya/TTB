package ttb;

import java.nio.channels.DatagramChannel;


/**
 * ���v���C���[�̃N���X�B
 * 
 * @author Kohara
 */
public class Player extends Unit {

	/** �v���C���[�̓��͂𑊎�v���C���[�ɑ��M����`���l�� */
	private DatagramChannel channel;
	
	public Player(DatagramChannel channel) {
		this.channel = channel;
	}
}
