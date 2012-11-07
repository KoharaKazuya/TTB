package ttb;


import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

/**
 * �v���C���[�̒��ۃN���X�B
 * 
 * @author Kohara
 */
public abstract class Unit implements InputListener{
	
	/** ���ݓ��͒��̕����� */
	protected String currentText = "";
	/** ���t�B�[���h�̕\�I�u�W�F�N�g */
	protected Table table;
	/**�P�ꃊ�X�g�̃N���X�̐����H*/
	WordList wo = new WordList();
	//�\�̏c�̒���
	public final static int rows=18;
	//�\�̉��̒���
	public final static int columns=22;

	public String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
								"o","p","q","r","s","t","u","v","w","x","y","z"};
	public int score=0;
	/**
	 * ���_���擾���܂��B
	 */
	public int getScore() {
		//�悭�킩��Ȃ������̂Ŏ����ŕύX���Ă݂�
//		return -table.getNumOfObtainableWords();
		return score;
	}
	/**
	 * ���_�̉��Z
	 * @param add
	 */
	public void addScore(int add){
		score += add*10;
	}
	
	/**
	 * ������s���������������H
	 */
	public boolean hasFinished() {
		return table.getNumOfObtainableWords() == 0;
	}
	
	/**
	 * ���ݓ��͒��̕�������擾���܂��B
	 */
	public String getText() {
		return currentText;
	}
	
	/**
	 * �\�̐���
	 */
	public void generateTable() {
		// �e�X�g�p : TODO
		if ( true ) {
			// table��xy��word��xy���t�ɂȂ��Ă�Ǝv���B
			table = new Table(rows, columns);
			/*�摜�ǂݍ���*/
			wo.getworddata();

			int len = wo.stringArray.length;
			int x, y, r;
			String enwd, jawd;
			for(int i=0;i<10000;i++){
		        Random rnd = new Random();
		        x = rnd.nextInt(columns);
		        y = rnd.nextInt(rows);
		        r = rnd.nextInt(len);
		        enwd = wo.stringArray[r][0];
		        jawd = wo.stringArray[r][1];
				table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.DOWN) );
		        x = rnd.nextInt(columns);
		        y = rnd.nextInt(rows);
		        r = rnd.nextInt(len);
		        enwd = wo.stringArray[r][0];
		        jawd = wo.stringArray[r][1];
				table.addObtainableWord( new Word(enwd, jawd, x, y, Word.Orient.RIGHT) );
			}
			
			//�e�X�g�p
			/*
			table.addObtainableWord( new Word("test", 0, 0, Word.Orient.DOWN) );
			table.addObtainableWord( new Word("eat", 18, 5, Word.Orient.RIGHT) );
			table.addObtainableWord( new Word("play", 18, 14, Word.Orient.DOWN) );
			table.addObtainableWord( new Word("eat", 7, 4, Word.Orient.RIGHT) );
			*/
		}
	}

	@Override
	public void textChanged(String text) {
		currentText = text;
	}

	@Override
	public void stringInputed(String s) {
		if ( table.obtainWord(s) ) {
//			System.out.println(table);
			addScore(s.length());
			System.out.println("you got '" + s + "'!");
		}
	}


	/**
	 * �\��Ԃ�
	 */
	public void stringdisplay(GUIContext container, Graphics g) throws SlickException {
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
}
