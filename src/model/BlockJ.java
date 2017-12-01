package model;

import java.awt.Color;

/**
 * �� BlockI Ŭ������ Block�� ����ϰ� ������, I Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 */
public class BlockJ extends Block {

	/**
	 * GameBoard ���� J Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockJ(GameBoard gameBoard) {
		super(gameBoard);
		initShape();
		initShape2();

	}

	public BlockJ(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock3x3());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
		tempCoord = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
	}

	public void initShape2() {
		setSpinBehavior2(new SpinBlock3x3());
		setTopLeftPoint2(new Point(2, 4));
		tempTopLeftPoint2 = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord2 = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
		tempCoord2 = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
	}
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(2, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(0, 92, 244);
		coordSolo = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
		tempCoordSolo = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
	}

	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 4);
	}

	public void changeCoord2() {
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[0]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[1]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[2]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[3]), 4);
	}
	@Override
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 4);
	}
}
