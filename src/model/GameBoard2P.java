package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * �� Class�� 2PGame ���� 2P Game Board, ���� Block, ���� Block ���� ������ Ŭ�����Դϴ�.
 * Controller ���� ����� �ްų�, �����մϴ�.
 * 
 * @author �۹μ�
 *
 */
public class GameBoard2P implements Runnable {

	/** 2P GameBoard�� Row �� ��Ÿ�� �����Դϴ�. */
	public static final int ROWS = 22;
	/** 2P GameBoard�� Column �� ��Ÿ�� �����Դϴ�. */
	public static final int COLS = 10;
	/** �� Block�� Size�� ��Ÿ�� �����Դϴ�. */
	public static final int BLOCK_SIZE = 30;
	/** Block�� �ִ� ������ ��Ÿ�� �����Դϴ�. */
	public static final int BLOCK_MAX_NUM = 5;
	/** ����� �ްų� ������ Controller Type �����Դϴ�. */
	private Controller controller;
	/** ���� 2P Block�� ������ �����Դϴ�. */
	private Block currentBlock;
	/** ���� 2P Block�� ������ �����Դϴ�. */
	private Block nextBlock;
	/** 2P GameBoard�� ������ 2�����迭�Դϴ�. */
	private int[][] Board;
	/** 2P Board�� ���� �ӽ÷� ������ �����Դϴ�. */
	private int[][] tempBoard;
	/** 2P Board���� ���� ���� ȭ�鿡 ǥ������ ���� �Դϴ�. */
	private int[][] NextBlockBoard;
	/** 2P�� ������ ������ �����Դϴ�. */
	private int score;
	/** 2P�� Level�� ������ �����Դϴ�. */
	private int level;
	/** Start�� ���¸� ������ �����Դϴ�. */
	public boolean start;
	/** Start Time�� ������ �����Դϴ�. */
	private long startTime;
	/** End Time �� ������ �����Դϴ�. */
	private long endTime;
	/** Play Time �� ������ �����Դϴ�. */
	private double playTime;
	/** Pause�� ������ �ð�, �� Pause�� �ð��� ������ �����Դϴ�. */
	private long startPauseTime, pauseTime;
	/** int type�� �����Դϴ�. */
	private int player;
	/** Thread�� ������ �����Դϴ�. */
	private Thread s;

	/**
	 * GameBoard2P �� �����մϴ�.
	 * 
	 * @param controller
	 *            - ����� ������ 2P�� Controller �Դϴ�.
	 */
	public GameBoard2P(Controller controller) {
		this.controller = controller;
		initGameBoard();
	}

	/** 2P GameBoard �� �ʱ�ȭ �մϴ�. */
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

	/** 2P Game �� �����մϴ�. */
	public void startGame() {
		player = 2;
		s = new Thread(this);
		s.start();
		setStartTime();

	}

	/**
	 * �������̽� Runnable�� �����ϰ��ִ� ��ü�� ����� thread�� �ۼ��ϸ�, thread�� �⵿�ϸ� , ��ü�� run �޼ҵ尡 �� ����
	 * ���� thread�� �ҷ����ϴ�.
	 */
	@Override
	public void run() {
		controller.update();
		while (true) {
			System.out.print("");
			if (start) {
				setLevel();
				drop();
				sleep();

			}
		}
	}

	/** 2P�� Block �� �� ĭ ����Ʈ���ϴ�. */
	public void drop() {
		currentBlock.drop2P();
	}

	/** 2P�� Level �� �����մϴ�. */
	public void setLevel() {
		if (level - 1 < score / 50) {
			if (level < 10)
				level++;
		}
	}

