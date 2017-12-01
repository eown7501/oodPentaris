package model;

import java.awt.Color;

/**
 * �� BlockI Ŭ������ Block�� ����ϰ� ������, I Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockO extends Block {

	/**
	 * GameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockO(GameBoard gameBoard) {
		super(gameBoard);
		initShape();
		initShape2();

	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock2x2());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(245, 180, 0);
		coord = new Point[] { new Point(-1, 0), new Point(-1, 1), new Point(0, 0), new Point(0, 1) };
		tempCoord = new Point[] { new Point(-1, 0), new Point(-1, 1), new Point(0, 0), new Point(0, 1) };
	}
	public void initShape2() {
		setSpinBehavior2(new SpinBlock2x2());
		setTopLeftPoint2(new Point(1, 4));
		tempTopLeftPoint2 = new Point(2, 4);
		color = new Color(245, 180, 0);
		coord2 = new Point[] { new Point(-1, 0), new Point(-1, 1), new Point(0, 0), new Point(0, 1) };
		tempCoord2 = new Point[] { new Point(-1, 0), new Point(-1, 1), new Point(0, 0), new Point(0, 1) };
	}

	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 6);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 6);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 6);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 6);
	}
	public void changeCoord2() {
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[0]), 6);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[1]), 6);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[2]), 6);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[3]), 6);
	}


}
