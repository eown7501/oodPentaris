package model;

import java.awt.Color;

/**
 * �� BlockP_ Ŭ������ Block�� ����ϰ� ������, P_ Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 *
 */
public class BlockPR extends Block {

	/**
	 * GameBoard ���� P_ Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public BlockPR(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockPR(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockPR(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(255, 91, 200);
		coord1P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
		tempCoord1P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(255, 91, 200);
		coord2P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
		tempCoord2P = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(255, 91, 200);
		coordSolo = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
		tempCoordSolo = new Point[] { new Point(0,-1),new Point(0,0),new Point(0,1),new Point(-1,0),new Point(-1,-1) };
	}


	/** ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 7);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 7);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 7);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 7);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 7);
		
	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 7);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 7);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 7);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 7);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 7);
	}
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 7);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 7);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 7);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 7);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 7);
	}

}
