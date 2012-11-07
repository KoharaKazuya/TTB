package ttb;

/**
 * ゲーム内ルールを定める抽象クラス。
 * 
 * @author Kohara
 */
public abstract class Logic {

	/**
	 * フレームごとに呼び出される。
	 */
	public abstract void update();
}
