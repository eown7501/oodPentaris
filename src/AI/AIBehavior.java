package AI;


/**
 * 이 AIBehavior class 는 AI가 의 행동메소드를 제공합니다.
 * 
 * @author 신승현
 */

public class AIBehavior {

	/** AIScore를 이루는 각 성분의 가중치를 저장하는 배열입니다. */
	private static final double[] weight = { -3.8, 3.7, 2.5, -8.8, -0.59, 8.2 };
	/**	gameBoard 의 COLS 입니다. */
	public static final int COLS = 10;
	/** gameBoard 의 ROWS 입니다. */
	public static final int ROWS = 22;
	/** gameBoardAI 객체를 나타내는 변수 입니다. */
	private GameBoardAI gameBoard;
	/** AI가 미리 놔둬보았을때 그때의 gameBoard의 각 행의 높이를 저장하는 배열입니다. */
	private int[] nextHeight;
	/** AI 가 놔둬보기전에 gameBoard 의 각 행의 높이 입니다. */
	private int[] beforeHeight;
	/** gameBoard에서 가장 높은 행의 값입니다. */
	private int maxHeight;
	/** AI가 미리 놔둬보았을때 여러 성분들의 값에 가중치를 곱해서 더한 값입니다.  */
	private double AIScore;
	/** AI가 미리 놔둬보았을때 그때의 gameBoard 높이의 분산입니다. */
	private double varHeight;
	/** AI가 미리 놔둬보았을때 놓은블럭이 놓여있던 블럭에 닿는 면의 수 입니다. */
	private int blockContactSurface;
	/** AI가 미리 놔둬보았을때  벽에 닿는 면의 수 입니다. */
	private int wallContactSurface;
	/** AI가 미리 놔둬보았을때 생기는 빈 공간의 수 입니다. */
	private int emptySpace;
	/** AI가 미리 놔둬보았을때  그 아래에 있는 빈 공간의 수 입니다. */
	private int emptyBlock;
	/** AI가 미리 놔둬보았을때  생기는 클리어 라인의 수 입니다. */
	private int clearLineNum;
	/** currentBlock 의 위치를 저장하는 좌표배열입니다. */
	Point[] coord = new Point[4];
	
	/**
	 * AIBehavior 을 생성합니다..
	 * 
	 * @param GameBoardAI
	 *            AI가 미리 놔둬볼 gameBoard 입니다.
	 */
	public AIBehavior(GameBoardAI soloGameBoard) {
		gameBoard = soloGameBoard;
		init();
	}
	
