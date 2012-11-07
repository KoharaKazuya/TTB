package ttb;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;


/**
 * 対戦中のルールを定めます。
 * 
 * @author Kohara
 */
public class LogicPlayMatch extends Logic {
	//スコア。gui的に作るために用意
	int intscore = 0;
	
	protected Unit[] players;
	
	/**
	 * コンストラクタ
	 * @param p1 プレイヤー1
	 * @param p2 プレイヤー2
	 */
	public LogicPlayMatch(Player p1, Opponent p2) {
		
//		players = new Unit[2];
//		players[0] = p1; players[1] = p2;
		
		/*1人プレイ実験用*/
		players = new Unit[1];
		players[0] = p1;
	}

	@Override
	public void update() {
		int winner = whoIsWinner();
		if ( winner != -1 ) {
			finish(winner);
		}
	}
	
	/**
	 * ゲーム表の描写
	 * @param container
	 * @param g
	 */
	public void render(GUIContext container, Graphics g) {
		for ( Unit p : players ) {
			try {
				p.stringdisplay(container, g);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//得点の表示
			int nowscore = p.getScore();
			if(intscore<nowscore) intscore++;
			String score = String.valueOf(intscore);
			g.drawString(score, 95, 530);
		}
	}
	
	/**
	 * 対戦の開始
	 */
	public void start() {
		for ( Unit p : players ) {
			p.generateTable();
		}
	}
	
	/**
	 * 試合の終了
	 */
	protected void finish(int winner) {
	}
	
	/**
	 * 勝者の決定
	 * @return プレイヤー番号。未決着なら-1、ノーゲーム（1位タイがが存在）なら-2。
	 */
	protected int whoIsWinner() {
		if ( !haveAllPlayerFinished() ) {
			return -1;
		}
		
		// テスト用 : TODO
		if ( true ) {
			System.out.println("game!");
		}
		
		int winner = -1;
		int scoreOfWinner = Integer.MIN_VALUE;
		for ( int i=0; i<players.length; ++i ) {
			if ( scoreOfWinner < players[i].getScore() ) {
				if ( winner >= 0 ) {
					return -2;
				} else {
					winner = i;
					scoreOfWinner = players[i].getScore();
				}
			}
		}
		
		return winner;
	}
	
	/**
	 * 全てのプレイヤーが終了したか？
	 */
	private boolean haveAllPlayerFinished() {
		for ( Unit p : players ) {
			if ( !p.hasFinished() ) {
				return false;
			}
		}
		return true;
	}

}
