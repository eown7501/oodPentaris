package model;

import java.awt.Color;

/**
 * �� BlockL_ Ŭ������ Block�� ����ϰ� ������, L_ Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockL_ extends Block {

	/**
	 * GameBoard ���� L_ Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockL_(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockL_(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockL_(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(46, 228, 232);
		coord1P = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
		tempCoord1P = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(46, 228, 232);
		coord2P = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
		tempCoord2P = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(46, 228, 232);
		coordSolo = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
		tempCoordSolo = new Point[] { new Point(0, 1), new Point(0, 2),  new Point(0, 3),new Point(0, 0), new Point(1, 0) };
	}
	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 13);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 13);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 13);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 13);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 13);
		
	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 13);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 13);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 13);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 13);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 13);
	}
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 13);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 13);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 13);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 13);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 13);
	}

}
