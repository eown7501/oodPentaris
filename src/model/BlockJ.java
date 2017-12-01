package model;

import java.awt.Color;

/**
 * 이 BlockI 클래스는 Block을 상속하고 있으며, I Block을 구현한 Class 입니다.
 * 
 * @author 곽소정
 */
public class BlockJ extends Block {

	/**
	 * GameBoard 위에 J Block을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
	 */
	public BlockJ(GameBoard gameBoard) {
		super(gameBoard);
		initShape();
		initShape2();

	}

	public BlockJ(GameBoardSolo gameBoardSolo) {
		super(gameBoardSolo);
		initShape();
	}

	/** Block 의 모양을 결정합니다. */
	@Override
	public void initShape() {
		setSpinBehavior(new SpinBlock3x3());
		setTopLeftPoint(new Point(1, 4));
		tempTopLeftPoint = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
		tempCoord = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
	}

	public void initShape2() {
		setSpinBehavior2(new SpinBlock3x3());
		setTopLeftPoint2(new Point(2, 4));
		tempTopLeftPoint2 = new Point(2, 4);
		color = new Color(0, 92, 244);
		coord2 = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
		tempCoord2 = new Point[] { new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1) };
	}

	/** 블럭의 위치를 바꿉니다. */
	@Override
	public void changeCoord() {
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[0]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[1]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[2]), 4);
		gameBoard.changePoint(topLeftPoint.setCurrentPoint(coord[3]), 4);
	}

	public void changeCoord2() {
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[0]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[1]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[2]), 4);
		gameBoard.changePoint2(topLeftPoint2.setCurrentPoint2(coord2[3]), 4);
	}

}
