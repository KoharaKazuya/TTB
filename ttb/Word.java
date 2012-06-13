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
		// TODO
		return false;
	}
}
