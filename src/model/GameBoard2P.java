package model;

import java.awt.*;
import java.util.*;
import controller.Controller;

/**
 * 이 Class는 Solo Game Board, 현재 Block, 다음 Block 등이 구현된 클래스입니다. Controller 에게 명령을
 * 받거나, 전달합니다.
 * 
 * @author 송민석
 *
 */
public class GameBoard2P implements Runnable {

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
	/** 다음 Block을 저장할 변수입니다. */
	private Block currentBlock;
	/** 다음 Block을 저장할 변수입니다. */
	/** GameBoard를 저장할 2차원배열입니다. */
	private Block nextBlock;
	/** GameBoard를 저장할 2차원배열입니다. */

	/** Board의 값을 임시로 저장할 변수입니다. */
	private int[][] Board;
	/** Board의 값을 임시로 저장할 변수입니다. */
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] tempBoard;
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	/** 다음 블럭을 화면에 표시해줄 영역 입니다. */
	private int[][] NextBlockBoard;
	/** 점수를 저장할 변수입니다. */
	/** 점수를 저장할 변수입니다. */
	private int score;
	/** Level을 저장할 변수입니다. */
	/** Level을 저장할 변수입니다. */
	private int level;
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
	public GameBoard2P(Controller controller) {
		this.controller = controller;
		initGameBoard();
	}

	/** GameBoard 를 초기화 합니다. */
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
		currentBlock.drop2P();
	}

	/** Level 을 조정합니다. */
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
	 * Block 을 랜덤으로 생성합니다.
	 * 
	 * @return 랜덤으로 생성된 Block 입니다.
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

	/** 다음 Block을 설정합니다. */
	public void setNextBlock2() {
		nextBlock = createRandomBlock2();
		NextBlockBoard = new int[BLOCK_MAX_NUM][BLOCK_MAX_NUM];
		for (int i = 0; i < nextBlock.coord2P.length; i++)
			NextBlockBoard[nextBlock.coord2P[i].getX() + 2][nextBlock.coord2P[i].getY() + 1] = 2;
	}

	/** 현재 Block을 설정합니다. */
	public void setCurrentBlock() {
		if (nextBlock == null)
			setNextBlock2();
		currentBlock = nextBlock;
		setNextBlock2();
	}

	/** Block에게 회전명령을 내립니다. */
	public void spin2() {
		currentBlock.performSpin2P();
	}

	/** Block에게 왼쪽 이동명령을 내립니다. */
	public void moveLeft2() {
		currentBlock.moveLeft2P();
	}

	/** Block 에게 오른쪽 이동명령을 내립니다. */
	public void moveRight2() {
		currentBlock.moveRight2P();
	}

	/** Block에게 아래로 이동명령을 내립니다. */
	public void moveDown2() {
		currentBlock.moveDown2P();
	}

	/** Block에게 바로떨어트리는 명령을 내립니다. */
	public void fastDown2() {
		currentBlock.fastDown2P();
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
		initGameBoard();
		setStartTime();
	}

	/**
	 * GameBoard 화면을 그립니다.
	 * 
	 * @param g
	 *            - Controller에게 전달받은 Graphcis g 입니다.
	 */
	public void draw(Graphics g) {

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
	 * GameBoard의 다음 Block을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 Score을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 Level을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
	 * GameBoard의 PlayTime을 그립니다.
	 * 
	 * @param g
	 *            - draw에게 전달받은 Graphics g 입니다.
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
		g2.drawString(Double.toString(playTime) + "초", 60 + 10 * BLOCK_SIZE, 462);

	}

	/** Start Time 을 설정합니다. */
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

	/** Game Over시 호출됩니다. */

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

	public boolean isGameOver2() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < Board[i].length; j++)
				if (Board[i][j] != -1)
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

	public void changePoint2P(Point position, int value) {
		Board[position.getX()][position.getY()] = value;
	}

	/**
	 * Block이 충돌하는지 확인합니다.
	 * 
	 * @param position
	 *            - Block 의 위치입니다.
	 * @return - 충돌한다면 true를, 충돌하지않는다면 false 를 리턴합니다.
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
	 * 회전할 때 충돌하는지 확인합니다.
	 * 
	 * @param position
	 *            - Block 의 위치입니다.
	 * @return 회전할 때 충돌한다면 true, 충돌하지 않는다면 false 를 리턴합니다.
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

	/** tempBoard에 저장된 원래의 Board값을 되돌립니다. */
	public void revertMatrix() {
		for (int i = 0; i < Board.length; i++)
			for (int j = 0; j < Board[i].length; j++)
				Board[i][j] = tempBoard[i][j];
	}

	/** 위에서부터 완성된Line을 삭제하고, 블럭들을 아래로 내립니다. */
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
	 * Line을 삭제합니다.
	 * 
	 * @param line
	 *            - 삭제할 line의 위치 입니다.
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
	 * Line이 완성되었는지 확인합니다.
	 * 
	 * @param line
	 *            - 완성되었는지 확인할 line 입니다.
	 * @return Line이 완성되었다면 true, 아니라면 false를 리턴합니다.
	 */

	public boolean isFullRow2(int line) {
		for (int i = 0; i < Board[line].length; i++)
			if (Board[line][i] == -1)
				return false;
		return true;
	}

}
