package ttb.client;

/**
 * キーボード入力などの入力イベントを受け付けるインターフェース。
 * 
 * @author Kohara
 */
public interface InputListener {
	
	/**
	 * 現在入力中の文字列が変化するたびに呼び出されます。
	 * @param text 新しい文字列
	 */
	public void textChanged(String text);
	
	/**
	 * 入力文字列を確定したときに呼び出されます。
	 * @param s 確定した文字列
	 */
	public void stringInputed(String s);

}
