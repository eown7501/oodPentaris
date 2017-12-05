package model;

import java.awt.Color;

/**
 * �� BlockO Ŭ������ Block�� ����ϰ� ������, O Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockO extends Block {

	/**
	 * 1P GameBoard ���� O Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockO(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();
	}
	
	/**
	 * Solo GameBoard ���� O Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockO(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}
	
	/**
	 * 2P GameBoard ���� O Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockO(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** 1P���� ���� O Block�� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock2x2());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(245, 180, 0);
		coord1P = new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
		tempCoord1P =  new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
	}
	
	/** 2P���� ���� O Block�� ����� �����մϴ�. */
	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock2x2());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(245, 180, 0);
		coord2P = new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
		tempCoord2P =  new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
	}
	
	/** Solo���� ���� O Block�� ����� �����մϴ�. */
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock2x2());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(245, 180, 0);
		coordSolo = new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
		tempCoordSolo =  new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, 0), new Point(0, 1), new Point(0, -1) };
	}

	/** 1P����  O Block�� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 6);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 6);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 6);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 6);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 6);
	}
	
	/** 2P����  O Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 6);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 6);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 6);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 6);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 6);
	}
	
	/** Solo����  O Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 6);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 6);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 6);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 6);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 6);
	}

}
