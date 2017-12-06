package model;

import java.awt.Color;

/**
 * �� BlockH Ŭ������ Block�� ����ϰ� ������, H Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockH extends Block {

	/**
	 * 1P GameBoard ���� H Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockH(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();
	}
	
	/**
	 * Solo GameBoard ���� H Block�� �����մϴ�.
	 * 
	 * @param gameBoardSolo
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockH(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	/**
	 * 2P GameBoard ���� H Block�� �����մϴ�.
	 * 
	 * @param gameBoard2P
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockH(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** 1P���� ���� H Block�� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord1P = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord1P = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** 2P���� ���� H Block�� ����� �����մϴ�. */
	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord2P = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord2P = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** Solo���� ���� H Block�� ����� �����մϴ�. */
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(244, 36, 51);
		coordSolo = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoordSolo = new Point[] { new Point(1, 0), new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** 1P����  H Block�� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 2);	
	}
	
	/** 2P����  H Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 2);
	}
	
	/** Solo����  H Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 2);
	}

}
