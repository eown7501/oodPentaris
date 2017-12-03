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

	/** Controller �� ����������� �ʱ�ȭ �մϴ�. */
	public void init() {
		GameBoard1P = new GameBoard1P(this);

	}

	public void init2() {
		GameBoard2P = new GameBoard2P(this);
	}

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

	/** 2P Game �� �����մϴ�. */
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
	 * soloGameBoard �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void draw(Graphics g) {
		GameBoard1P.draw(g);
	}

	public void draw2P(Graphics g) {
		GameBoard2P.draw(g);
	}

	public void drawSolo(Graphics g) {
		GameBoardSolo.drawSolo(g);
	}
	
	public void drawAI(Graphics g) {
		gameBoardAI.draw(g);
		gameBoardAIP.draw(g);
	}

	/** totalFrame �� update �޼ҵ带 �����մϴ�. */
	public void update() {
		totalFrame.update();
	}

	/** ȸ�� ����� �����մϴ�. */
	public void spin1P() {
		GameBoard1P.spin();
		update();
	}

	public void spin2P() {
		GameBoard2P.spin();
		update();
	}

	public void spinSolo() {
		GameBoardSolo.spin();
		update();
	}

	/** �����̵� ����� �����մϴ�. */
	public void moveLeft1P() {
		GameBoard1P.moveLeft();
		update();
	}

	public void moveLeft2P() {
		GameBoard2P.moveLeft();
		update();
	}

	public void moveLeftSolo() {
		GameBoardSolo.moveLeft();
		update();
	}

	/** ������ �̵� ����� �����մϴ�. */
	public void moveRight1P() {
		GameBoard1P.moveRight();
		update();
	}

	public void moveRight2P() {
		GameBoard2P.moveRight();
		update();
	}

	public void moveRightSolo() {
		GameBoardSolo.moveRight();
		update();
	}

	/** �Ʒ��̵� ����� �����մϴ�. */
	public void moveDown1P() {
		GameBoard1P.moveDown();
		update();
	}

	public void moveDown2P() {
		GameBoard2P.moveDown();
		update();
	}

	public void moveDownSolo() {
		GameBoardSolo.moveDown();
		update();
	}

	/** �ٷγ��� ����� �����մϴ�. */
	public void fastDown1P() {
		GameBoard1P.fastDown();
		update();
	}

	public void fastDown2P() {
		GameBoard2P.fastDown();
		update();
	}

	public void fastDownSolo() {
		GameBoardSolo.fastDown();
		update();
	}

	/** Game �� �Ͻ����� �մϴ�. */
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

	/** Game �� �簳 �մϴ�. */
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
	
	public void resumeAI() {
		gameBoardAI.resume();
		gameBoardAIP.resume();
		totalFrame.showAIGamePanel();
		update();
	}
	

	/** Game �� ����� �մϴ�. */
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
	
	/** ������� ������ ����ϴ�. 
	 * 
	 * @author ������
	 * @return int Type�� score�� ��ȯ�մϴ�. */
	public int getScore() {
		return GameBoardSolo.getScore();
	}

	/** SoloGame Over�ϸ� ȣ��˴ϴ�. */
	public void soloGameOver() {
		totalFrame.soloGameOver();
	}

	/** SoloGame Over�ϸ� ȣ��˴ϴ�. */
	public void GameOver2P() {
		totalFrame.ZPGameLose();
	}
	
	public void GameOverAI() {
		gameBoardAI.start = false;
		gameBoardAIP.start = false;
		totalFrame.AIGameLose();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		totalFrame.showMainPanel();
	}
	
	public void spinAI() {
		gameBoardAIP.spin();
		update();
	}
	
	public void moveRightAI() {
		gameBoardAIP.moveRight();
		update();
	}
	
	public void moveLeftAI() {
		gameBoardAIP.moveLeft();
		update();
	}
	
	public void moveDownAI() {
		gameBoardAIP.moveDown();
		update();
	}
	
	public void fastDownAI() {
		gameBoardAIP.fastDown();
		update();
	}
	
}
