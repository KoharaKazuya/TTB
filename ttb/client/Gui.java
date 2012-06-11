package ttb.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

/**
 * GUI を提供するクラスの抽象クラス。
 * 
 * @author Kohara
 */
abstract public class Gui {
	
	abstract public void render(GUIContext container, Graphics g);

}
