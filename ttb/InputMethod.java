package ttb;

/**
 * キーボードやネットワーク経由などの入力方法の抽象クラス
 * 
 * @author Kohara
 */
public abstract class InputMethod {
	
	/** 入力の変化を受け取るリスナー  */
	protected InputListener listener;
	
	/** 入力中の文字列 */
	protected String text;
	
	/**
	 * @return String 現在入力中の文字列
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * 入力のリスナーの登録
	 */
	public void setInputListener(InputListener listener) {
		this.listener = listener;
	}

	/**
	 * 入力中の文字列の変更はここで行う。
	 * @param newText 新しいテキスト
	 */
	protected void changeText(String newText) {
		text = newText;
		listener.textChanged(text);
	}
	
	/**
	 * 文字列の確定はここで行う。
	 * @param text 確定した文字列
	 */
	protected void inputString(String text) {
		listener.stringInputed(text);
	}

}
