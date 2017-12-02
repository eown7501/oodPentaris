package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * �� Class�� Solo Game Board, ���� Block, ���� Block ���� ������ Ŭ�����Դϴ�. Controller ���� �����
 * �ްų�, �����մϴ�.
 * 
 * @author �۹μ�
 *
 */
public class GameBoard2P implements Runnable {

	/** GameBoard�� Row �� ��Ÿ�� �����Դϴ�. */
	public static final int ROWS = 22;
	/** GameBoard�� Column �� ��Ÿ�� �����Դϴ�. */
	public static final int COLS = 10;
	/** �� Block�� Size�� ��Ÿ�� �����Դϴ�. */
	public static final int BLOCK_SIZE = 30;
	/** Block�� �ִ� ������ ��Ÿ�� �����Դϴ�. */
	public static final int BLOCK_MAX_NUM = 4;
	/** ����� �ްų� ������ Controller Type �����Դϴ�. */
	private Controller controller;
	/** ���� Block�� ������ �����Դϴ�. */
	/** ���� Block�� ������ �����Դϴ�. */
	private Block currentBlock;
	/** ���� Block�� ������ �����Դϴ�. */
	/** GameBoard�� ������ 2�����迭�Դϴ�. */
	private Block nextBlock;
	/** GameBoard�� ������ 2�����迭�Դϴ�. */

