package ttb;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * キーボードからの入力を受け付け、入力中の文字列、入力が確定した単語を管理します。
 * 
 * @author Kohara
 */
public class InputWord implements KeyListener {
	
	/** アルファベット判定用文字列 */
	protected final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/** 入力中の文字列 */
	protected String text;
	/** 入力の変化を受け取るリスナー（PlayerClientクラスが入る） */
	protected InputListener listener;
	
	public InputWord() {
		text = "";
	}
	
	/**
	 * @return String 現在入力中の文字列
	 */
	public String getText() {
		return text;
	}

	@Override
	/**
	 * 使いません。
	 * イベントを発生させるInputインスタンスを登録します。
	 */
	public void setInput(Input input) {
	}

	@Override
	/**
	 * 使いません。
	 * このインプットリスナーが入力を受け付けるかどうか確認します。
	 */
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	/**
	 * 使いません。
	 * 全てのインプットイベントの送信が完了したことを知らせます。
	 */
	public void inputEnded() {
	}

	@Override
	/**
	 * 使いません。
	 * インプットの処理の開始を知らせます。
	 */
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
		// EnterかSpaceで確定&削除
		if ( key == Keyboard.KEY_RETURN || key == Keyboard.KEY_SPACE ) {
			if ( !"".equals(text) ) {
				inputString(text);
			}
			changeText("");
		// BackSpaceで一文字削除（リピートはしない）
		} else if ( key == Keyboard.KEY_BACK ) {
			changeText(text.substring(0, Math.max(text.length()-1, 0)));
		// その他で文字入力。英小文字以外ははじく
		} else {
			if ( ALPHABET.indexOf(c) != -1 ) {
				changeText(text + c);
			}
		}
	}
	
	@Override
	public void keyReleased(int key, char c) {
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
