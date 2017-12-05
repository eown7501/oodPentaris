package AI;


/**
 * �� AIBehavior class �� AI�� �� �ൿ�޼ҵ带 �����մϴ�.
 * 
 * @author �Ž���
 */

public class AIBehavior {

	/** AIScore�� �̷�� �� ������ ����ġ�� �����ϴ� �迭�Դϴ�. */
	private static final double[] weight = { -3.8, 3.7, 2.5, -8.8, -0.59, 8.2 };
	/**	gameBoard �� COLS �Դϴ�. */
	public static final int COLS = 10;
	/** gameBoard �� ROWS �Դϴ�. */
	public static final int ROWS = 22;
	/** gameBoardAI ��ü�� ��Ÿ���� ���� �Դϴ�. */
	private GameBoardAI gameBoard;
	/** AI�� �̸� ���ֺ������� �׶��� gameBoard�� �� ���� ���̸� �����ϴ� �迭�Դϴ�. */
	private int[] nextHeight;
	/** AI �� ���ֺ������� gameBoard �� �� ���� ���� �Դϴ�. */
	private int[] beforeHeight;
	/** gameBoard���� ���� ���� ���� ���Դϴ�. */
	private int maxHeight;
	/** AI�� �̸� ���ֺ������� ���� ���е��� ���� ����ġ�� ���ؼ� ���� ���Դϴ�.  */
	private double AIScore;
	/** AI�� �̸� ���ֺ������� �׶��� gameBoard ������ �л��Դϴ�. */
	private double varHeight;
	/** AI�� �̸� ���ֺ������� �������� �����ִ� ���� ��� ���� �� �Դϴ�. */
	private int blockContactSurface;
	/** AI�� �̸� ���ֺ�������  ���� ��� ���� �� �Դϴ�. */
	private int wallContactSurface;
	/** AI�� �̸� ���ֺ������� ����� �� ������ �� �Դϴ�. */
	private int emptySpace;
	/** AI�� �̸� ���ֺ�������  �� �Ʒ��� �ִ� �� ������ �� �Դϴ�. */
	private int emptyBlock;
	/** AI�� �̸� ���ֺ�������  ����� Ŭ���� ������ �� �Դϴ�. */
	private int clearLineNum;
	/** currentBlock �� ��ġ�� �����ϴ� ��ǥ�迭�Դϴ�. */
	Point[] coord = new Point[4];
	
	/**
	 * AIBehavior �� �����մϴ�..
	 * 
	 * @param GameBoardAI
	 *            AI�� �̸� ���ֺ� gameBoard �Դϴ�.
	 */
	public AIBehavior(GameBoardAI soloGameBoard) {
		gameBoard = soloGameBoard;
		init();
	}
	
	/** AIBehaviot�� �ʱ�ȭ�մϴ�. */
	public void init() {
		nextHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		beforeHeight = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 4; i++)
			coord[i] = new Point(0, 0);
	}
	/** NextHeight�� �����մϴ�. */
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
	
	/** BeforeHeight �� �����մϴ�. */
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

	/** varHeight �� �����մϴ�. */
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

	/** clearLineNum �� �����մϴ�.	*/
	public void setClearLineNum() {
		clearLineNum = 0;
		for (int i = 0; i < ROWS; i++)
			if (isFullRow(i))
				clearLineNum++;
	}

	/**
	 * AI�� �̸����ֺ������� ROW�� FULL ���� Ȯ���մϴ�.
	 * @param line - FULL���� Ȯ���� ������ index �Դϴ�.
	 * @return	full �̶�� true��  �ƴ϶�� false�� ��ȯ�մϴ�.
	 */
	public boolean isFullRow(int line) {
		for (int i = 0; i < gameBoard.Board[line].length; i++)
			if (gameBoard.Board[line][i] == -1)
				return false;
		return true;
	}

	/** blockContactSurface �� wallContactSurface, emptySpace �� �����մϴ�. */
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
	 * emptySpace�� �󸶳� �ִ����� ���մϴ�. 
	 * @param x	- x��ǥ �Դϴ�.
	 * @param y - y��ǥ �Դϴ�.
	 * @param i	- block�� indexNum�Դϴ�.
	 */
	public void getEmpty(int x, int y, int i) {
		if (x + 1 < ROWS && gameBoard.Board[x + 1][y] == -1) {
			emptySpace++;
			getEmpty(x + 1, y, i);
		}
	}

	/**
	 * ��ǥ�� ���Ҷ� �� ��ǥ�� �ش��ϴ°��� �ڱ��ڽ��� �������� Ȯ���մϴ�.
	 * @param p - ���� ��ǥ �迭�Դϴ�.
	 * @param x	- x��ǥ �Դϴ�.
	 * @param y - y��ǥ �Դϴ�.
	 * @return �������̶�� true�� �ƴ϶�� false�� ��ȯ�մϴ�.
	 */
	public boolean isEqualBlock(Point[] p, int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (p[i].getX() == x && p[i].getY() == y)
				return true;
		}
		return false;
	}

	/**
	 * ��� ���� ���մϴ�.
	 * @param x	- x��ǥ �Դϴ�.
	 * @param y - y��ǥ �Դϴ�.
	 * @return ��¸��� ������ �����մϴ�.
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

	/** EmptyBlock �� �����մϴ�. */
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

	/** AIScore�� �����ϴ� �� �������� ����մϴ�. */
	public void circul() {
		setNextHeight();
		setBeforeHeight();
		setVarHeight();
		setClearLineNum();
		setBlockAndWallCS();
		setEmptyBlock();
	}

	/** AIScore�� �����մϴ�. */
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

	/** AI�� �̸� ���ֺ��� Best Point �� �����ϴ�. */
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