	/** Board�� ���� �ӽ÷� ������ �����Դϴ�. */
	private int[][] Board;
	/** Board�� ���� �ӽ÷� ������ �����Դϴ�. */
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] tempBoard;
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] NextBlockBoard;
	/** ������ ������ �����Դϴ�. */
	/** ������ ������ �����Դϴ�. */
	private int score;
	/** Level�� ������ �����Դϴ�. */
	/** Level�� ������ �����Դϴ�. */
	private int level;
	/** Start�� ���¸� ������ �����Դϴ�. */
	private boolean start;
	/** Start Time�� ������ �����Դϴ�. */
	private long startTime;
	/** End Time �� ������ �����Դϴ�. */
	private long endTime;
	/** Play Time �� ������ �����Դϴ�. */
	private double playTime;
	/** Pause�� ������ �ð�, �� Pause�� �ð��� ������ �����Դϴ�. */
	private long startPauseTime, pauseTime;

	/**
	 * GameBoardSolo �� �����մϴ�.
	 * 
	 * @param controller
	 *            - ����� ������ Controller �Դϴ�.
	 */
	public GameBoard2P(Controller controller) {
		this.controller = controller;
		initGameBoard();
	}

	/** GameBoard �� �ʱ�ȭ �մϴ�. */
	private void initGameBoard() { // ���Ӻ��� �ʱ���� ����
		start = true;
		score = 0;
		level = 1;
		Board = new int[ROWS][COLS];
		tempBoard = new int[ROWS][COLS];
		for (int i = 0; i < Board.length; i++) {
			for (int j = 0; j < Board[i].length; j++) {
				Board[i][j] = -1;
				tempBoard[i][j] = -1;
			}
		}
		setCurrentBlock();
	}

	/** Solo Game �� �����մϴ�. */
	public void startGame() {
		Thread s = new Thread(this);
		s.start();
		setStartTime();

	}

	/**
	 * �������̽� Runnable�� �����ϰ��ִ� ��ü�� ����� thread�� �ۼ��ϸ�, thread�� �⵿�ϸ� , ��ü�� run �޼ҵ尡 �� ����
	 * ���� thread�� �ҷ����ϴ�.
	 */
	@Override
	public void run() {
		while (true) {
			if (start) {
				setLevel();
				drop();
				sleep();

			}
		}
	}

	/** Block �� �� ĭ ����Ʈ���ϴ�. */
	public void drop() {
		currentBlock.drop2P();
	}

	/** Level �� �����մϴ�. */
	public void setLevel() {
		if (level - 1 < score / 50) {
			if (level < 10)
				level++;
		}
	}

	public void sleep() {
		int speed2 = 0;
		if (level == 1)
			speed2 = 900;
		if (level == 2)
			speed2 = 810;
		if (level == 3)
			speed2 = 720;
		if (level == 4)
			speed2 = 630;
		if (level == 5)
			speed2 = 540;
		if (level == 6)
			speed2 = 450;
		if (level == 7)
			speed2 = 360;
		if (level == 8)
			speed2 = 270;
		if (level == 9)
			speed2 = 180;
		if (level == 10)
			speed2 = 90;
		try {
			Thread.sleep(speed2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Block �� �������� �����մϴ�.
	 * 
	 * @return �������� ������ Block �Դϴ�.
	 */

	public Block createRandomBlock2() {
		Random r = new Random();
		Block block = null;
		int rNum = r.nextInt(7);
		switch (rNum) {
		case 0:
			block = new BlockS(this);
			break;
		case 1:
			block = new BlockZ(this);
			break;
		case 2:
			block = new BlockI(this);
			break;
		case 3:
			block = new BlockL(this);
			break;
		case 4:
			block = new BlockJ(this);
			break;
		case 5:
			block = new BlockT(this);
			break;
		case 6:
			block = new BlockO(this);
			break;
		default:
			block = new BlockS(this);
			break;
		}
		return block;
	}

	/** ���� Block�� �����մϴ�. */
	public void setNextBlock2() {
		nextBlock = createRandomBlock2();
		NextBlockBoard = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock.coord2P.length; i++)
			NextBlockBoard[nextBlock.coord2P[i].getX() + 2][nextBlock.coord2P[i].getY() + 1] = 2;
	}

	/** ���� Block�� �����մϴ�. */
	public void setCurrentBlock() {
		if (nextBlock == null)
			setNextBlock2();
		currentBlock = nextBlock;
		setNextBlock2();
	}

	/** Block���� ȸ������� �����ϴ�. */
	public void spin2() {
		currentBlock.performSpin2P();
	}

	/** Block���� ���� �̵������ �����ϴ�. */
	public void moveLeft2() {
		currentBlock.moveLeft2P();
	}

	/** Block ���� ������ �̵������ �����ϴ�. */
	public void moveRight2() {
		currentBlock.moveRight2P();
	}

	/** Block���� �Ʒ��� �̵������ �����ϴ�. */
	public void moveDown2() {
		currentBlock.moveDown2P();
	}

	/** Block���� �ٷζ���Ʈ���� ����� �����ϴ�. */
	public void fastDown2() {
		currentBlock.fastDown2P();
	}

	/** Controller�� update �޼ҵ带 �����մϴ�. */
	public void update() {
		controller.update();
	}

	/** Game �� Pause �մϴ�. */
	public void pause() {
		start = false;
		startPauseTime = System.nanoTime();
	}

	/** Game�� �簳�մϴ�. */
	public void resume() {
		start = true;
		pauseTime = System.nanoTime() - startPauseTime;
	}

	/** Game�� ������մϴ�. */
	public void restart() {
		initGameBoard();
		setStartTime();
	}

	/**
	 * GameBoard ȭ���� �׸��ϴ�.
	 * 
	 * @param g
	 *            - Controller���� ���޹��� Graphcis g �Դϴ�.
	 */
	public void draw(Graphics g) {

		drawBoard2(g);
		drawNextBlock2(g);
		drawScore2(g);
		drawLevel2(g);
		drawPlayTime2(g);
	}

	/**
	 * GameBoard�� Board �κ��� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	public void drawBoard2(Graphics g) {
		for (int i = 2; i < Board.length; i++) {
			for (int j = 0; j < Board[i].length; j++) {
				int color = Board[i][j];
				switch (color) {
				case 0:
					g.setColor(new Color(224, 102, 245));
					break;
				case 1:
					g.setColor(new Color(244, 217, 245));
					break;
				case 2:
					g.setColor(new Color(244, 36, 51));
					break;
				case 3:
					g.setColor(new Color(36, 244, 0));
					break;
				case 4:
					g.setColor(new Color(0, 92, 244));
					break;
				case 5:
					g.setColor(new Color(0, 244, 235));
					break;
				case 6:
					g.setColor(new Color(245, 180, 0));
					break;

				default:
					if (j % 2 == 0)
						g.setColor(new Color(66, 66, 66, 80));
					else
						g.setColor(new Color(66, 66, 66, 140));
					break;
				}

				g.fillRoundRect(10 + (j) * BLOCK_SIZE, 30 + (i - 2) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5, 5);
				g.setColor(new Color(66, 66, 66, 180));
				g.drawRoundRect(10 + (j) * BLOCK_SIZE, 30 + (i - 2) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5, 5);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(6));
				g2.drawRoundRect(10, 30, BLOCK_SIZE * 10, BLOCK_SIZE * 20, 5, 5);
				g2.setStroke(new BasicStroke(2));

			}
		}
	}

	/**
	 * GameBoard�� ���� Block�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawNextBlock2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Next", 60 + 10 * BLOCK_SIZE, 65);
		for (int i = 0; i < NextBlockBoard.length; i++) {
			for (int j = 0; j < NextBlockBoard[i].length; j++) {
				int position = NextBlockBoard[i][j];
				if (position == 2) {
					g2.setColor(nextBlock.getColor());
				} else {
					g2.setColor(new Color(66, 66, 66, 100));
				}
				g2.fillRoundRect(60 + 10 * BLOCK_SIZE + j * BLOCK_SIZE, 70 + i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5,
						5);
				g2.setColor(new Color(66, 66, 66, 180));
				g2.drawRoundRect(60 + 10 * BLOCK_SIZE + j * BLOCK_SIZE, 70 + i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5,
						5);
			}
		}
	}

	/**
	 * GameBoard�� Score�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawScore2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Score", 60 + 10 * BLOCK_SIZE, 245);
		g2.setColor(new Color(66, 66, 66, 210));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 250, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(score + "", 60 + 10 * BLOCK_SIZE, 275);
	}

	/**
	 * GameBoard�� Level�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawLevel2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Level", 60 + 10 * BLOCK_SIZE, 340);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 345, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(level + "", 60 + 10 * BLOCK_SIZE, 370);
	}

	/**
	 * GameBoard�� PlayTime�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawPlayTime2(Graphics g) {
		endTime = System.nanoTime();
		playTime = (endTime - startTime - pauseTime) / 1000000000;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("PlayTime", 60 + 10 * BLOCK_SIZE, 430);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 436, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(Double.toString(playTime) + "��", 60 + 10 * BLOCK_SIZE, 462);

	}

	/** Start Time �� �����մϴ�. */
	public void setStartTime() {
		startTime = System.nanoTime();
		pauseTime = 0;
	}

	public void fixedAndSetNextBlock2P() {
		clear2();
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				tempBoard[i][j] = Board[i][j];
		setCurrentBlock();
		if (isGameOver2())
			ZPGameOver();

	}

	/** Game Over�� ȣ��˴ϴ�. */

	public void ZPGameOver() {
		update();
		start = false;
		controller.ZPGameOver();

	}

	/**
	 * Game Over ����� Ȯ���մϴ�.
	 * 
	 * @return Game Over �� ��ٸ� true�� , �ƴ϶�� false �� ��ȯ�մϴ�.
	 */

	public boolean isGameOver2() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board[i].length; j++)
				if (Board[i][j] != -1)
					return true;
		return false;
	}

	/**
	 * Board���� Block��ġ�� �ٲߴϴ�.
	 * 
	 * @param position
	 *            - Block�� ��ġ�Դϴ�.
	 * @param value
	 *            - Block�� ���� �Դϴ�.
	 */

	public void changePoint2P(Point position, int value) {
		Board[position.getX()][position.getY()] = value;
	}

	/**
	 * Block�� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param position
	 *            - Block �� ��ġ�Դϴ�.
	 * @return - �浹�Ѵٸ� true��, �浹�����ʴ´ٸ� false �� �����մϴ�.
	 */

	public boolean isCollision2P(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/**
	 * ȸ���� �� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param position
	 *            - Block �� ��ġ�Դϴ�.
	 * @return ȸ���� �� �浹�Ѵٸ� true, �浹���� �ʴ´ٸ� false �� �����մϴ�.
	 */

	public boolean isCollistionSpin2P(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getX() < 0)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/** tempBoard�� ����� ������ Board���� �ǵ����ϴ�. */
	public void revertMatrix() {
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				Board[i][j] = tempBoard[i][j];
	}

	/** ���������� �ϼ���Line�� �����ϰ�, ������ �Ʒ��� �����ϴ�. */
	public void clear2() {
		for (int i = 0; i < Board.length; i++) {
			if (isFullRow2(i)) {
				deleteLine2(i);
				score += 10;
			}
		}
		update();
	}

	/**
	 * Line�� �����մϴ�.
	 * 
	 * @param line
	 *            - ������ line�� ��ġ �Դϴ�.
	 */

	public void deleteLine2(int line) {
		int[][] temp2 = new int[line][COLS];
		for (int i = 0; i < line; i++)
			for (int j = 0; j < Board[i].length; j++)
				temp2[i][j] = Board[i][j];
		/////////////////////////////////////////////
		for (int i = 0; i < temp2.length; i++)
			for (int j = 0; j < temp2[i].length; j++)
				Board[i + 1][j] = temp2[i][j];
	}

	/**
	 * Line�� �ϼ��Ǿ����� Ȯ���մϴ�.
	 * 
	 * @param line
	 *            - �ϼ��Ǿ����� Ȯ���� line �Դϴ�.
	 * @return Line�� �ϼ��Ǿ��ٸ� true, �ƴ϶�� false�� �����մϴ�.
	 */

	public boolean isFullRow2(int line) {
		for (int i = 0; i < Board[line].length; i++)
			if (Board[line][i] == -1)
				return false;
		return true;
	}

}
