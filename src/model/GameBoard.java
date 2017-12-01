package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * 이 Class는 Solo Game Board, 현재 Block, 다음 Block 등이 구현된 클래스입니다. Controller 에게 명령을
 * 받거나, 전달합니다.
 * 
 * @author 신승현
 *
 */
public class GameBoard implements Runnable {

	/** GameBoard의 Row 를 나타낼 변수입니다. */
	public static final int ROWS = 22;
	/** GameBoard의 Column 을 나타낼 변수입니다. */
	public static final int COLS = 10;
	/** 한 Block의 Size를 나타낼 변수입니다. */
	public static final int BLOCK_SIZE = 30;
	/** Block의 최대 개수를 나타낼 변수입니다. */
	public static final int BLOCK_MAX_NUM = 4;
	/** 명령을 받거나 전달할 Controller Type 변수입니다. */
	private Controller controller;
	/** 현재 Block을 저장할 변수입니다. */
	private Block currentBlock1;
	/** 다음 Block을 저장할 변수입니다. */
	private Block currentBlock2;
	/** 다음 Block을 저장할 변수입니다. */
	private Block nextBlock1;
	/** GameBoard를 저장할 2차원배열입니다. */
	private Block nextBlock2;
	/** GameBoard를 저장할 2차원배열입니다. */
	private int[][] Board1;
	/** Board의 값을 임시로 저장할 변수입니다. */
	private int[][] Board2;
	/** Board의 값을 임시로 저장할 변수입니다. */
	private int[][] tempBoard1;
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] tempBoard2;
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] NextBlockBoard1;
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] NextBlockBoard2;
	/** 점수를 저장할 변수입니다. */
	private int score1;
	/** 점수를 저장할 변수입니다. */
	private int score2;
	/** Level을 저장할 변수입니다. */
	private int level1;
	/** Level을 저장할 변수입니다. */
	private int level2;
	/** Start의 상태를 저장할 변수입니다. */
	private boolean start;
	/** Start Time을 저장할 변수입니다. */
	private long startTime;
	/** End Time 을 저장할 변수입니다. */
	private long endTime;
	/** Play Time 을 저장할 변수입니다. */
	private double playTime;
	/** Pause를 시작한 시간, 총 Pause된 시간을 저장할 변수입니다. */
	private long startPauseTime, pauseTime;

	/**
	 * GameBoardSolo 를 생성합니다.
	 * 
	 * @param controller
	 *            - 명령을 전달할 Controller 입니다.
	 */
	public GameBoard(Controller controller) {
		this.controller = controller;
		initGameBoard1();
		initGameBoard2();
	}

	/** GameBoard 를 초기화 합니다. */
	private void initGameBoard1() { // 게임보드 초기상태 설정
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

	/** GameBoard 를 초기화 합니다. */
	private void initGameBoard2() { // 게임보드 초기상태 설정
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

	/** Solo Game 을 시작합니다. */
	public void startGame() {
		Thread s = new Thread(this);
		s.start();
		setStartTime();

	}

	/**
	 * 인터페이스 Runnable를 구현하고있는 객체를 사용해 thread를 작성하면, thread를 기동하면 , 객체의 run 메소드가 그 개별
	 * 실행 thread로 불려갑니다.
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

	/** Block 이 한 칸 떨어트립니다. */
	public void drop() {
		currentBlock1.drop();
		currentBlock2.drop2();

	}

	/** Level 을 조정합니다. */
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

	/** Thread가 몇초 단위로 실행될지 설정합니다. */
	private void sleep() { // 난이도 speed 설정

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
	 * Block 을 랜덤으로 생성합니다.
	 * 
	 * @return 랜덤으로 생성된 Block 입니다.
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

	/** 다음 Block을 설정합니다. */
	public void setNextBlock() {
		nextBlock1 = createRandomBlock();
		NextBlockBoard1 = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock1.coord.length; i++)
			NextBlockBoard1[nextBlock1.coord[i].getX() + 2][nextBlock1.coord[i].getY() + 1] = 2;
	}

	/** 다음 Block을 설정합니다. */
	public void setNextBlock2() {
		nextBlock2 = createRandomBlock2();
		NextBlockBoard2 = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock2.coord.length; i++)
			NextBlockBoard2[nextBlock2.coord[i].getX() + 2][nextBlock2.coord[i].getY() + 1] = 2;
	}

	/** 현재 Block을 설정합니다. */
	public void setCurrentBlock() {
		if (nextBlock1 == null)
			setNextBlock();
		currentBlock1 = nextBlock1;
		setNextBlock();
	}

	/** 현재 Block을 설정합니다. */
	public void setCurrentBlock2() {
		if (nextBlock2 == null)
			setNextBlock2();
		currentBlock2 = nextBlock2;
		setNextBlock2();
	}

	/** Block에게 회전명령을 내립니다. */
	public void spin() {
		currentBlock1.performSpin();
	}

	/** Block에게 회전명령을 내립니다. */
	public void spin2() {
		currentBlock2.performSpin2();
	}

	/** Block에게 왼쪽 이동명령을 내립니다. */
	public void moveLeft() {
		currentBlock1.moveLeft();
	}

	/** Block에게 왼쪽 이동명령을 내립니다. */
	public void moveLeft2() {
		currentBlock2.moveLeft2();
	}

	/** Block 에게 오른쪽 이동명령을 내립니다. */
	public void moveRight() {
		currentBlock1.moveRight();
	}

	/** Block 에게 오른쪽 이동명령을 내립니다. */
	public void moveRight2() {
		currentBlock2.moveRight2();
	}

	/** Block에게 아래로 이동명령을 내립니다. */
	public void moveDown() {
		currentBlock1.moveDown();
	}

	/** Block에게 아래로 이동명령을 내립니다. */
	public void moveDown2() {
		currentBlock2.moveDown2();
	}

	/** Block에게 바로떨어트리는 명령을 내립니다. */
	public void fastDown() {
		currentBlock1.fastDown();
	}

	/** Block에게 바로떨어트리는 명령을 내립니다. */
	public void fastDown2() {
		currentBlock2.fastDown2();
	}

	/** Controller의 update 메소드를 실행합니다. */
	public void update() {
		controller.update();
	}

	/** Game 을 Pause 합니다. */
	public void pause() {
		start = false;
		startPauseTime = System.nanoTime();
	}

	/** Game을 재개합니다. */
	public void resume() {
		start = true;
		pauseTime = System.nanoTime() - startPauseTime;
	}

	/** Game을 재시작합니다. */
	public void restart() {
		initGameBoard1();
		initGameBoard2();
		setStartTime();
	}

	/**
	 * GameBoard 화면을 그립니다.
	 * 
	 * @param g
	 *            - Controller에게 전달받은 Graphcis g 입니다.
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
	 * GameBoard의 Board 부분을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 다음 Block을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 Score을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 Level을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 PlayTime을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
		g2.drawString(Double.toString(playTime) + "초", 60 + 10 * BLOCK_SIZE, 462);
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
		g2.drawString(Double.toString(playTime) + "초", 580 + 10 * BLOCK_SIZE, 462);

	}

	/** Start Time 을 설정합니다. */
	public void setStartTime() {
		startTime = System.nanoTime();
		pauseTime = 0;
	}

	/** GameBoard의 AI Ranking 을 그립니다. */
	public void drawAIRanking(Graphics g) {

	}

	/** Block을 Board에 고정시키고, 다음 Block을 설정합니다. */
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

	/** Game Over시 호출됩니다. */
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
	 * Game Over 됬는지 확인합니다.
	 * 
	 * @return Game Over 가 됬다면 true를 , 아니라면 false 를 반환합니다.
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
	 * Board위의 Block위치를 바꿉니다.
	 * 
	 * @param position
	 *            - Block의 위치입니다.
	 * @param value
	 *            - Block의 종류 입니다.
	 */
	public void changePoint(Point position, int value) {
		Board1[position.getX()][position.getY()] = value;
	}

	public void changePoint2(Point position, int value) {
		Board2[position.getX()][position.getY()] = value;
	}

	/**
	 * Block이 충돌하는지 확인합니다.
	 * 
	 * @param position
	 *            - Block 의 위치입니다.
	 * @return - 충돌한다면 true를, 충돌하지않는다면 false 를 리턴합니다.
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
	 * 회전할 때 충돌하는지 확인합니다.
	 * 
	 * @param position
	 *            - Block 의 위치입니다.
	 * @return 회전할 때 충돌한다면 true, 충돌하지 않는다면 false 를 리턴합니다.
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

	/** tempBoard에 저장된 원래의 Board값을 되돌립니다. */
	public void revertMatrix() {
		for (int i = 0; i < Board1.length; i++)
			for (int j = 0; j < Board1[i].length; j++)
				Board1[i][j] = tempBoard1[i][j];
	}

	/** tempBoard에 저장된 원래의 Board값을 되돌립니다. */
	public void revertMatrix2() {
		for (int i = 0; i < Board2.length; i++)
			for (int j = 0; j < Board2[i].length; j++)
				Board2[i][j] = tempBoard2[i][j];
	}

	/** 위에서부터 완성된Line을 삭제하고, 블럭들을 아래로 내립니다. */
	public void clear() {
		for (int i = 0; i < Board1.length; i++) {
			if (isFullRow(i)) {
				deleteLine(i);
				score1 += 10;
			}
		}
		update();
	}

	/** 위에서부터 완성된Line을 삭제하고, 블럭들을 아래로 내립니다. */
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
	 * Line을 삭제합니다.
	 * 
	 * @param line
	 *            - 삭제할 line의 위치 입니다.
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
	 * Line이 완성되었는지 확인합니다.
	 * 
	 * @param line
	 *            - 완성되었는지 확인할 line 입니다.
	 * @return Line이 완성되었다면 true, 아니라면 false를 리턴합니다.
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
