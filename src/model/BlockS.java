package model;

import java.awt.Color;

/**
 * �� BlockI Ŭ������ Block�� ����ϰ� ������, I Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockS extends Block {

	/**
	 * GameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockS(GameBoard gameBoard) {
		super(gameBoard);
		initShape();
		initShape2();

	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock3x3());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(224, 102, 245);
		coord = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
		tempCoord = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
	}
	public void initShape2() {
		setSpinBehavior2(new SpinBlock3x3());
		setTopLeftPoint2(new Point(1, 4));
		tempTopLeftPoint2 = new Point(2, 4);
		color = new Color(224, 102, 245);
		coord2 = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
		tempCoord2 = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(0, -1) };
	}
	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 0);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 0);
	}
	public void changeCoord2() {
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[0]), 0);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[1]), 0);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[2]), 0);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[3]), 0);
	}

}
