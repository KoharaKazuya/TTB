package ttb;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

/**
 * ゲームを実行するためのクラス。
 * 
 * @author Kohara
 */
public class GameStatePlayMatch extends BasicGameState {
	
	/** ステートID */
	private int stateID;
	/** 動作確認用のテキストフィールド */
	protected TextField textField;
	/** キーボードからの単語入力 */
	protected InputWord input;
	/** プレイヤーオブジェクト */
	protected Player player;
	/** 敵プレイヤーオブジェクト */
	protected Opponent opponent;
	/** GUI */
	protected GuiPlayMatch gui;

	public GameStatePlayMatch(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		/* ### 動作確認テスト用 ### */
		if ( true ) {
			// フォントの用意
			// TODO : 処理の軽さからスプライトが用意でき次第、SpriteSheetFontに置き換え
			java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24);
			Font font = new TrueTypeFont(awtFont, true);

			// テキスト表示領域の用意
			textField = new TextField(container, font, 10, 10, 100, 100);
			textField.setFocus(false);
		}
		/* ### ### */
		
		// プレイヤーの準備
		player = new Player();
		opponent = new Opponent();

		// 入力処理の用意
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.setInputListener(player);
		
		// GUIの用意
		gui = new GuiPlayMatch();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		gui.render(container, g);
		textField.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		textField.setText(input.getText());
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