	/** Thread�� ���� ������ ������� �����մϴ�. */
	public void sleep() {// ���̵� speed ����
		int speed = 0;
		if (level == 1)
			speed = 900;
		if (level == 2)
			speed = 810;
		if (level == 3)
			speed = 720;
		if (level == 4)
			speed = 630;
		if (level == 5)
			speed = 540;
		if (level == 6)
			speed = 450;
		if (level == 7)
			speed = 360;
		if (level == 8)
			speed = 270;
		if (level == 9)
			speed = 180;
		if (level == 10)
			speed = 90;
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2P�� Block �� �������� �����մϴ�.
	 * 
	 * @return �������� ������ 2P Block �Դϴ�.
	 */

	public Block createRandomBlock() {
		Random r = new Random();
		Block block = null;
		int rNum = r.nextInt(13);
		switch (rNum) {
		case 0:
			block = new BlockC(this);
			break;
		case 1:
			block = new BlockHR(this);
			break;
		case 2:
			block = new BlockH(this);
			break;
		case 3:
			block = new BlockI(this);
			break;
		case 4:
			block = new BlockZ(this);
			break;
		case 5:
			block = new BlockZR(this);
			break;
		case 6:
			block = new BlockO(this);
			break;
		case 7:
			block = new BlockPR(this);
			break;
		case 8:
			block = new BlockP(this);
			break;
		case 9:
			block = new BlockLR(this);
			break;
		case 10:
			block = new BlockT(this);
			break;
		case 11:
			block = new BlockV(this);
			break;
		case 12:
			block = new BlockL(this);
			break;
		default:
			block = new BlockI(this);
			break;
		}
		return block;
	}

	/** 2P�� ���� Block�� �����մϴ�. */
	public void setNextBlock() {
		nextBlock = createRandomBlock();
		NextBlockBoard = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock.coord2P.length; i++)
			NextBlockBoard[nextBlock.coord2P[i].getX() + 2][nextBlock.coord2P[i].getY() + 2] = 2;
	}

	/** 2P�� ���� Block�� �����մϴ�. */
	public void setCurrentBlock() {
		if (nextBlock == null)
			setNextBlock();
		currentBlock = nextBlock;
		setNextBlock();
	}

	/** 2P�� Block���� ȸ������� �����ϴ�. */
	public void spin() {
		currentBlock.performSpin2P();
	}

	/** 2P�� Block���� ���� �̵������ �����ϴ�. */
	public void moveLeft() {
		currentBlock.moveLeft2P();
	}

	/** 2P�� Block ���� ������ �̵������ �����ϴ�. */
	public void moveRight() {
		currentBlock.moveRight2P();
	}

	/** 2P�� Block���� �Ʒ��� �̵������ �����ϴ�. */
	public void moveDown() {
		currentBlock.moveDown2P();
	}

	/** 2P�� Block���� �ٷζ���Ʈ���� ����� �����ϴ�. */
	public void fastDown() {
		currentBlock.fastDown2P();
	}

	/** Controller�� update �޼ҵ带 �����մϴ�. */
	public void update() {
		controller.update();
	}

	/** Game �� �Ͻ����� �մϴ�. */
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
	 * 2P GameBoard ȭ���� �׸��ϴ�.
	 * 
	 * @param g
	 *            - Controller���� ���޹��� Graphics g �Դϴ�.
	 */
	public void draw(Graphics g) {

		drawBoard(g);
		drawNextBlock(g);
		drawScore(g);
		drawLevel(g);
		drawPlayTime(g);
	}

	/**
	 * 2P GameBoard�� Board �κ��� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	public void drawBoard(Graphics g) {

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
				case 7:
					g.setColor(new Color(255, 91, 200));
					break;
				case 8:
					g.setColor(new Color(220, 0, 255));
					break;
				case 9:
					g.setColor(new Color(255, 110, 0));
					break;
				case 10:
					g.setColor(new Color(255, 248, 63));
					break;
				case 11:
					g.setColor(new Color(169, 232, 44));
					break;
				case 12:
					g.setColor(new Color(46, 232, 179));
					break;
				case 100:
					g.setColor(new Color(30, 26, 44));
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
	 * 2P GameBoard�� ���� Block�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawNextBlock(Graphics g) {
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
	 * 2P GameBoard�� Score�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawScore(Graphics g) {
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
	 * 2P GameBoard�� Level�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawLevel(Graphics g) {
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
	 * 2P GameBoard�� PlayTime�� �׸��ϴ�.
	 * 
	 * @param g
	 *            - draw���� ���޹��� Graphics g �Դϴ�.
	 */

