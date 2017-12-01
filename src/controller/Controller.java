package controller;

import java.awt.Graphics;
import model.GameBoard;
import model.GameBoardSolo;
import view.ViewTotalFrame;

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
	private GameBoard GameBoard;
	/** GameMode �� ��Ÿ�� Int Type �����Դϴ�. */
	private GameBoardSolo GameBoardSolo;
	/** GameMode �� ��Ÿ�� Int Type �����Դϴ�. */
	public int gameMode;

	/** ViewTotalFrame�� �����Ǵ� Controller �� �����մϴ�. */
	public Controller() {
		gameMode = 0;
		totalFrame = new ViewTotalFrame(this);
	}

	/** Controller �� ����������� �ʱ�ȭ �մϴ�. */
	public void init() {
		GameBoard = new GameBoard(this);

	}
	public void initSolo() {
		GameBoardSolo = new GameBoardSolo(this);

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
		gameMode = 2;
		GameBoard.startGame();
		totalFrame.show2PGamePanel();

	}

	/** AI Game �� �����մϴ�. */
	public void startAIGame() {

	}

	/**
	 * soloGameBoard �� draw �޼ҵ带 �����մϴ�.
	 * 
	 * @param g
	 *            - totalFrame���� ���� �Ű����� �Դϴ�. �� Graphics g�� GameBoard�� draw �޼ҵ忡
	 *            �����մϴ�.
	 */
	public void draw(Graphics g) {
		GameBoard.draw(g);
	}
	public void drawSolo(Graphics g) {
		GameBoardSolo.drawSolo(g);
	}

	/** totalFrame �� update �޼ҵ带 �����մϴ�. */
	public void update() {
		totalFrame.update();
	}

	/** ȸ�� ����� �����մϴ�. */
	public void spin() {
		GameBoard.spin();
		update();
	}
	public void spin2() {
		GameBoard.spin2();
		update();
	}
	public void spinSolo() {
		GameBoardSolo.spin();
		update();
	}
	/** �����̵� ����� �����մϴ�. */
	public void moveLeft() {
		GameBoard.moveLeft();
		update();
	}
	public void moveLeft2() {
		GameBoard.moveLeft2();
		update();
	}
	public void moveLeftSolo() {
		GameBoardSolo.moveLeft();
		update();
	}

	/** ������ �̵� ����� �����մϴ�. */
	public void moveRight() {
		GameBoard.moveRight();
		update();
	}
	public void moveRight2() {
		GameBoard.moveRight2();
		update();
	}
	public void moveRightSolo() {
		GameBoardSolo.moveRight();
		update();
	}

	/** �Ʒ��̵� ����� �����մϴ�. */
	public void moveDown() {
		GameBoard.moveDown();
		update();
	}
	public void moveDown2() {
		GameBoard.moveDown2();
		update();
	}
	public void moveDownSolo() {
		GameBoardSolo.moveDown();
		update();
	}

	/** �ٷγ��� ����� �����մϴ�. */
	public void fastDown() {
		GameBoard.fastDown();
		update();
	}
	public void fastDown2() {
		GameBoard.fastDown2();
		update();
	}
	public void fastDownSolo() {
		GameBoardSolo.fastDown();
		update();
	}
	
	/** Game �� �Ͻ����� �մϴ�. */
	public void pause() {
		GameBoard.pause();
		totalFrame.showPausePanel();
	}
	/** Game �� �Ͻ����� �մϴ�. */
	public void pauseSolo() {
		GameBoardSolo.pause();
		totalFrame.showPausePanel();
	}


	/** Game �� �簳 �մϴ�. */
	public void resume() {
		GameBoard.resume();
		totalFrame.show2PGamePanel();
		update();
	}
	/** Game �� �簳 �մϴ�. */
	public void resumeSolo() {
		GameBoardSolo.resume();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** Game �� ����� �մϴ�. */
	public void restart() {
		GameBoard.restart();
		totalFrame.show2PGamePanel();
		update();
	}
	/** Game �� ����� �մϴ�. */
	public void restartSolo() {
		GameBoardSolo.restart();
		totalFrame.showSoloGamePanel();
		update();
	}

	/** �������� ���ư��ϴ�. */
	public void goMain() {
		totalFrame.showMainPanel();
	}

	/** SoloGame Over�ϸ� ȣ��˴ϴ�. */
	public void soloGameOver() {
		totalFrame.soloGameOver();
	}
	/** SoloGame Over�ϸ� ȣ��˴ϴ�. */
	public void ZPGameOver() {
		totalFrame.ZPGameLose();		
	}

}
