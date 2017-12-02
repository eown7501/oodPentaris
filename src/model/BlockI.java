package model;

import java.awt.Color;

/**
 * �� BlockI Ŭ������ Block�� ����ϰ� ������, I Block�� ������ Class �Դϴ�.
 * 
 * @author ������
 */
public class BlockI extends Block {

	/**
	 * 1PGameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ 1P GameBoard �Դϴ�.
	 */
	public BlockI(GameBoard1P gameBoard) {
		super(gameBoard);
		initShape1P();

	}

	/**
	 * 2P GameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ 2P GameBoard �Դϴ�.
	 */
	public BlockI(GameBoard2P gameBoard) {
		super(gameBoard);
		initShape2P();
	}

	/**
	 * SoloPlay GameBoard ���� I Block�� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ SoloPlay GameBoard �Դϴ�.
	 */
	public BlockI(GameBoardSolo gameBoard) {
		super(gameBoard);
		initShapeSolo();
	}

	/** 1P Block �� ����� �����մϴ�. */
	@Override
	public void initShape1P() {
		setSpinBehavior1P(new SpinBlock4x4());
		setTopLeftPoint1P(new Point(1, 4));
		tempTopLeftPoint1P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord1P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** 2P Block �� ����� �����մϴ�. */
	@Override
	public void initShape2P() {
		setSpinBehavior2P(new SpinBlock4x4());
		setTopLeftPoint2P(new Point(1, 4));
		tempTopLeftPoint2P = new Point(2, 4);
		color = new Color(244, 36, 51);
		coord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoord2P = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** SoloPlay Block �� ����� �����մϴ�. */
	@Override
	public void initShapeSolo() {
		setSpinBehaviorSolo(new SpinBlock4x4());
		setTopLeftPointSolo(new Point(1, 4));
		tempTopLeftPointSolo = new Point(2, 4);
		color = new Color(244, 36, 51);
		coordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
		tempCoordSolo = new Point[] { new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2) };
	}

	/** 1P ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord1P() {
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[0]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[1]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[2]), 2);
		gameBoard1P.changePoint(topLeftPoint1P.setCurrentPoint1P(coord1P[3]), 2);
	}

	/** 2P ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoord2P() {
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[0]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[1]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[2]), 2);
		gameBoard2P.changePoint(topLeftPoint2P.setCurrentPoint2P(coord2P[3]), 2);
	}

	/** SoloPlay ���� ��ġ�� �ٲߴϴ�. */
	@Override
	public void changeCoordSolo() {
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[0]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[1]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[2]), 2);
		gameBoardSolo.changePointSolo(topLeftPointSolo.setCurrentPointSolo(coordSolo[3]), 2);
	}

}
