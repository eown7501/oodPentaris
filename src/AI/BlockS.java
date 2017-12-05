package AI;

import java.awt.Color;

/**
 * �� BlockS Ŭ������ Block�� ����ϰ� ������, S Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockS extends Block {

	/**
	 * GameBoard ���� S Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockS(GameBoardAI gameBoard) {
		super(gameBoard);
		initShape();
		blockIndex = 0;
	}

	/** S Block�� ����� �����մϴ�. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock3x3());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(224, 102, 245);
		coord = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
		tempCoord = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
	}

	/** S Block�� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 0);
	}

}
