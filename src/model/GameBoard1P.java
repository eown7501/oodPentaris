package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * �� Class�� Solo Game Board, ���� Block, ���� Block ���� ������ Ŭ�����Դϴ�. Controller ���� �����
 * �ްų�, �����մϴ�.
 * 
 * @author �Ž���
 *
 */
public class GameBoard1P implements Runnable {

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
	public Block currentBlock1;
	/** ���� Block�� ������ �����Դϴ�. */
	private Block currentBlock2;
	/** ���� Block�� ������ �����Դϴ�. */
	private Block nextBlock1;
	/** GameBoard�� ������ 2�����迭�Դϴ�. */
	private Block nextBlock2;
	/** GameBoard�� ������ 2�����迭�Դϴ�. */
	public int[][] Board1;
	/** Board�� ���� �ӽ÷� ������ �����Դϴ�. */
	private int[][] Board2;
	/** Board�� ���� �ӽ÷� ������ �����Դϴ�. */
	private int[][] tempBoard1;
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] tempBoard2;
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] NextBlockBoard1;
	/** ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] NextBlockBoard2;
	/** ������ ������ �����Դϴ�. */
	private int score1;
	/** ������ ������ �����Դϴ�. */
	private int score2;
	/** Level�� ������ �����Դϴ�. */
	private int level1;
	/** Level�� ������ �����Դϴ�. */
	private int level2;
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
	public GameBoard1P(Controller controller) {
		this.controller = controller;
		initGameBoard1();
	}

	/** GameBoard �� �ʱ�ȭ �մϴ�. */
	private void initGameBoard1() { // ���Ӻ��� �ʱ���� ����
		start = true;
		score1 = 0;
		level1 = 1;
		Board1 = new int[ROWS][COLS];
		tempBoard1 = new int[ROWS][COLS];
		for (int i = 0; i < Board1.length; i++) {
			for (int j = 0; j < Board1[i].length; j++) {
				Board1[i][j] = -1;
				tempBoard1[i][j] = -1;
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
		currentBlock1.drop1P();

	}

	/** Level �� �����մϴ�. */
	public void setLevel() {
		if (level1 - 1 < score1 / 50) {
			if (level1 < 10)
				level1++;
		}

	}

	/** Thread�� ���� ������ ������� �����մϴ�. */
	private void sleep() { // ���̵� speed ����

		int speed = 0;

		if (level1 == 1)
			speed = 900;
		if (level1 == 2)
			speed = 810;
		if (level1 == 3)
			speed = 720;
		if (level1 == 4)
			speed = 630;
		if (level1 == 5)
			speed = 540;
		if (level1 == 6)
			speed = 450;
		if (level1 == 7)
			speed = 360;
		if (level1 == 8)
			speed = 270;
		if (level1 == 9)
			speed = 180;
		if (level1 == 10)
			speed = 90;
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Block �� �������� �����մϴ�.
	 * 
	 * @return �������� ������ Block �Դϴ�.
	 */
	public Block createRandomBlock() {
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
	public void setNextBlock() {
		nextBlock1 = createRandomBlock();
		NextBlockBoard1 = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock1.coord1P.length; i++)
			NextBlockBoard1[nextBlock1.coord1P[i].getX() + 2][nextBlock1.coord1P[i].getY() + 1] = 2;
	}

	/** ���� Block�� �����մϴ�. */
	public void setCurrentBlock() {
		if (nextBlock1 == null)
			setNextBlock();
		currentBlock1 = nextBlock1;
		setNextBlock();
	}

	/** Block���� ȸ������� �����ϴ�. */
	public void spin() {
		currentBlock1.performSpin1P();
	}

	/** Block���� ���� �̵������ �����ϴ�. */
	public void moveLeft() {
		currentBlock1.moveLeft1P();
	}

	/** Block ���� ������ �̵������ �����ϴ�. */
	public void moveRight() {
		currentBlock1.moveRight1P();
	}

	/** Block���� �Ʒ��� �̵������ �����ϴ�. */
	public void moveDown() {
		currentBlock1.moveDown1P();
	}

	/** Block���� �ٷζ���Ʈ���� ����� �����ϴ�. */
	public void fastDown() {
		currentBlock1.fastDown1P();
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
		initGameBoard1();
		setStartTime();
	}

	/**
	 * GameBoard ȭ���� �׸��ϴ�.
	 * 
	 * @param g
	 *            - Controller���� ���޹��� Graphcis g �Դϴ�.
	 */
	public void draw(Graphics g) {
		drawBoard(g);
		drawNextBlock(g);
		drawScore(g);
		drawLevel(g);
		drawPlayTime(g);

	}

	/**
	 * GameBoard�� Board �κ��� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */
	public void drawBoard(Graphics g) {

		for (int i = 2; i < Board1.length; i++) {
			for (int j = 0; j < Board1[i].length; j++) {
				int color = Board1[i][j];
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

				g.fillRoundRect(550 + (j) * BLOCK_SIZE, 30 + (i - 2) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5, 5);
				g.setColor(new Color(66, 66, 66, 180));
				g.drawRoundRect(550 + (j) * BLOCK_SIZE, 30 + (i - 2) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5, 5);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(6));
				g2.drawRoundRect(550, 30, BLOCK_SIZE * 10, BLOCK_SIZE * 20, 5, 5);
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
	public void drawNextBlock(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Next", 580 + 10 * BLOCK_SIZE, 65);
		for (int i = 0; i < NextBlockBoard1.length; i++) {
			for (int j = 0; j < NextBlockBoard1[i].length; j++) {
				int position = NextBlockBoard1[i][j];
				if (position == 2) {
					g2.setColor(nextBlock1.getColor());
				} else {
					g2.setColor(new Color(66, 66, 66, 100));
				}
				g2.fillRoundRect(580 + 10 * BLOCK_SIZE + j * BLOCK_SIZE, 70 + i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5,
						5);
				g2.setColor(new Color(66, 66, 66, 180));
				g2.drawRoundRect(580 + 10 * BLOCK_SIZE + j * BLOCK_SIZE, 70 + i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5,
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
	public void drawScore(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Score", 580 + 10 * BLOCK_SIZE, 245);
		g2.setColor(new Color(66, 66, 66, 210));
		g2.drawRoundRect(580 + 10 * BLOCK_SIZE, 250, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(score1 + "", 580 + 10 * BLOCK_SIZE, 275);
	}

	/**
	 * GameBoard�� Level�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */
	public void drawLevel(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Level", 580 + 10 * BLOCK_SIZE, 340);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(580 + 10 * BLOCK_SIZE, 345, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(level1 + "", 580 + 10 * BLOCK_SIZE, 370);
	}

	/**
	 * GameBoard�� PlayTime�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */
	public void drawPlayTime(Graphics g) {
		endTime = System.nanoTime();
		playTime = (endTime - startTime - pauseTime) / 1000000000;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("PlayTime", 580 + 10 * BLOCK_SIZE, 430);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(580 + 10 * BLOCK_SIZE, 436, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(Double.toString(playTime) + "��", 580 + 10 * BLOCK_SIZE, 462);
	}

	/** Start Time �� �����մϴ�. */
	public void setStartTime() {
		startTime = System.nanoTime();
		pauseTime = 0;
	}

	/** Block�� Board�� ������Ű��, ���� Block�� �����մϴ�. */
	public void fixedAndSetNextBlock1P() {
		clear();
		for (int i = 0; i < Board1.length; i++)
			for (int j = 0; j < Board1[i].length; j++)
				tempBoard1[i][j] = Board1[i][j];
		setCurrentBlock();
		if (isGameOver1P())
			GameOver1P();

	}

	/** Game Over�� ȣ��˴ϴ�. */

	public void GameOver1P() {
		update();
		start = false;
		controller.ZPGameOver();

	}

	/**
	 * Game Over ����� Ȯ���մϴ�.
	 * 
	 * @return Game Over �� ��ٸ� true�� , �ƴ϶�� false �� ��ȯ�մϴ�.
	 */
	public boolean isGameOver1P() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board1[i].length; j++)
				if (Board1[i][j] != -1)
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
	public void changePoint1P(Point position, int value) {
		Board1[position.getX()][position.getY()] = value;
	}

	/**
	 * Block�� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param position
	 *            - Block �� ��ġ�Դϴ�.
	 * @return - �浹�Ѵٸ� true��, �浹�����ʴ´ٸ� false �� �����մϴ�.
	 */
	public boolean isCollision1P(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board1[position.getX()][position.getY()] != -1)
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
	public boolean isCollistionSpin1P(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getX() < 0)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board1[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/** tempBoard�� ����� ������ Board���� �ǵ����ϴ�. */
	public void revertMatrix() {
		for (int i = 0; i < Board1.length; i++)
			for (int j = 0; j < Board1[i].length; j++)
				Board1[i][j] = tempBoard1[i][j];
	}

	/** ���������� �ϼ���Line�� �����ϰ�, ������ �Ʒ��� �����ϴ�. */
	public void clear() {
		for (int i = 0; i < Board1.length; i++) {
			if (isFullRow(i)) {
				deleteLine(i);
				score1 += 10;
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
	public void deleteLine(int line) {
		int[][] temp = new int[line][COLS];
		for (int i = 0; i < line; i++)
			for (int j = 0; j < Board1[i].length; j++)
				temp[i][j] = Board1[i][j];
		/////////////////////////////////////////////
		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < temp[i].length; j++)
				Board1[i + 1][j] = temp[i][j];
	}

	/**
	 * Line�� �ϼ��Ǿ����� Ȯ���մϴ�.
	 * 
	 * @param line
	 *            - �ϼ��Ǿ����� Ȯ���� line �Դϴ�.
	 * @return Line�� �ϼ��Ǿ��ٸ� true, �ƴ϶�� false�� �����մϴ�.
	 */
	public boolean isFullRow(int line) {
		for (int i = 0; i < Board1[line].length; i++)
			if (Board1[line][i] == -1)
				return false;
		return true;
	}

}
