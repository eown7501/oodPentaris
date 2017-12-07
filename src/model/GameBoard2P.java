package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * 이 Class는 2PGame 에서 2P Game Board, 현재 Block, 다음 Block 등이 구현된 클래스입니다.
 * Controller 에게 명령을 받거나, 전달합니다.
 * 
 * @author 송민석
 *
 */
public class GameBoard2P implements Runnable {

	/** 2P GameBoard의 Row 를 나타낼 변수입니다. */
	public static final int ROWS = 22;
	/** 2P GameBoard의 Column 을 나타낼 변수입니다. */
	public static final int COLS = 10;
	/** 한 Block의 Size를 나타낼 변수입니다. */
	public static final int BLOCK_SIZE = 30;
	/** Block의 최대 개수를 나타낼 변수입니다. */
	public static final int BLOCK_MAX_NUM = 5;
	/** 명령을 받거나 전달할 Controller Type 변수입니다. */
	private Controller controller;
	/** 현재 2P Block을 저장할 변수입니다. */
	private Block currentBlock;
	/** 다음 2P Block을 저장할 변수입니다. */
	private Block nextBlock;
	/** 2P GameBoard를 저장할 2차원배열입니다. */
	private int[][] Board;
	/** 2P Board의 값을 임시로 저장할 변수입니다. */
	private int[][] tempBoard;
	/** 2P Board에서 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] NextBlockBoard;
	/** 2P의 점수를 저장할 변수입니다. */
	private int score;
	/** 2P의 Level을 저장할 변수입니다. */
	private int level;
	/** Start의 상태를 저장할 변수입니다. */
	public boolean start;
	/** Start Time을 저장할 변수입니다. */
	private long startTime;
	/** End Time 을 저장할 변수입니다. */
	private long endTime;
	/** Play Time 을 저장할 변수입니다. */
	private double playTime;
	/** Pause를 시작한 시간, 총 Pause된 시간을 저장할 변수입니다. */
	private long startPauseTime, pauseTime;
	/** int type의 변수입니다. */
	private int player;
	/** Thread를 구현할 변수입니다. */
	private Thread s;

	/**
	 * GameBoard2P 를 생성합니다.
	 * 
	 * @param controller
	 *            - 명령을 전달할 2P의 Controller 입니다.
	 */
	public GameBoard2P(Controller controller) {
		this.controller = controller;
		initGameBoard();
	}

	/** 2P GameBoard 를 초기화 합니다. */
	private void initGameBoard() { // 게임보드 초기상태 설정
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

	/** 2P Game 을 시작합니다. */
	public void startGame() {
		player = 2;
		s = new Thread(this);
		s.start();
		setStartTime();

	}

	/**
	 * 인터페이스 Runnable를 구현하고있는 객체를 사용해 thread를 작성하면, thread를 기동하면 , 객체의 run 메소드가 그 개별
	 * 실행 thread로 불려갑니다.
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

	/** 2P의 Block 이 한 칸 떨어트립니다. */
	public void drop() {
		currentBlock.drop2P();
	}

	/** 2P의 Level 을 조정합니다. */
	public void setLevel() {
		if (level - 1 < score / 50) {
			if (level < 10)
				level++;
		}
	}

	/** Thread가 몇초 단위로 실행될지 설정합니다. */
	public void sleep() {// 난이도 speed 설정
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
	 * 2P의 Block 을 랜덤으로 생성합니다.
	 * 
	 * @return 랜덤으로 생성할 2P Block 입니다.
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

	/** 2P의 다음 Block을 설정합니다. */
	public void setNextBlock() {
		nextBlock = createRandomBlock();
		NextBlockBoard = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock.coord2P.length; i++)
			NextBlockBoard[nextBlock.coord2P[i].getX() + 2][nextBlock.coord2P[i].getY() + 2] = 2;
	}

	/** 2P의 현재 Block을 설정합니다. */
	public void setCurrentBlock() {
		if (nextBlock == null)
			setNextBlock();
		currentBlock = nextBlock;
		setNextBlock();
	}

	/** 2P의 Block에게 회전명령을 내립니다. */
	public void spin() {
		currentBlock.performSpin2P();
	}

	/** 2P의 Block에게 왼쪽 이동명령을 내립니다. */
	public void moveLeft() {
		currentBlock.moveLeft2P();
	}

	/** 2P의 Block 에게 오른쪽 이동명령을 내립니다. */
	public void moveRight() {
		currentBlock.moveRight2P();
	}

	/** 2P의 Block에게 아래로 이동명령을 내립니다. */
	public void moveDown() {
		currentBlock.moveDown2P();
	}

	/** 2P의 Block에게 바로떨어트리는 명령을 내립니다. */
	public void fastDown() {
		currentBlock.fastDown2P();
	}

	/** Controller의 update 메소드를 실행합니다. */
	public void update() {
		controller.update();
	}

	/** Game 을 일시정지 합니다. */
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
		initGameBoard();
		setStartTime();
	}

