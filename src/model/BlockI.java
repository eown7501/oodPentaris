package model;

import java.awt.Color;

/**
 * 이 BlockI 클래스는 Block을 상속하고 있으며, I Block을 구현한 Class 입니다.
 * 
 * @author 곽소정
 *
 */
public class BlockI extends Block {

	/**
	 * GameBoard 위에 I Block을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
	 */
	public BlockI(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	public BlockI(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}

	public BlockI(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** Block 의 모양을 결정합니다. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock4x4());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(169, 232, 44);
		coord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
		tempCoord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
	}

	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock4x4());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(169, 232, 44);
		coord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
		tempCoord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
	}

	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock4x4());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(169, 232, 44);
		coordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
		tempCoordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0,3) };
	}
	/** 블럭의 위치를 바꿉니다. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 11);
		
	}

	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 11);
	}
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 11);
	}

}
