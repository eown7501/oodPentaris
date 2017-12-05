package model;

import java.awt.Color;

/**
 * �� BlockZ Ŭ������ Block�� ����ϰ� ������, Z Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockLR extends Block {

	/**
	 * GameBoard ���� Z Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockLR(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockLR(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockLR(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(255, 110, 0);
		coord1P = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
		tempCoord1P = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(255, 110, 0);
		coord2P = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
		tempCoord2P = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(255, 110, 0);
		coordSolo = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
		tempCoordSolo = new Point[] { new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0) };
	}

	/** ������ ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 9);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 9);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 9);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 9);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 9);

	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 9);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 9);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 9);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 9);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 9);
	}

	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 9);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 9);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 9);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 9);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 9);
	}

}