package model;

public class AIBehavior {

	private static final double[] weight = { 1, 1, 1, 1, 1, 1, 1 };// { -3.8, 8.2, 3.7, 2.5, 4.0, -8.8, -0.6 };
	public static final int COLS = 10;
	public static final int ROWS = 22;

	private GameBoardSolo gameBoard;
	private int[] nextHeight;
	private int[] beforeHeight;
	private int[] moved;
	private int[][] originalBoard;

	private double AIScore;
	private int sumHeight;
	private int clearLineNum;
	private int blockContactSurface;
	private int wallContactSurface;
	private int floorContactSurface;
	private int emptySpace;
	private int emptySpaceAboveBlock;

	private int moveCount;

	public AIBehavior(GameBoardSolo soloGameBoard) {
		gameBoard = soloGameBoard;
		init();
	}

	public void init() {
		nextHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		beforeHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		moved = new int[] { 0, 0, 0, 0 };
		originalBoard = new int[ROWS][COLS];

		moveCount = 0;
	}

	public void AIMove() {
		int[] D = new int[] { 1, 2, 3, 3, 4 };
		int order = moveCount;
		moveCount++;
		if (order > D.length)
			return;
		else if (D[order] == 1) {
			System.out.println(order);
			gameBoard.currentBlock.moveLeft();
		} else if (D[order] == 2) {
			System.out.println(order);
			gameBoard.currentBlock.moveDown();
		} else if (D[order] == 3) {
			System.out.println(order);
			gameBoard.currentBlock.moveRight();
		} else if (D[order] == 4) {
			System.out.println(order);
			gameBoard.currentBlock.fastDown();
		}
	}

