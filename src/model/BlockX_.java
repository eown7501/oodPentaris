package model;

import java.awt.Color;

/**
 * �� BlockX_ Ŭ������ Block�� ����ϰ� ������, X_ Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockX_ extends Block {

	/**
	 * GameBoard ���� X_ Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockX_(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockX_(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockX_(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(24, 24, 226);
		coord1P = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
		tempCoord1P = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(24, 24, 226);
		coord2P = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
		tempCoord2P = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(24, 24, 226);
		coordSolo = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
		tempCoordSolo = new Point[] { new Point(1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1) };
	}

	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 14);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 14);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 14);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 14);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 14);
		
	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 14);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 14);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 14);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 14);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 14);
	}
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 14);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 14);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 14);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 14);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 14);
	}

}
