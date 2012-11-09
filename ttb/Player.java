package ttb;

/**
 * ���v���C���[�̃N���X�B
 * 
 * @author Kohara
 */
public class Player extends Unit {

	/** ���͂�ΐ푊��ɓ`���� */
	private InputSender sender;
	
	public Player(InputSender sender) {
		this.sender = sender;
	}

	@Override
	public void textChanged(String text) {
		super.textChanged(text);
		sender.sendTextChanged(text);
	}

	@Override
	public void stringInputed(String s) {
		super.stringInputed(s);
		sender.sendStringInputed(s);
	}
}