	/** AIBehaviot을 초기화합니다. */
	public void init() {
		nextHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		beforeHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++)
			coord[i] = new Point(0, 0);
	}
	/** NextHeight을 설정합니다. */
	public void setNextHeight() {
		int blockHeight = 0;
		maxHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.Board[j][i] != -1)
					blockHeight = ROWS - j;
			nextHeight[i] = blockHeight;
			if(maxHeight<nextHeight[i])
				maxHeight = nextHeight[i];
			blockHeight = 0;
		}
	}
	
	/** BeforeHeight 를 설정합니다. */
	public void setBeforeHeight() {
		int blockHeight = 0;
		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 1; j >= 3; j--)
				if (gameBoard.tempBoard[j][i] != -1)
					blockHeight = ROWS - j;
			beforeHeight[i] = blockHeight;
			blockHeight = 0;
		}
	}

	/** varHeight 를 설정합니다. */
	public void setVarHeight() {
		double avrHeight;
		varHeight = 0;
		for (int i = 0; i < COLS; i++) {
			varHeight += nextHeight[i];
		}
		avrHeight = varHeight / 10;
		varHeight = 0;
		for (int i = 0; i < COLS; i++) {
			varHeight += (nextHeight[i] - avrHeight) * (nextHeight[i] - avrHeight);
		}
		varHeight /= 10;
	}

	/** clearLineNum 을 설정합니다.	*/
	public void setClearLineNum() {
		clearLineNum = 0;
		for (int i = 0; i < ROWS; i++)
			if (isFullRow(i))
				clearLineNum++;
	}

	/**
	 * AI가 미리놔둬보았을때 ROW가 FULL 인지 확인합니다.
	 * @param line - FULL인지 확인할 라인의 index 입니다.
	 * @return	full 이라면 true를  아니라면 false를 반환합니다.
	 */
	public boolean isFullRow(int line) {
		for (int i = 0; i < gameBoard.Board[line].length; i++)
			if (gameBoard.Board[line][i] == -1)
				return false;
		return true;
	}

	/** blockContactSurface 와 wallContactSurface, emptySpace 를 설정합니다. */
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

	}

	/**
	 * emptySpace가 얼마나 있는지를 구합니다. 
	 * @param x	- x좌표 입니다.
	 * @param y - y좌표 입니다.
	 * @param i	- block의 indexNum입니다.
	 */
	public void getEmpty(int x, int y, int i) {
		if (x + 1 < ROWS && gameBoard.Board[x + 1][y] == -1) {
			emptySpace++;
			getEmpty(x + 1, y, i);
		}
	}

	/**
	 * 좌표를 비교할때 그 좌표에 해당하는곳이 자기자신의 블럭인지를 확인합니다.
	 * @param p - 블럭의 좌표 배열입니다.
	 * @param x	- x좌표 입니다.
	 * @param y - y좌표 입니다.
	 * @return 같은블럭이라면 true를 아니라면 false를 반환합니다.
	 */
	public boolean isEqualBlock(Point[] p, int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (p[i].getX() == x && p[i].getY() == y)
				return true;
		}
		return false;
	}

	/**
	 * 닿는 면을 구합니다.
	 * @param x	- x좌표 입니다.
	 * @param y - y좌표 입니다.
	 * @return 닿는면의 개수를 리턴합니다.
	 */
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

	/** EmptyBlock 를 설정합니다. */
	public void setEmptyBlock() {
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

	}

	/** AIScore를 결정하는 각 변수들을 계산합니다. */
	public void circul() {
		setNextHeight();
		setBeforeHeight();
		setVarHeight();
		setClearLineNum();
		setBlockAndWallCS();
		setEmptyBlock();
	}

	/** AIScore를 설정합니다. */
	public double setAIScore() {
		AIScore = 0;
		setNextHeight();
		setBeforeHeight();
		setVarHeight();
		setClearLineNum();
		setBlockAndWallCS();
		setEmptyBlock();
		AIScore = weight[0] * varHeight + weight[1] * blockContactSurface + weight[2] * wallContactSurface
				+ weight[3] * emptySpace + weight[4] * emptyBlock + weight[5] * clearLineNum;
		return AIScore;
	}

	/** AI가 미리 놔둬보고 Best Point 에 놓습니다. */
	public void putBestPoint() {
		double maxAIScore = -999999999;
		int maxheight = 0;
		Block block = gameBoard.currentBlock;
		Point point = new Point(0, 0);
		Point bestPoint = new Point(0, 0);
		for (int i = 0; i < 4; i++) {
			block.moveDown();
			block.AIPerformSpin();

			for (int j = 0; j < 4; j++)
				block.AIMoveLeft();
			point.setX(block.topLeftPoint.getX());
			point.setY(block.topLeftPoint.getY());
			for (int j = 0; j < 10; j++) {
				block.AIFastDown();
				if (maxAIScore < setAIScore()) {
					maxAIScore = AIScore;
					bestPoint.setX(block.topLeftPoint.getX());
					bestPoint.setY(block.topLeftPoint.getY());
					maxheight = maxHeight;
					for (int k = 0; k < 4; k++) {
						coord[k].setX(block.coord[k].getX());
						coord[k].setY(block.coord[k].getY());
					}


				}
				block.setTopLeftPoint(point);
				block.AIMoveRight();
				point.setX(block.topLeftPoint.getX());
				point.setY(block.topLeftPoint.getY());

			}
			point.setX(1);
			point.setY(4);
			block.setTopLeftPoint(point);
		}

		for (int i = 0; i < 4; i++) {
			block.coord[i].setX(coord[i].getX());
			block.coord[i].setY(coord[i].getY());
		}

		block.setTopLeftPoint(bestPoint);
		block.topLeftPoint.setX(5);

		gameBoard.drop();
		try {
			Thread.sleep(1000-maxheight*40);
		} catch (InterruptedException e) {
		}

		block.fastDown();
	}
}
