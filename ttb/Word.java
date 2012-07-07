package ttb;

/**
 * 英単語一つを一つのオブジェクトとして管理するためのクラスです。
 * 
 * @author Kohara
 */
public class Word {
	
	/** 座標 */
	private int x, y;
	/** 向き */
	private int orient;
	/** 単語を表す文字列 */
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
	 * X座標を返します。
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Y座標を返します。
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 向きを返します。
	 */
	public int getOrient() {
		return orient;
	}
	
	/**
	 * 単語を表す文字列を返します。
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
	 * 単語が位置的に重なるかどうか
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
	 * 文字の長さを取得する
	 */
	public int getLength() {
		return str.toCharArray().length;
	}
}
