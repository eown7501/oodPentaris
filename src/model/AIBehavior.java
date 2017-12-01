package model;

public class AIBehavior {

	private static final double[] weight = { -5, 10, 15, -10 };// { 1, 1, 1, 1, 1, 1 };
	public static final int COLS = 10;
	public static final int ROWS = 22;

	private GameBoardSolo gameBoard;
	private int[] nextHeight;
	private int[] beforeHeight;
	private int[] moved;

	private double AIScore;
	
	private double varHeight;
	private int blockContactSurface;
	private int wallContactSurface;
	private int emptySpace;
	
	private int clearLineNum;
	private int emptyBlock;

	private int moveCount;

	public AIBehavior(GameBoardSolo soloGameBoard) {
		gameBoard = soloGameBoard;
		init();
	}

	public void init() {
		nextHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		beforeHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		moved = new int[] { 0, 0, 0, 0 };

		moveCount = 0;
	}

	public void AIMove() {
		while (moved[0] > 0) {
			gameBoard.currentBlock.performSpin();
			moved[0]--;
		}
		while (moved[1] > 0) {
			gameBoard.currentBlock.moveLeft();
			moved[1]--;
		}
		while (moved[2] > 0) {
			gameBoard.currentBlock.moveRight();
			moved[2]--;
		}
		gameBoard.currentBlock.fastDown();
	}

	public void setNextHeight() {
		int blockHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.Board[j][i] != -1)
					blockHeight = ROWS - j;
			nextHeight[i] = blockHeight;
			// System.out.print(blockHeight + " ");
			blockHeight = 0;
		}
		// System.out.println();
	}

	public void setBeforeHeight() {
		int blockHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.tempBoard[j][i] != -1)
					blockHeight = ROWS - j;
			beforeHeight[i] = blockHeight;
			// System.out.print(blockHeight + " ");
			blockHeight = 0;
		}
		// System.out.println();
	}

	public void setVarHeight() {
		double avrHeight;
		varHeight = 0;
		for (int i = 0; i < COLS; i++) {
			varHeight += nextHeight[i];
		}
		avrHeight = varHeight / 10;
		varHeight = 0;
		for (int i = 0; i < COLS; i++) {
			varHeight = (nextHeight[i] - avrHeight) * (nextHeight[i] - avrHeight);
		}
		varHeight /= 10;
		// System.out.println("varHeight -> "+varHeight);
	}

	public void setClearLineNum() {
		clearLineNum = 0;
		for (int i = 0; i < ROWS; i++)
			if (isFullRow(i))
				clearLineNum++;
		// System.out.println("clearLine -> "+clearLineNum);
	}

	public boolean isFullRow(int line) {
		for (int i = 0; i < gameBoard.Board[line].length; i++)
			if (gameBoard.Board[line][i] == -1)
				return false;
		return true;
	}

	public void setBlockAndWallCS() {
		blockContactSurface = 0;
		wallContactSurface = 0;
		emptySpace = 0;
		Block block = gameBoard.currentBlock;
		Point[] point = new Point[4];
		for (int i = 0; i < 4; i++) {
			point[i] = block.topLeftPoint.setCurrentPoint(block.coord[i]);
		}
		for (int i = 0; i < 4; i++) {
			if (point[i].getY() == 0 || point[i].getY() == COLS - 1)
				wallContactSurface++;
			getEmpty(point[i].getX(), point[i].getY(), i);
			if (!isEqualBlock(point, point[i].getX(), point[i].getY() + 1))
				blockContactSurface += getSurfaceNum(point[i].getX(), point[i].getY() + 1);
			if (!isEqualBlock(point, point[i].getX(), point[i].getY() - 1))
				blockContactSurface += getSurfaceNum(point[i].getX(), point[i].getY() - 1);
			if (!isEqualBlock(point, point[i].getX() + 1, point[i].getY()))
				blockContactSurface += getSurfaceNum(point[i].getX() + 1, point[i].getY());
		}
		// System.out.println("empty contact wall -> " +
		// emptySpace+","+blockContactSurface+","+wallContactSurface);
	}

	public void getEmpty(int x, int y, int i) {
		if (x + 1 < ROWS && gameBoard.Board[x + 1][y] == -1) {
			emptySpace++;
			getEmpty(x + 1, y, i);
		}
	}

	public boolean isEqualBlock(Point[] p, int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (p[i].getX() == x && p[i].getY() == y)
				return true;
		}
		return false;
	}

	public int getSurfaceNum(int x, int y) {
		int index = 0;

		try {
			index = gameBoard.Board[x][y];
			if (index != -1)
				return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
		return 0;
	}

	public void setEmptyBlock() { // 옆면 말고 밑면만 계산
		emptyBlock = 0;
		int emptySpaceLine = 0;
		int floorBlock = 22;
		for (int i = 0; i < COLS; i++) {
			for (int j = (ROWS - nextHeight[i]); j < ROWS; j++) {
				if (gameBoard.Board[j][i] == -1) {
					floorBlock = j;
					emptySpaceLine++;
				}
			}
			if (floorBlock != 22)
				emptyBlock += nextHeight[i] - emptySpaceLine - (21 - floorBlock);
			emptySpaceLine = 0;
			floorBlock = 22;
		}

		// System.out.println("emptyblock -> " + emptySpaceAboveBlock);
	}

	public void circul() {
		setNextHeight();
		setBeforeHeight();
		setVarHeight();
		setClearLineNum();
		setBlockAndWallCS();
		setEmptyBlock();
	}

	public double setAIScore() {
		AIScore = 0;
		setNextHeight();
		setBeforeHeight();
		setVarHeight();
		setClearLineNum();
		setBlockAndWallCS();
		setEmptyBlock();
		AIScore = weight[0] * varHeight +  + weight[1] * blockContactSurface+ weight[2] * wallContactSurface + weight[3] * emptySpace;
							// + weight[5] * emptySpaceAboveBlock weight[1] * clearLineNum
		// System.out.print(AIScore);
		return AIScore;
	}

	public void setBestPoint() {
		double maxAIScore = -999999999;
		int left = 0;
		Block block = gameBoard.currentBlock;
		Point point = new Point(0, 0);
		for (int i = 0; i < 4; i++) { // 회전모양 4개
			block.AIPerformSpin();
			for (int j = 0; j < 4; j++)
				left += block.AIMoveLeft();
			// System.out.println("left ->"+left);
			point.setX(block.topLeftPoint.getX());
			point.setY(block.topLeftPoint.getY());
			for (int j = 0; j < 10; j++) { // colomn 10개
				block.AIFastDown();
				if (maxAIScore < setAIScore()) {
					maxAIScore = AIScore;
					// System.out.print(AIScore + ",");
					moved[0] = i + 1;
					if (left < j) {
						moved[1] = 0;
						moved[2] = j - left;
					} else {
						moved[1] = left - j;
						moved[2] = 0;
					}
				}
				point.setX(point.getX() + 1);
				block.setTopLeftPoint(point);
				block.AIMoveRight();
			}
			point.setX(1);
			point.setY(4);
			block.setTopLeftPoint(point);
			left = 0;
		}
		AIMove();
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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
