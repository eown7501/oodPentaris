package controller;

import java.awt.Graphics;
import model.GameBoard1P;
import model.GameBoard2P;
import model.GameBoardSolo;
import view.ViewTotalFrame;
import AI.GameBoardAI;

/**
 * �� Controller Ŭ������ GameBoard Class �� ViewTotalFrame Class �� ������ ����մϴ�.
 * ViewTotalFrame ��ü�� GameBoard ��ü�� ���� ����� Controller ��ü���� �����ϰų� ���޹޽��ϴ�.
 * 
 * @author �Ž���
 */
public class Controller {

	/** ����� ���� TotalFrame Type �� �����Դϴ�. */
	private ViewTotalFrame totalFrame;
	/** ����� ������ GameBoardSolo Type �� �����Դϴ�. */
	private GameBoard1P GameBoard1P;
	/** GameMode �� ��Ÿ�� Int Type �����Դϴ�. */
	private GameBoard2P GameBoard2P;
	/** GameMode �� ��Ÿ�� Int Type �����Դϴ�. */
	private GameBoardSolo GameBoardSolo;
	/** ����� ������ GameBoardAI Ÿ���� ���� �Դϴ�. */
	private GameBoardAI gameBoardAI;
	/** ����� ������ GameBoardAI Ÿ���� ���� �Դϴ�. */
	private GameBoardAI gameBoardAIP;
	/** GameMode �� ��Ÿ�� Int Type �����Դϴ�. */
	public int gameMode;

	/** ViewTotalFrame�� �����Ǵ� Controller �� �����մϴ�. */
	public Controller() {
		gameMode = 0;
		totalFrame = new ViewTotalFrame(this);
	}

	/**
	 * 1P Controller �� ����������� �ʱ�ȭ �մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void init() {
		GameBoard1P = new GameBoard1P(this);

	}

	/**
	 * 2P Controller �� ����������� �ʱ�ȭ �մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void init2() {
		GameBoard2P = new GameBoard2P(this);
	}

	/** Controller �� ����������� �ʱ�ȭ �մϴ�. */
	public void initSolo() {
		GameBoardSolo = new GameBoardSolo(this);

	}

	public void initAI() {
		gameBoardAI = new GameBoardAI(this);
		gameBoardAIP = new GameBoardAI(this);
	}

	/** Solo Game�� �����մϴ�. */
	public void startSoloGame() {
		initSolo();
		gameMode = 1;
		GameBoardSolo.startSoloGame();
		totalFrame.showSoloGamePanel();
	}

	/**
	 * 2P Game�� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void start2PGame() {
		init();
		init2();
		gameMode = 2;
		GameBoard1P.startGame();
		GameBoard2P.startGame();
		totalFrame.show2PGamePanel();

	}

	/** AI Game �� �����մϴ�. */
	public void startAIGame() {
		initAI();
		gameMode = 3;
		totalFrame.gameMode = 3;
		gameBoardAI.startAIGame();
		gameBoardAIP.startPlayerGame();
		totalFrame.showAIGamePanel();
	}

	/**
	 * GameBoard1P �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @author �۹μ�
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void draw(Graphics g) {
		GameBoard1P.draw(g);
	}

	/**
	 * GameBoard2P �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @author �۹μ�
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void draw2P(Graphics g) {
		GameBoard2P.draw(g);
	}

	/**
	 * soloGameBoard �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void drawSolo(Graphics g) {
		GameBoardSolo.drawSolo(g);
	}

	/**
	 * gameBoardAI, gameBoardAIP �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void drawAI(Graphics g) {
		gameBoardAI.draw(g);
		gameBoardAIP.draw(g);
	}

	/** totalFrame �� update �޼ҵ带 �����մϴ�. */
	public void update() {
		totalFrame.update();
	}

	/**
	 * 1P�� ȸ�� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void spin1P() {
		GameBoard1P.spin();
		update();
	}

	/**
	 * 2P�� ȸ�� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void spin2P() {
		GameBoard2P.spin();
		update();
	}

	/** ȸ�� ����� �����մϴ�. */
	public void spinSolo() {
		GameBoardSolo.spin();
		update();
	}

	/**
	 * 1P�� �����̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveLeft1P() {
		GameBoard1P.moveLeft();
		update();
	}

	/**
	 * 2P�� �����̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveLeft2P() {
		GameBoard2P.moveLeft();
		update();
	}

	/** �����̵� ����� �����մϴ�. */
	public void moveLeftSolo() {
		GameBoardSolo.moveLeft();
		update();
	}

	/**
	 * 1P�� ������ �̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveRight1P() {
		GameBoard1P.moveRight();
		update();
	}

	/**
	 * 2P�� ������ �̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveRight2P() {
		GameBoard2P.moveRight();
		update();
	}

	/** ������ �̵� ����� �����մϴ�. */
	public void moveRightSolo() {
		GameBoardSolo.moveRight();
		update();
	}

