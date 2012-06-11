package ttb.server;

/**
 * 対戦中のルールを定めます。
 * 
 * @author Kohara
 */
public class LogicPlayMatch extends Logic {
	
	protected PlayerServer[] players;
	
	/**
	 * コンストラクタ
	 * @param p1 プレイヤー1
	 * @param p2 プレイヤー2
	 */
	public LogicPlayMatch(PlayerServer p1, PlayerServer p2) {
		players = new PlayerServer[2];
		players[1] = p1; players[2] = p2;
		start();
	}

	@Override
	public void update() {
		int winner = whoIsWinner();
		if ( winner != -1 ) {
			finish(winner);
		}
	}
	
	/**
	 * 対戦の開始
	 */
	protected void start() {
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
		for ( PlayerServer p : players ) {
			if ( !p.hasFinished() ) {
				return false;
			}
		}
		return true;
	}

}
