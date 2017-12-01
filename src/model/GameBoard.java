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
public class GameBoard implements Runnable {

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
	private Block currentBlock1;
	/** ���� Block�� ������ �����Դϴ�. */
	private Block currentBlock2;
	/** ���� Block�� ������ �����Դϴ�. */
	private Block nextBlock1;
	/** GameBoard�� ������ 2�����迭�Դϴ�. */
	private Block nextBlock2;
	/** GameBoard�� ������ 2�����迭�Դϴ�. */
	private int[][] Board1;
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
	public GameBoard(Controller controller) {
		this.controller = controller;
		initGameBoard1();
		initGameBoard2();
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

	/** GameBoard �� �ʱ�ȭ �մϴ�. */
	private void initGameBoard2() { // ���Ӻ��� �ʱ���� ����
		start = true;
		score2 = 0;
		level2 = 1;
		Board2 = new int[ROWS][COLS];
		tempBoard2 = new int[ROWS][COLS];
		for (int i = 0; i < Board2.length; i++) {
			for (int j = 0; j < Board2[i].length; j++) {
				Board2[i][j] = -1;
				tempBoard2[i][j] = -1;
			}
		}
		setCurrentBlock2();
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
		currentBlock1.drop();
		currentBlock2.drop2();

	}

	/** Level �� �����մϴ�. */
	public void setLevel() {
		if (level1 - 1 < score1 / 10) {
			if (level1 < 10)
				level1++;
		}
		if (level2 - 1 < score2 / 50) {
			if (level2 < 10)
				level2++;
		}
	}

	/** Thread�� ���� ������ ������� �����մϴ�. */
	private void sleep() { // ���̵� speed ����

		int speed = 0;

		if (level1 == 1)
			speed = 1000;
		if (level1 == 2)
			speed = 200;
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

	public void sleep2() {
		int speed2 = 0;

		if (level2 == 1)
			speed2 = 200;
		if (level2 == 2)
			speed2 = 200;
		if (level2 == 3)
			speed2 = 720;
		if (level2 == 4)
			speed2 = 630;
		if (level2 == 5)
			speed2 = 540;
		if (level2 == 6)
			speed2 = 450;
		if (level2 == 7)
			speed2 = 360;
		if (level2 == 8)
			speed2 = 270;
		if (level2 == 9)
			speed2 = 180;
		if (level2 == 10)
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
	public void setNextBlock() {
		nextBlock1 = createRandomBlock();
		NextBlockBoard1 = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock1.coord.length; i++)
			NextBlockBoard1[nextBlock1.coord[i].getX() + 2][nextBlock1.coord[i].getY() + 1] = 2;
	}

	/** ���� Block�� �����մϴ�. */
	public void setNextBlock2() {
		nextBlock2 = createRandomBlock2();
		NextBlockBoard2 = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock2.coord.length; i++)
			NextBlockBoard2[nextBlock2.coord[i].getX() + 2][nextBlock2.coord[i].getY() + 1] = 2;
	}

	/** ���� Block�� �����մϴ�. */
	public void setCurrentBlock() {
		if (nextBlock1 == null)
			setNextBlock();
		currentBlock1 = nextBlock1;
		setNextBlock();
	}

	/** ���� Block�� �����մϴ�. */
	public void setCurrentBlock2() {
		if (nextBlock2 == null)
			setNextBlock2();
		currentBlock2 = nextBlock2;
		setNextBlock2();
	}

	/** Block���� ȸ������� �����ϴ�. */
	public void spin() {
		currentBlock1.performSpin();
	}

	/** Block���� ȸ������� �����ϴ�. */
	public void spin2() {
		currentBlock2.performSpin2();
	}

	/** Block���� ���� �̵������ �����ϴ�. */
	public void moveLeft() {
		currentBlock1.moveLeft();
	}

	/** Block���� ���� �̵������ �����ϴ�. */
	public void moveLeft2() {
		currentBlock2.moveLeft2();
	}

	/** Block ���� ������ �̵������ �����ϴ�. */
	public void moveRight() {
		currentBlock1.moveRight();
	}

	/** Block ���� ������ �̵������ �����ϴ�. */
	public void moveRight2() {
		currentBlock2.moveRight2();
	}

	/** Block���� �Ʒ��� �̵������ �����ϴ�. */
	public void moveDown() {
		currentBlock1.moveDown();
	}

	/** Block���� �Ʒ��� �̵������ �����ϴ�. */
	public void moveDown2() {
		currentBlock2.moveDown2();
	}

	/** Block���� �ٷζ���Ʈ���� ����� �����ϴ�. */
	public void fastDown() {
		currentBlock1.fastDown();
	}

	/** Block���� �ٷζ���Ʈ���� ����� �����ϴ�. */
	public void fastDown2() {
		currentBlock2.fastDown2();
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
		initGameBoard2();
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

	public void drawBoard2(Graphics g) {
		for (int i = 2; i < Board2.length; i++) {
			for (int j = 0; j < Board2[i].length; j++) {
				int color = Board2[i][j];
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
		g2.drawString("Next", 60 + 10 * BLOCK_SIZE, 65);
		for (int i = 0; i < NextBlockBoard1.length; i++) {
			for (int j = 0; j < NextBlockBoard1[i].length; j++) {
				int position = NextBlockBoard1[i][j];
				if (position == 2) {
					g2.setColor(nextBlock1.getColor());
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

	private void drawNextBlock2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Next", 580 + 10 * BLOCK_SIZE, 65);
		for (int i = 0; i < NextBlockBoard2.length; i++) {
			for (int j = 0; j < NextBlockBoard2[i].length; j++) {
				int position = NextBlockBoard2[i][j];
				if (position == 2) {
					g2.setColor(nextBlock2.getColor());
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
		g2.drawString("Score", 60 + 10 * BLOCK_SIZE, 245);
		g2.setColor(new Color(66, 66, 66, 210));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 250, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(score1 + "", 60 + 10 * BLOCK_SIZE, 275);
	}

	private void drawScore2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Score", 580 + 10 * BLOCK_SIZE, 245);
		g2.setColor(new Color(66, 66, 66, 210));
		g2.drawRoundRect(580 + 10 * BLOCK_SIZE, 250, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(score2 + "", 580 + 10 * BLOCK_SIZE, 275);
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
		g2.drawString("Level", 60 + 10 * BLOCK_SIZE, 340);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 345, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(level1 + "", 60 + 10 * BLOCK_SIZE, 370);
	}

	private void drawLevel2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SVN-Block", Font.BOLD, 30));
		g2.drawString("Level", 580 + 10 * BLOCK_SIZE, 340);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(580 + 10 * BLOCK_SIZE, 345, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(level2 + "", 580 + 10 * BLOCK_SIZE, 370);
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
		g2.drawString("PlayTime", 60 + 10 * BLOCK_SIZE, 430);
		g2.setColor(new Color(66, 66, 66, 180));
		g2.drawRoundRect(60 + 10 * BLOCK_SIZE, 436, BLOCK_SIZE * 4, BLOCK_SIZE * 1, 5, 5);
		g2.setFont(new Font("Digital-7", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		g2.setColor(Color.GREEN);
		g2.drawString(Double.toString(playTime) + "��", 60 + 10 * BLOCK_SIZE, 462);
	}

	private void drawPlayTime2(Graphics g) {
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

	/** GameBoard�� AI Ranking �� �׸��ϴ�. */
	public void drawAIRanking(Graphics g) {

	}

	/** Block�� Board�� ������Ű��, ���� Block�� �����մϴ�. */
	public void fixedAndSetNextBlock() {
		clear();
		for (int i = 0; i < Board1.length; i++)
			for (int j = 0; j < Board1[i].length; j++)
				tempBoard1[i][j] = Board1[i][j];
		if (isGameOver1()) {
			ZPGameOver();
		start=false;
		}
		setCurrentBlock();
	}

	public void fixedAndSetNextBlock2() {
		clear2();
		for (int i = 0; i < Board2.length; i++)
			for (int j = 0; j < Board2[i].length; j++)
				tempBoard2[i][j] = Board2[i][j];

		setCurrentBlock2();
		if (isGameOver2()) {
			ZPGameOver();
	
	}
	}

	/** Game Over�� ȣ��˴ϴ�. */
	public void GameOver() {
		update();
	
		controller.soloGameOver();

	}

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
	public boolean isGameOver1() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board1[i].length; j++)
				if (Board1[i][j] != -1)
					return true;
		return false;
	}

	public boolean isGameOver2() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board2[i].length; j++)
				if (Board2[i][j] != -1)
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
	public void changePoint(Point position, int value) {
		Board1[position.getX()][position.getY()] = value;
	}

	public void changePoint2(Point position, int value) {
		Board2[position.getX()][position.getY()] = value;
	}

	/**
	 * Block�� �浹�ϴ��� Ȯ���մϴ�.
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
		if (Board1[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	public boolean isCollision2(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board2[position.getX()][position.getY()] != -1)
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
	public boolean isCollistionSpin(Point position) {
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

	public boolean isCollistionSpin2(Point position) {
		if (position.getX() > ROWS - 1)
			return true;
		if (position.getX() < 0)
			return true;
		if (position.getY() < 0)
			return true;
		if (position.getY() > COLS - 1)
			return true;
		if (Board2[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/** tempBoard�� ����� ������ Board���� �ǵ����ϴ�. */
	public void revertMatrix() {
		for (int i = 0; i < Board1.length; i++)
			for (int j = 0; j < Board1[i].length; j++)
				Board1[i][j] = tempBoard1[i][j];
	}

	/** tempBoard�� ����� ������ Board���� �ǵ����ϴ�. */
	public void revertMatrix2() {
		for (int i = 0; i < Board2.length; i++)
			for (int j = 0; j < Board2[i].length; j++)
				Board2[i][j] = tempBoard2[i][j];
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

	/** ���������� �ϼ���Line�� �����ϰ�, ������ �Ʒ��� �����ϴ�. */
	public void clear2() {
		for (int i = 0; i < Board2.length; i++) {
			if (isFullRow2(i)) {
				deleteLine2(i);
				score2 += 10;
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

	public void deleteLine2(int line) {
		int[][] temp2 = new int[line][COLS];
		for (int i = 0; i < line; i++)
			for (int j = 0; j < Board2[i].length; j++)
				temp2[i][j] = Board2[i][j];
		/////////////////////////////////////////////
		for (int i = 0; i < temp2.length; i++)
			for (int j = 0; j < temp2[i].length; j++)
				Board2[i + 1][j] = temp2[i][j];
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

	public boolean isFullRow2(int line) {
		for (int i = 0; i < Board2[line].length; i++)
			if (Board2[line][i] == -1)
				return false;
		return true;
	}

}
