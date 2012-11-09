package ttb;

import java.util.ArrayList;

/**
 * キーボードやネットワーク経由などの入力方法の抽象クラス
 * 
 * @author Kohara
 */
public abstract class InputMethod {
	
	/** 入力の変化を受け取るリスナー  */
	protected ArrayList<InputListener> listeners = new ArrayList<InputListener>();
	
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
	public void addInputListener(InputListener listener) {
		listeners.add(listener);
	}

	/**
	 * 入力中の文字列の変更はここで行う。
	 * @param newText 新しいテキスト
	 */
	protected void changeText(String newText) {
		text = newText;
		for ( InputListener listener : listeners ) {
			listener.textChanged(text);
		}
	}
	
	/**
	 * 文字列の確定はここで行う。
	 * @param text 確定した文字列
	 */
	protected void inputString(String text) {
		for ( InputListener listener : listeners ) {
			listener.stringInputed(text);
		}
	}

}
