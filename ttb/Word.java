package ttb;

/**
 * 英単語一つを一つのオブジェクトとして管理するためのクラスです。
 * 
 * @author Kohara
 */
public class Word {
	
	/** 向き */
	public enum Orient {
		RIGHT, DOWN,
	}
	
	/** 座標 */
	private int x, y;
	/** 向き */
	private Orient orient;
	/** 単語を表す文字列 */
	private String str;
	/**日本語訳*/
	private String jastr;
	
	public Word(String str, String jastr, int x, int y, Orient orient) {
		this.str = str;
		this.jastr = jastr;
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
	public Orient getOrient() {
		return orient;
	}
	
	/**
	 * 単語を表す文字列を返します。
	 */
	public String getString() {
		return str;
	}
	/**
	 * 日本語訳を返します
	 * @return
	 */
	public String getjaString() {
		return jastr;
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
		case RIGHT: tdx = 1; break;
		case DOWN: tdy = 1; break;
		}
		switch ( other.getOrient() ) {
		case RIGHT: odx = 1; break;
		case DOWN: ody = 1; break;
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
	 * 単語が壁に当たるかどうか
	 */
	public boolean conflictwall(int rows,int columns){
		int dx=0;
		int dy=0;
		switch ( this.getOrient() ) {
			case RIGHT: dx = 1; break;
			case DOWN: dy = 1; break;
		}
		int x = this.getX();
		int y = this.getY();
		for(int i=0; i<this.getLength(); i++){
			x += dx; y += dy;
		}
		if(x>columns || y>rows){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * 文字の長さを取得する
	 */
	public int getLength() {
		return str.toCharArray().length;
	}
}
