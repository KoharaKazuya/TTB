package ttb;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class WordList {
	
	// �V���O���g���p�^�[��
	private static WordList instance = new WordList();
	private WordList() {}
	public static WordList getInstance() { return instance; }
	
	/*�������̃e�N�X�`��*/
	public Image word_data;
	public Image dark_word_data;
	public Image typed_word_data;
	
	//�P�ꃊ�X�g�ǉ����R�ɂǂ���
	public String[][] stringArray = {
			{"abandon","�̂Ă�"},
			{"absorb","�z������"},
			{"accommodate","���e����"},
			{"accompany","��������"},
			{"accomplish","����������"},
			{"accumulate","�~�ς���"},
			{"acquire","�擾����"},
			{"administer","�Ǘ��A��������"},
			{"adopt","�̗p����"},
			{"advertise","��`����"},
			{"affect","�e�����y�ڂ�"},
			{"afford","�]�T������"},
			{"alter","�ς���"},
			{"annoy","�C���C��������"},
			{"appeal","�i����"},
			{"approve","���F����"},
			{"arrest","�ߕ߂���"},
			{"assert","�咣����"},
			{"assign","�C������"},
			{"associate","���т���"},
			{"assume","���߂���"},
			{"assure","���S������"},
			{"attach","�Y�t����"},
			{"attain","�B������"},
			{"attempt","���݂�"},
			{"attribute","�����E�A����"},
			{"avoid","������"},
			{"blame","����"},
			{"boast","�������Ęb��"},
			{"cheat","�s��������"},
			{"cherish","��؂ɂ���"},
			{"claim","�v���E�咣����"},
			{"classify","���ނ���"},
			{"commit","�Ƃ��E�ς˂�"},
			{"compel","��������"},
			{"conceal","�B��"},
			{"conclude","���_�t����"},
			{"confirm","���������Ƃ��m�F����"},
			{"confront","�����͂�����"},
			{"conquer","��������"},
			{"constitute","���Ȃ����"},
			{"consume","�����"},
			{"contain","�܂ށE�}������"},
			{"contribute","��t�E�v������"},
			{"convert","�ς��"},
			{"convey","�`����"},
			{"convince","�[��������"},
			{"crawl","����"},
			{"cultivate","�k��"},
			{"decline","��������"},
			{"defeat","�ł�������"},
			{"describe","��������"},
			{"deserve","���l������"},
			{"despise","��������"},
			{"devote","�ς˂�"},
			{"diminish","��������"},
			{"dismiss","���ق���"},
			{"distribute","���z����"},
			{"disturb","�ז�������"},
			{"divide","��������"},
			{"drift","�����"},
			{"dwell","��炷�E�i�������j�l����"},
			{"earn","�҂�"},
			{"embody","�������"},
			{"employ","	�ق�"},
			{"encourage","��܂�"},
			{"endure","�ς���"},
			{"exceed","����"},
			{"exhaust","�g���ʂ���"},
			{"exhibit","�W������"},
			{"expand","�g�傷��"},
			{"exploit","�s���Ɉ����E��悷��"},
			{"explore","�T������"},
			{"fascinate","��������"},
			{"fasten","�Œ肷��"},
			{"flourish","�ɉh����"},
			{"govern","��������"},
			{"grasp","����"},
			{"impose","�ۂ�"},
			{"indicate","�w������"},
			{"induce","�����N����"},
			{"inherit","�󂯌p��"},
			{"injure","�����𕉂킹��"},
			{"interrupt","�ז�������"},
			{"invest","��������"},
			{"irritate","�C���C��������"},
			{"isolate","�Ǘ���������"},
			{"launch","�n�߂�"},
			{"manufacture","��������"},
			{"mold","�`���"},
			{"neglect","�ӂ�E��������"},
			{"obey","�]��"},
			{"obtain","����"},
			{"participate","�Q������"},
			{"penetrate","�N������"},
			{"perceive","�C�Â�"},
			{"persist","�Ŏ�����"},
			{"persuade","��������"},
			{"possess","���L����"},
			{"postpone","��������"},
			{"predict","�\�z����"},
			{"prescribe","��������E�K�肷��"},
			{"preserve","�ۑ�����"},
			{"prevent","�W����"},
			{"promote","���i����"},
			{"propose","��Ă���"},
			{"purchase","�w������"},
			{"pursue","�ǂ�"},
			{"regret","�������"},
			{"resemble","���Ă���"},
			{"resign","���C����"},
			{"resist","��R����"},
			{"ruin","�䖳���ɂ���"},
			{"seize","���ށE��������"},
			{"starve","�Q����"},
			{"stimulate","�h������"},
			{"strive","�w�͂���"},
			{"struggle","�������E��������"},
			{"submit","��o����"},
			{"substitute","�ւ���E���������"},
			{"suffer","�ꂵ�ށE���"},
			{"surpass","�`��菟��"},
			{"sustain","�ێ�����"},
			{"swell","�c���"},
			{"tease","���炩��"},
			{"tremble","�k����"},
			{"vary","�l�X�E�قȂ�"},
			{"wander","�����"},
			{"withdraw","�������߂�"},
			{"witness","�ڌ��҂���E�ڌ���"},
			{"administration","�^�c�C����"},
			{"ancestor","��c"},
			{"appetite","�H�~"},
			{"aspect","��"},
			{"astronomy","�V���w"},
			{"breast","��"},
			{"budget","�\�Z"},
			{"burden","�d��"},
			{"clue","��|����"},
			{"colleague","����"},
			{"committee","�ψ���"},
			{"commodity","���i�E�Y��"},
			{"compromise","�Ë�����"},
			{"conductor","�ē��l"},
			{"conference","��c"},
			{"confidence","���M"},
			{"conflict","����"},
			{"congress","�c��"},
			{"conscience","�ǐS"},
			{"contempt","���J"},
			{"contract","�_��"},
			{"courage","�E�C"},
			{"defect","����"},
			{"demand","���v�E�v������"},
			{"deposit","�a��"},
			{"descendant","�q��"},
			{"desire","��]"},
			{"despair","��]"},
			{"diplomat","�O����"},
			{"disaster","�ЊQ"},
			{"disease","�a�C"},
			{"district","�n��"},
			{"divorce","����"},
			{"election","�I��"},
			{"enterprise","����"},
			{"enthusiasm","�M��"},
			{"estate","���L�n�E��Y"},
			{"estimate","���ς���"},
			{"expense","��p"},
			{"facility","�{��"},
			{"faculty","�\��"},
			{"flesh","���́E�ʎ�"},
			{"foundation","��b�E�y��"},
			{"fuel","�R��"},
			{"function","�@�\"},
			{"grant","�⏕���E����"},
			{"gratitude","����"},
			{"grocery","�H���i�X"},
			{"incident","�o����"},
			{"industry","�Y��"},
			{"infant","�c��"},
			{"inquiry","�����E����"},
			{"instinct","�{�\"},
			{"institution","���x�E�g�D"},
			{"interior","����"},
			{"investigation","����"},
			{"labor","�J��"},
			{"literature","���w"},
			{"luxury","�ґ�"},
			{"merchant","���l"},
			{"notion","�l��"},
			{"obstacle","��Q"},
			{"occasion","�@��"},
			{"orbit","�O��"},
			{"ornament","�����i"},
			{"perspective","���_�E�ϓ_"},
			{"pity","����"},
			{"pollution","���Q"},
			{"poverty","�n�R"},
			{"prejudice","�Ό�"},
			{"privilege","����"},
			{"profit","���v"},
			{"property","���Y"},
			{"punishment","��"},
			{"rage","���{"},
			{"recess","�x��"},
			{"religion","�@��"},
			{"reputation","�]��"},
			{"savage","�c�E��"},
			{"scent","����"},
			{"scheme","�v��"},
			{"sculpture","����"},
			{"species","�푰"},
			{"storage","����"},
			{"surplus","�]��E����"},
			{"survey","����"},
			{"testimony","�،�"},
			{"threat","����"},
			{"tragedy","�ߌ�"},
			{"treaty","���"},
			{"trial","�ٔ�"},
			{"triumph","����"},
			{"victim","�]����"},
			{"wage","����"},
			{"welfare","����"},
			{"worship","���q"},
			{"abstract","���ۓI��"},
			{"abundant","�L�x��"},
			{"accurate","���m��"},
			{"adequate","�K�؂�"},
			{"alert","�p�S����"},
			{"appropriate","�K�؂�"},
			{"ashamed","�p��������"},
			{"awful","�Ђǂ�"},
			{"coarse","�e��"},
			{"complicated","���G��"},
			{"concrete","��̓I��"},
			{"conscious","�ӎ�����"},
			{"definite","���m��"},
			{"dumb","�����E���ŕ\���Ȃ�"},
			{"enormous","�c���"},
			{"exclusive","�r���I��"},
			{"federal","�A�M��"},
			{"flexible","�_���"},
			{"fundamental","���{�I��"},
			{"genuine","�{����"},
			{"guilty","�߈����̂���"},
			{"grave","�d��ȁE��"},
			{"hostile","�G�ӂ̂���"},
			{"immense","�����"},
			{"intense","������"},
			{"intimate","�e����"},
			{"keen","�M�S��"},
			{"legal","���@�ȁE�@����"},
			{"mature","���n����"},
			{"medieval","������"},
			{"mutual","���݂�"},
			{"numerous","��������"},
			{"obscure","�s���Ă�"},
			{"obvious","���炩��"},
			{"peculiar","���"},
			{"plain","���炩�ȁE�����ĂȂ�"},
			{"precise","���m��"},
			{"primary","�ł��d�v��"},
			{"primitive","���n�I��"},
			{"principal","�d�v��"},
			{"prompt","�v����"},
			{"radical","�}�i�I��"},
			{"rational","�����I��"},
			{"routine","�����܂��"},
			{"rural","�c�ɂ�"},
			{"rude","�����"},
			{"sacred","�_����"},
			{"sheer","�S���́E���S��"},
			{"steady","������"},
			{"steep","�������E�}��"},
			{"subtle","������"},
			{"suitable","�K����"},
			{"summary","�v��"},
			{"supreme","�ō���"},
			{"tender","�₳�����E�_�炩��"},
			{"urban","�s���"},
			{"vague","�����܂���"},
			{"vast","�L���"},
			{"vicious","�c�E��"},
			{"vivid","�N����"},
			{"merely","�P��"},
	};
	
	/**
	 * �e�N�X�`���̓ǂݎ��
	 */
	public void getworddata(){
			try {
				word_data = new Image("data/0.png");
				typed_word_data = new Image("data/0.png");
				dark_word_data = new Image("data/00.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
}