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
	 * @param gameBoard1P
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockI(GameBoard1P gameBoard1P) {
		super(gameBoard1P);
		initShape1P();

	}

	public BlockI(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	public BlockI(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock4x4());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock4x4());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock4x4());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(244, 36, 51);
		coordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint1P(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 2);
		gameBoard1P.changePoint1P(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 2);
		gameBoard1P.changePoint1P(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 2);
		gameBoard1P.changePoint1P(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 2);
	}

	@Override
	public void changeCoord2P() {
		gameBoard2P.changePoint2P(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 2);
		gameBoard2P.changePoint2P(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 2);
		gameBoard2P.changePoint2P(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 2);
		gameBoard2P.changePoint2P(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 2);
	}

	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 2);
	}

}
