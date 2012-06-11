package ttb.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 * �P��t�B�[���h�̕\���N���X�B
 * 
 * @author Kohara
 */
public class DisplayLetterTable extends AbstractComponent {
	
	/** �����̔z�u */
	protected char[] letters;
	/** �\���̈� */
	protected int x, y, width, height;
	
	/**
	 * �R���X�g���N�^
	 * 
	 * @param rows �s��
	 * @param columns ��
	 * @param x �n�_X���W
	 * @param y �n�_Y���W
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