	/**
	 * 2P GameBoard 화면을 그립니다.
	 * 
	 * @param g
	 *            - Controller에게 전달받은 Graphics g 입니다.
	 */
	public void draw(Graphics g) {

		drawBoard(g);
		drawNextBlock(g);
		drawScore(g);
		drawLevel(g);
		drawPlayTime(g);
	}

	/**
	 * 2P GameBoard의 Board 부분을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * 2P GameBoard의 다음 Block을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * 2P GameBoard의 Score을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * 2P GameBoard의 Level을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * 2P GameBoard의 PlayTime을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
		g2.drawString(Double.toString(playTime) + "초", 60 + 10 * BLOCK_SIZE, 462);

	}

	/** Start Time 을 설정합니다. */
	public void setStartTime() {
		startTime = System.nanoTime();
		pauseTime = 0;
	}

	/** 2P Block을 Board에 고정시키고, 다음 Block을 설정합니다. */
	public void fixedAndSetNextBlock() {
		clear();
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				tempBoard[i][j] = Board[i][j];
		setCurrentBlock();
		if (isGameOver())
			GameOver();

	}

	/** Game Over시 호출됩니다. */
	public void GameOver() {
		update();
		start = false;
		s.interrupt();
		controller.GameOver2P(player);

	}

	/**
	 * Game Over 를 확인합니다.
	 * 
	 * @return Game Over라면 true를 , 아니라면 false 를 반환합니다.
	 */

	public boolean isGameOver() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board[i].length; j++)
				if (Board[i][j] != -1)
					return true;
		return false;
	}

	/**
	 * 2P Board위의 Block위치를 바꿉니다.
	 * 
	 * @param position
	 *            - Block의 위치입니다.
	 * @param value
	 *            - Block의 종류 입니다.
	 */

	public void changePoint(Point position, int value) {
		Board[position.getX()][position.getY()] = value;
	}

	/**
	 * 2P Block이 충돌하는지 확인합니다.
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
		if (Board[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/**
	 * 2P Block이 회전할 때 충돌하는지 확인합니다.
	 * 
	 * @param position
	 *            - 2P Block 의 위치입니다.
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
		if (Board[position.getX()][position.getY()] != -1)
			return true;
		return false;
	}

	/** 2P tempBoard에 저장된 원래의 Board값을 되돌립니다. */
	public void revertMatrix() {
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				Board[i][j] = tempBoard[i][j];
	}

	/** 완성된 Line을 삭제하고, 블럭들을 아래로 내립니다. */
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
	 * Line을 삭제합니다.
	 * 
	 * @param line
	 *            - 삭제할 line의 위치 입니다.
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

	/** 이 메소드는 라인을 추가합니다. */
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
	 * Line이 완성되었는지 확인합니다.
	 * 
	 * @param line
	 *            - 완성되었는지 확인할 line 입니다.
	 * @return Line이 완성되었다면 true, 아니라면 false를 리턴합니다.
	 */

	public boolean isFullRow(int line) {
		for (int i = 0; i < Board[line].length; i++)
			if (Board[line][i] == -1 || Board[line][i] == 100)
				return false;
		return true;
	}

}
