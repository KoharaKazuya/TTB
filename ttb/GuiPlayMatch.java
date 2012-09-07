package ttb;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

/**
 * 対戦中の GUI を提供するクラスです。
 * 
 * @author Hirabara
 */
public class GuiPlayMatch extends Gui {
	
	/** ゲームに参加しているプレイヤー */
	private Unit[] players;
	
	public GuiPlayMatch(Unit[] players) {
		this.players = players;
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		// TODO Auto-generated method stub

	}

}
