package ttb.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 * 単語フィールドの表示クラス。
 * 
 * @author Kohara
 */
public class DisplayLetterTable extends AbstractComponent {
	
	/** 文字の配置 */
	protected char[] letters;
	/** 表示領域 */
	protected int x, y, width, height;
	
	/**
	 * コンストラクタ
	 * 
	 * @param rows 行数
	 * @param columns 列数
	 * @param x 始点X座標
	 * @param y 始点Y座標
	 */
	public DisplayLetterTable(GUIContext gc, int rows, int columns,
			int x, int y, int width, int height) {
		super(gc);
		letters = new char[rows*columns];
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
