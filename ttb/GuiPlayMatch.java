package ttb;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * �ΐ풆�� GUI ��񋟂���N���X�ł��B
 * 
 * @author Hirabara
 */
public class GuiPlayMatch extends Gui {
	
	/** �Q�[���ɎQ�����Ă���v���C���[ */
	private Unit[] players;
	
	public GuiPlayMatch(Unit[] players) {
		this.players = players;
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		// TODO Auto-generated method stub
		//��������
		g.setColor(new Color(0.94f,0.8f,0.7f,0.8f));
		g.fillRoundRect(210,85,565,505,10);
		g.fillRoundRect(20,95,160,380,10);
		g.fillRoundRect(140,10,520,67,30);
		//�X�R�A�p�̘g
		g.fillRoundRect(35,505,130,70,10);
	}

}