	private void drawPlayTime(Graphics g) {
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

	/** 2P Block�� Board�� ������Ű��, ���� Block�� �����մϴ�. */
	public void fixedAndSetNextBlock() {
		clear();
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				tempBoard[i][j] = Board[i][j];
		setCurrentBlock();
		if (isGameOver())
			GameOver();

	}

	/** Game Over�� ȣ��˴ϴ�. */
	public void GameOver() {
		update();
		start = false;
		s.interrupt();
		controller.GameOver2P(player);

	}

	/**
	 * Game Over �� Ȯ���մϴ�.
	 * 
	 * @return Game Over��� true�� , �ƴ϶�� false �� ��ȯ�մϴ�.
	 */

	public boolean isGameOver() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board[i].length; j++)
				if (Board[i][j] != -1)
					return true;
		return false;
	}

	/**
	 * 2P Board���� Block��ġ�� �ٲߴϴ�.
	 * 
	 * @param position
	 *            - Block�� ��ġ�Դϴ�.
	 * @param value
	 *            - Block�� ���� �Դϴ�.
	 */

	public void changePoint(Point position, int value) {
		Board[position.getX()][position.getY()] = value;
	}

	/**
	 * 2P Block�� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param position
	 *            - Block �� ��ġ�Դϴ�.
	 * @return - �浹�Ѵٸ� true��, �浹�����ʴ´ٸ� false �� �����մϴ�.
	 */
	public boolean isCollision(Point position) {
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
	 * 2P Block�� ȸ���� �� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param position
	 *            - 2P Block �� ��ġ�Դϴ�.
	 * @return ȸ���� �� �浹�Ѵٸ� true, �浹���� �ʴ´ٸ� false �� �����մϴ�.
	 */

	public boolean isCollistionSpin(Point position) {
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

	/** 2P tempBoard�� ����� ������ Board���� �ǵ����ϴ�. */
	public void revertMatrix() {
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				Board[i][j] = tempBoard[i][j];
	}

	/** �ϼ��� Line�� �����ϰ�, ������ �Ʒ��� �����ϴ�. */
	public void clear() {
		for (int i = 0; i < Board.length; i++) {
			if (isFullRow(i)) {
				deleteLine(i);
				score += 10;
				controller.addLine2P(player);
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
			for (int j = 0; j < Board[i].length; j++)
				temp[i][j] = Board[i][j];
		/////////////////////////////////////////////
		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < temp[i].length; j++)
				Board[i + 1][j] = temp[i][j];
	}

	/** �� �޼ҵ�� ������ �߰��մϴ�. */
	public void addLine() {
		int[][] temp = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < tempBoard[i].length; j++)
				temp[i][j] = tempBoard[i][j];
		for (int i = 1; i < temp.length; i++)
			for (int j = 0; j < temp[i].length; j++)
				tempBoard[i - 1][j] = temp[i][j];
		for (int j = 0; j < COLS; j++)
			tempBoard[21][j] = 100;
	}

	/**
	 * Line�� �ϼ��Ǿ����� Ȯ���մϴ�.
	 * 
	 * @param line
	 *            - �ϼ��Ǿ����� Ȯ���� line �Դϴ�.
	 * @return Line�� �ϼ��Ǿ��ٸ� true, �ƴ϶�� false�� �����մϴ�.
	 */

	public boolean isFullRow(int line) {
		for (int i = 0; i < Board[line].length; i++)
			if (Board[line][i] == -1 || Board[line][i] == 100)
				return false;
		return true;
	}

}
