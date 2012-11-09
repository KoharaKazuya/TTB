package ttb;

import java.io.IOException;

import org.newdawn.slick.Color;
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
	/** ゲームロジックオブジェクト */
	protected LogicPlayMatch logic;
	/** ネットワーク管理オブジェクト */
	protected InputNetwork network;
	/** GUI */
	protected GuiPlayMatch gui;
	
	public GameStatePlayMatch(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		// テスト用 : TODO
		if ( true ) {
			// フォントの用意
			// TODO : 処理の軽さからスプライトが用意でき次第、SpriteSheetFontに置き換え
			java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24);
			Font font = new TrueTypeFont(awtFont, true);

			// テキスト表示領域の用意
			textField = new TextField(container, font, 285, 545, 420, 30);
			textField.setFocus(false);
		}
		
		// プレイヤーの準備
		player = new Player();
		opponent = new Opponent();
		
		// ゲームロジックの用意
		logic = new LogicPlayMatch(player, opponent);
		
		// ネットワーク管理オブジェクトの用意
		network = new InputNetwork();
		network.addInputListener(opponent);

		// 入力処理の用意
		InputSender sender = null;
		try {
			sender = new InputSender();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.addInputListener(player);
		input.addInputListener(sender);
		
		// GUIの用意
		gui = new GuiPlayMatch(new Unit[] { player, opponent });
		
		// ゲームスタート
		logic.start();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		gui.render(container, g);
		//テキスト
		g.setColor(Color.black);
		textField.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		logic.update();
		textField.setText(input.getText());
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
