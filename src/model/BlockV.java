package model;

import java.awt.Color;

/**
 * 이 BlockV 클래스는 Block을 상속하고 있으며, V Block을 구현한 Class 입니다.
 * 
 * @author 곽소정
 *
 */
public class BlockV extends Block {

	/**
	 * 1P GameBoard 위에 V Block을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
	 */
	public BlockV(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();
	}

	/**
	 * Solo GameBoard 위에 V Block을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
	 */
	public BlockV(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShapeSolo();
	}
	
	/**
	 * 2P GameBoard 위에 V Block을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
	 */
	public BlockV(GameBoard2P gameBoard2P) {
		super(gameBoard2P);
		initShape2P();
	}

	/** 1P에서 사용될 V Block의 모양을 결정합니다. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock3x3());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(169, 232, 44);
		coord1P = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
		tempCoord1P = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
	}

	/** 2P에서 사용될 V Block의 모양을 결정합니다. */
	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock3x3());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(169, 232, 44);
		coord2P = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
		tempCoord2P = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
	}
	
	/** Solo에서 사용될 V Block의 모양을 결정합니다. */
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock3x3());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(169, 232, 44);
		coordSolo = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
		tempCoordSolo = new Point[] { new Point(-1,-1),new Point(-1,0),new Point(-1,1),new Point(0,-1),new Point(1,-1) };
	}

	/** 1P에서  V Block의 위치를 바꿉니다. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 11);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[4]), 11);
	}
	
	/** 2P에서  V Block의 위치를 바꿉니다. */
	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 11);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[4]), 11);
	}
	
	/** Solo에서  V Block의 위치를 바꿉니다. */
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 11);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[4]), 11);
	}

}