	/**
	 * 1P�� �Ʒ��̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveDown1P() {
		GameBoard1P.moveDown();
		update();
	}

	/**
	 * 2P�� �Ʒ��̵� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void moveDown2P() {
		GameBoard2P.moveDown();
		update();
	}

	/** �Ʒ��̵� ����� �����մϴ�. */
	public void moveDownSolo() {
		GameBoardSolo.moveDown();
		update();
	}

	/**
	 * 1P�� �ٷγ��� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void fastDown1P() {
		GameBoard1P.fastDown();
		update();
	}

	/**
	 * 2P�� �ٷγ��� ����� �����մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void fastDown2P() {
		GameBoard2P.fastDown();
		update();
	}

	/** �ٷγ��� ����� �����մϴ�. */
	public void fastDownSolo() {
		GameBoardSolo.fastDown();
		update();
	}

	/**
	 * 2P Game �� �Ͻ����� �մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void pause() {
		GameBoard1P.pause();
		GameBoard2P.pause();
		totalFrame.showPausePanel();
	}

	/** Game �� �Ͻ����� �մϴ�. */
	public void pauseSolo() {
		GameBoardSolo.pause();
		totalFrame.showPausePanelSolo();
	}

	/** Game �� �Ͻ����� �մϴ�. */
	public void pauseAI() {
		gameBoardAIP.pause();
		gameBoardAI.pause();
		totalFrame.showPausePanelAI();
		update();
	}

	/**
	 * 2P Game �� �簳 �մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void resume() {
		GameBoard1P.resume();
		GameBoard2P.resume();
		totalFrame.show2PGamePanel();
		update();
	}

	/** Game �� �簳 �մϴ�. */
	public void resumeSolo() {
		GameBoardSolo.resume();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** Game �� �簳 �մϴ�. */
	public void resumeAI() {
		gameBoardAI.resume();
		gameBoardAIP.resume();
		totalFrame.showAIGamePanel();
		update();
	}

	/**
	 * 2P Game �� ����� �մϴ�.
	 * 
	 * @author �۹μ�
	 */
	public void restart() {
		GameBoard1P.restart();
		GameBoard2P.restart();
		totalFrame.show2PGamePanel();
		update();
	}

	/** Game �� ����� �մϴ�. */
	public void restartSolo() {
		GameBoardSolo.restart();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** Game �� ����� �մϴ�. */
	public void restartAI() {
		gameBoardAI.restart();
		gameBoardAIP.restart();
		totalFrame.showAIGamePanel();
		update();
	}

	/** �������� ���ư��ϴ�. */
	public void goMain() {
		totalFrame.showMainPanel();
	}

	/**
	 * ������� ������ ����ϴ�.
	 * 
	 * @author ������
	 * @return int Type�� score�� ��ȯ�մϴ�.
	 */
	public int getScore() {
		return GameBoardSolo.getScore();
	}

	/**
	 * AI GAME ���� Player�� ������ ����ϴ�.
	 * 
	 * @return int Type�� score�� ��ȯ�մϴ�.
	 */
	public int getAIScore() {
		return gameBoardAIP.getScore();
	}

	/** SoloGame Over�ϸ� ȣ��˴ϴ�. */
	public void soloGameOver() {
		totalFrame.soloGameOver();
	}

	/**
	 * * 2P Game�� game over�ϸ� ȣ��˴ϴ�.
	 * 
	 * @author �۹μ�
	 * @param player
	 *            1P �� 2P �� ��Ÿ���� Win Lose�� �����մϴ�.
	 * 
	 */

	public void GameOver2P(int player) {
		GameBoard1P.start = false;
		GameBoard2P.start = false;
		totalFrame.ZPGameLose(player);
	}

	/** 
	 * AI Game�� game over �ϸ� ȣ��˴ϴ�.
	 * @param gameMode - � ��ü�� ȣ���ߴ����� �˾Ƴ� ���Դϴ�.
	 */
	public void GameOverAI(int gameMode) {
		gameBoardAI.start = false;
		gameBoardAIP.start = false;
		totalFrame.AIGameLose(gameMode);
	}

	/** ȸ������� �����մϴ� . */
	public void spinAI() {
		gameBoardAIP.spin();
		update();
	}

	/** ������ �̵������ �����մϴ�. */
	public void moveRightAI() {
		gameBoardAIP.moveRight();
		update();
	}

	/** ���� �̵������ �����մϴ�. */
	public void moveLeftAI() {
		gameBoardAIP.moveLeft();
		update();
	}

	/** �Ʒ� �̵������ �����մϴ�. */
	public void moveDownAI() {
		gameBoardAIP.moveDown();
		update();
	}

	/** �ٷγ��� ����� �����մϴ�. */
	public void fastDownAI() {
		gameBoardAIP.fastDown();
		update();
	}

	/** AI ���� �ٷγ�������� �����մϴ�. AI�� ���� ������ ������ ���˴ϴ�. */
	public void AIFastDown() {
		gameBoardAI.fastDown();
		update();
	}

}
