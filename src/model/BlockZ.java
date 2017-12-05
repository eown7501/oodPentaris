package model;

import java.awt.Color;

/**
 * �� BlockZ Ŭ������ Block�� ����ϰ� ������, Z Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockZ extends Block {
	
	/**
	 * 1P GameBoard ���� Z Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockZ(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();
	}

	/**
	 * Solo GameBoard ���� Z Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockZ(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}
	
	/**
	 * 2P GameBoard ���� Z Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockZ(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** 1P���� ���� Z Block�� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord1P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
		tempCoord1P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
	}
	
	/** 2P���� ���� Z Block�� ����� �����մϴ�. */
	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord2P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
		tempCoord2P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
	}
	
	/** Solo���� ���� Z Block�� ����� �����մϴ�. */
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(0, 92, 244);
		coordSolo = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
		tempCoordSolo = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(1,-1),new Point(-1,1) };
	}
	
	/** 1P����  Z Block�� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 4);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 4);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 4);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 4);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 4);
	}
	
	/** 2P����  Z Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 4);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 4);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 4);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 4);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 4);
	}
	
	/** Solo����  Z Block�� ��ġ�� �ٲߴϴ�. */
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 4);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 4);
	}

}
