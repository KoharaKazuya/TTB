package ttb;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * �ΐ풆�� GUI ��񋟂���N���X�ł��B
 * 
 * @author Hirabara
 */
public class GuiPlayMatch extends Gui {
	
	/** �Q�[���ɎQ�����Ă���v���C���[ */
	private Unit[] players;
	/** �w�i�摜 */
	private Image backgroundImage;
	/** ���ݕ\�����̃X�R�A�̐��� */
	int intscore = 0;
	
	public GuiPlayMatch(Unit[] players) throws SlickException {
		this.players = players;
		backgroundImage = new Image("data/colc.jpg");
		// WordList ���̉摜�f�[�^���������i���[�h�j
		WordList.getInstance().getworddata();
	}

	@Override
	public void render(GUIContext container, Graphics g) {
		backgroundImage.draw();
		//��������
		g.setColor(new Color(0.94f,0.8f,0.7f,0.8f));
		g.fillRoundRect(210,85,565,505,10);
		g.fillRoundRect(20,95,160,380,10);
		g.fillRoundRect(140,10,520,67,30);
		//�X�R�A�p�̘g
		g.fillRoundRect(35,505,130,70,10);
		renderTable(container, g);
		renderScore(container, g);
	}

	/**
	 * �\��`��
	 */
	protected void renderTable(GUIContext container, Graphics g) {
		Table table = players[0].getTable();
		WordList wo = WordList.getInstance();
		char str = 0;
		g.setColor(Color.black);
		for ( int row=0; row<table.rows; ++row ) {
			for ( int col=0; col<table.columns; ++col ) {
				str = table.getLetters()[row*table.columns + col];
				String word = String.valueOf(str);
				if(!table.getIsObtainedTable()[row*table.columns + col]){
					wo.word_data.draw(230+col*24,99+row*24, 0.76f);
				}
				else{
					wo.dark_word_data.draw(230+col*24,99+row*24, 0.76f);
				}
				if(!word.equals("1")){
					g.drawString(word, 235+col*24,101+row*24);
				}
			}
		}
		//�ł����񂾒P��̕\��
		g.drawString(table.en,70,400);
		//���{��Ή�����
		//g.drawString("table.ja",100,450);
	}
	
	/**
	 * ���_��`��
	 */
	protected void renderScore(GUIContext container, Graphics g) {
		for ( Unit p : players ) {
			//���_�̕\��
			int nowscore = p.getScore();
			if(intscore<nowscore) intscore++;
			String score = String.valueOf(intscore);
			g.drawString(score, 95, 530);
		}
	}

}
