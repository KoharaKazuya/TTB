package ttb.client;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

import ttb.GameStatePlayMatch;

/**
 * ゲームを実行するためのクラス。
 * クライアント側の対戦中のゲームを進行するプログラム。
 * 
 * @author Kohara
 */
public class GameStatePlayMatchClient extends GameStatePlayMatch {
	
	/** 動作確認用のテキストフィールド */
	protected TextField textField;
	/** キーボードからの単語入力 */
	protected InputWord input;
	/** プレイヤーオブジェクト */
	protected PlayerClient me, you;
	/** GUI */
	protected GuiPlayMatch gui;

	public GameStatePlayMatchClient(int stateID) {
		super(stateID);
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
		me = new PlayerClient();
		you = new PlayerClient();

		// 入力処理の用意
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.setInputListener(me);
		
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

}
