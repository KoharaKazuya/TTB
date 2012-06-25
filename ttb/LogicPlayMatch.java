package ttb;


/**
 * �ΐ풆�̃��[�����߂܂��B
 * 
 * @author Kohara
 */
public class LogicPlayMatch extends Logic {
	
	protected Unit[] players;
	
	/**
	 * �R���X�g���N�^
	 * @param p1 �v���C���[1
	 * @param p2 �v���C���[2
	 */
	public LogicPlayMatch(Player p1, Opponent p2) {
		players = new Unit[2];
		players[0] = p1; players[1] = p2;
	}

	@Override
	public void update() {
		int winner = whoIsWinner();
		if ( winner != -1 ) {
			finish(winner);
		}
	}
	
	/**
	 * �ΐ�̊J�n
	 */
	public void start() {
		for ( Unit p : players ) {
			p.generateTable();
		}
	}
	
	/**
	 * �����̏I��
	 */
	protected void finish(int winner) {
	}
	
	/**
	 * ���҂̌���
	 * @return �v���C���[�ԍ��B�������Ȃ�-1�A�m�[�Q�[���i1�ʃ^�C�������݁j�Ȃ�-2�B
	 */
	protected int whoIsWinner() {
		if ( !haveAllPlayerFinished() ) {
			return -1;
		}
		
		// �e�X�g�p : TODO
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
	 * �S�Ẵv���C���[���I���������H
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
