package ttb.client;

/**
 * �L�[�{�[�h���͂Ȃǂ̓��̓C�x���g���󂯕t����C���^�[�t�F�[�X�B
 * 
 * @author Kohara
 */
public interface InputListener {
	
	/**
	 * ���ݓ��͒��̕����񂪕ω����邽�тɌĂяo����܂��B
	 * @param text �V����������
	 */
	public void textChanged(String text);
	
	/**
	 * ���͕�������m�肵���Ƃ��ɌĂяo����܂��B
	 * @param s �m�肵��������
	 */
	public void stringInputed(String s);

}
