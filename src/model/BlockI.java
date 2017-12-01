package model;

import java.awt.Color;

/**
 * �� BlockI Ŭ������ Block�� ����ϰ� ������, I Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 */
public class BlockI extends Block {

	/**
	 * GameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockI(GameBoard gameBoard) {
		super(gameBoard);
		initShape();
		initShape2();

	}
	
	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock4x4());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}
	public void initShape2() {
		setSpinBehavior2(new SpinBlock4x4());
		setTopLeftPoint2(new Point(1, 4));
		tempTopLeftPoint2 = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord2 = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord2 = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 2);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 2);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 2);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 2);
	}
	@Override
	public void changeCoord2() {
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[0]), 2);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[1]), 2);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[2]), 2);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[3]), 2);
	}
}