	public void setNextHeight() {
		int blockHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.Board[j][i] != -1)
					blockHeight = ROWS - j;
			nextHeight[i] = blockHeight;
			 System.out.print(blockHeight+" ");
			blockHeight = 0;
		}
		 System.out.println();
	}

	public void setBeforeHeight() {
		int blockHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.tempBoard[j][i] != -1)
					blockHeight = ROWS - j;
			nextHeight[i] = blockHeight;
			System.out.print(blockHeight+" ");
			blockHeight = 0;
		}
		System.out.println();
	}

	public void setSumHeight() {
		sumHeight = 0;
		for (int i = 0; i < COLS; i++) {
			sumHeight += nextHeight[i];
		}

	}

	public void setClearLineNum() {
		clearLineNum = 0;
		for (int i = 0; i < ROWS; i++)
			if (isFullRow(i))
				clearLineNum++;
		System.out.println(clearLineNum);
	}

	public boolean isFullRow(int line) {
		for (int i = 0; i < gameBoard.Board[line].length; i++)
			if (gameBoard.Board[line][i] == -1)
				return false;
		return true;
	}

	public void setBlockContactSurface() {
		blockContactSurface = 0;
		for (int i = 0; i < COLS; i++) 
			if (nextHeight[i] != beforeHeight[i]) {
				for (int j = beforeHeight[i]; j <= nextHeight[i]; j++) {
					if (gameBoard.Board[j][i] == -1)
						break;
					if (j == nextHeight[i])
						blockContactSurface++;
				}
			}
		 System.out.println(blockContactSurface);
	}
	/*
	 * 
	 * 
	 * public void setWallContactSurface() { wallContactSurface = 0;
	 * wallContactSurface = (nextHeight[0] - Height[0]) + (nextHeight[9] -
	 * Height[9]); }
	 * 
	 * public void setFloorContactSurface() { floorContactSurface = 0; for (int i =
	 * 0; i < COLS; i++) { if (gameBoard.Board[0][i] != gameBoard.tempBoard[0][i])
	 * floorContactSurface++; } }
	 * 
	 * public void setEmptySpace() { emptySpace = 0; for (int i = 0; i < COLS; i++)
	 * for (int j = 0; j < nextHeight[i]; j++) { if (gameBoard.tempBoard[j][i] ==
	 * -1) emptySpace++; } }
	 * 
	 * public void setEmptySpaceAboveBlock() { emptySpaceAboveBlock = 0; int
	 * emptyBlock = 0; for (int i = 0; i < COLS; i++) { for (int j = nextHeight[i];
	 * j >= 0; j--) { if (gameBoard.tempBoard[j][i] == -1) break; emptyBlock++; } if
	 * (nextHeight[i] != emptyBlock) emptySpaceAboveBlock += emptyBlock; emptyBlock
	 * = 0; } }
	 * 
	 * public void setAIScore() { AIScore = 0; setCurrHeight(); setNextHeight();
	 * setSumHeight(); setClearLineNum(); setBlockContactSurface();
	 * setWallContactSurface(); setFloorContactSurface(); setEmptySpace();
	 * setEmptySpaceAboveBlock(); AIScore = weight[0] * sumHeight + weight[1] *
	 * clearLineNum + weight[2] * blockContactSurface + weight[3] *
	 * wallContactSurface + weight[4] * floorContactSurface + weight[5] * emptySpace
	 * + weight[6] * emptySpaceAboveBlock; }
	 * 
	 * public void setBestPoint() { Point poss = new Point(2, 4); Block block =
	 * gameBoard.currentBlock; double MaxAIScore = 0; int direction = 0;
	 * block.setTopLeftPoint(poss); block.changeCoord();
	 * 
	 * for (int i = 0; i < 4; i++) { for (int j = 0; j < 4; j++) {
	 * gameBoard.moveLeft(); moved[0] = block.getTopLeftPoint().getY()-poss.getY();
	 * System.out.println(block.getTopLeftPoint().getX()+"@"+block.getTopLeftPoint()
	 * .getY()); } //System.out.println(moved[0]+" "+moved[1]);
	 * poss.setX(block.getTopLeftPoint().getX());
	 * poss.setY(block.getTopLeftPoint().getY());
	 * System.out.println(poss.getX()+" "+poss.getY()); for (int k = 0; k < COLS;
	 * k++) { //System.out.println(moved[0]+" "+moved[1]); gameBoard.AIfastDown();
	 * System.out.println(block.getTopLeftPoint().getX()+"+"+block.getTopLeftPoint()
	 * .getY()); //setAIScore(); if (MaxAIScore <= AIScore) { MaxAIScore = AIScore;
	 * moved[2] = moved[0]; moved[3] = moved[1]; }
	 * 
	 * block.setTopLeftPoint(poss); gameBoard.moveRight();
	 * poss.setX(block.getTopLeftPoint().getX());
	 * poss.setY(block.getTopLeftPoint().getY()); moved[0]++; } poss.setX(1);
	 * poss.setY(4); block.setTopLeftPoint(poss); gameBoard.spin();
	 * poss.setX(block.getTopLeftPoint().getX());
	 * poss.setY(block.getTopLeftPoint().getY());
	 * System.out.println(poss.getX()+" "+poss.getY()); for (int q = 0; q <
	 * gameBoard.Board.length; q++) for (int j = 0; j < gameBoard.Board[i].length;
	 * j++) { gameBoard.Board[i][j] = originalBoard[i][j]; gameBoard.tempBoard[i][j]
	 * = originalBoard[i][j]; } moved[1]++; }
	 * 
	 * for(int i=0;i<4;i++) System.out.print(moved[i]+" "); System.out.println(); if
	 * (moved[2] < 0) direction = -moved[2]; for (int i = 0; i < direction; i++) {
	 * if (moved[2] < 0) gameBoard.moveLeft(); else gameBoard.moveRight(); } for
	 * (int i = 0; i < moved[3]; i++) gameBoard.spin(); gameBoard.fastDown();
	 * ////////////////////////////////// for (int i = 0; i < COLS; i++)
	 * System.out.print(Height[i] + ", "); System.out.println(); for (int i = 0; i <
	 * COLS; i++) System.out.print(nextHeight[i] + ", "); System.out.println();
	 * System.out.println("sumHeight = " + sumHeight);
	 * System.out.println("clearLineNum = " + clearLineNum);
	 * System.out.println("blockContactSurface = " + blockContactSurface);
	 * System.out.println("wallContactSurface = " + wallContactSurface);
	 * System.out.println("floorContactSurface = " + floorContactSurface);
	 * System.out.println("emptySpace = " + emptySpace);
	 * System.out.println("emptySpcaeAboveBlock = " + emptySpaceAboveBlock);
	 * System.out.println("AIScore = " + AIScore);
	 * System.out.println("----------------------------------------------"); }
	 * 
	 */
}
