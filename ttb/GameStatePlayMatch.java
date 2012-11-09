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
	/** ネットワーク経由の入力オブジェクト */
	protected InputNetwork receiver;
	/** ネットワーク経由の送信オブジェクト */
	protected InputSender sender;
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

		// 入力処理の用意
		
		// ネットワーク管理オブジェクトの用意
		try {
			receiver = new InputNetwork();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		// ネットワーク経由の送信オブジェクト用意
		try {
			sender = new InputSender();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// リスナーの登録
		input = new InputWord();
		container.getInput().addKeyListener(input);
		input.addInputListener(player);
		input.addInputListener(sender);
		receiver.addInputListener(opponent);
		startReceiver(receiver);
		
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
	
	/**
	 * パケット受信を監視するスレッドを作成する
	 */
	private void startReceiver(final InputNetwork receiver) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				while ( true ) {
					receiver.update();
				}
			}
		})).start();
	}

}
