package ttb;

/**
 * �p�P������̃I�u�W�F�N�g�Ƃ��ĊǗ����邽�߂̃N���X�ł��B
 * 
 * @author Kohara
 */
public class Word {
	
	/** ���W */
	private int x, y;
	/** ���� */
	private int orient;
	/** �P���\�������� */
	private String str;
	
	public static final int ORIENT_RIGHT = 1;
	public static final int ORIENT_DOWN  = 2;
	
	public Word(String str, int x, int y, int orient) {
		this.str = str;
		this.x = x;
		this.y = y;
		this.orient = orient;
	}
	
	/**
	 * X���W��Ԃ��܂��B
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Y���W��Ԃ��܂��B
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * ������Ԃ��܂��B
	 */
	public int getOrient() {
		return orient;
	}
	
	/**
	 * �P���\���������Ԃ��܂��B
	 */
	public String getString() {
		return str;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( o instanceof Word ) {
			Word w = (Word)o;
			return (
					this.str.equals(w.getString())
					&& this.x == w.getX()
					&& this.y == w.getY()
					&& this.orient == w.getOrient()
					);
		} else {
			return false;
		}
	}
	
	/**
	 * �P�ꂪ�ʒu�I�ɏd�Ȃ邩�ǂ���
	 */
	public boolean conflictWith(Word other) {
		int tdx, tdy, odx, ody;
		tdx = tdy = odx = ody = 0;
		
		switch ( this.getOrient() ) {
		case ORIENT_RIGHT: tdx = 1; break;
		case ORIENT_DOWN: tdy = 1; break;
		}
		switch ( other.getOrient() ) {
		case ORIENT_RIGHT: odx = 1; break;
		case ORIENT_DOWN: ody = 1; break;
		}
		
		int tx = this.getX(), ty = this.getY();
		for ( int i=0; i<this.getLength(); ++i ) {
			int ox = other.getX(), oy = other.getY();
			for ( int j=0; j<other.getLength(); ++j ) {
				if ( tx == ox && ty == oy ) {
					return true;
				}
				ox += odx; oy += ody;
			}
			tx += tdx; ty += tdy;
		}
		return false;
	}
	
	/**
	 * �����̒������擾����
	 */
	public int getLength() {
		return str.toCharArray().length;
	}
}
