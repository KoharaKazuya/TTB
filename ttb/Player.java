package ttb;


/**
 * 自プレイヤーのクラス。
 * 
 * @author Kohara
 */
public class Player extends Unit implements InputListener {

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		// TODO Auto-generated method stub
		
	}

}
