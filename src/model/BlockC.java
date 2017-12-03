package model;

import java.awt.Color;

/**
 * �� BlockC Ŭ������ Block�� ����ϰ� ������, C Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockC extends Block {

	/**
	 * GameBoard ���� C Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockC(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockC(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockC(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(224, 102, 245);
		coord1P = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
		tempCoord1P = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(224, 102, 245);
		coord2P = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
		tempCoord2P = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(224, 102, 245);
		coordSolo = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
		tempCoordSolo = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 1) };
	}


	/** ������ ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 0);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 0);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 0);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 0);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 0);
		
	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 0);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 0);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 0);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 0);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 0);
	}
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 0);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 0);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 0);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 0);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 0);
	}

}