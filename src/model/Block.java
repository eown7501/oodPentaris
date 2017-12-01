package model;

import java.awt.Color;

/**
 * �� Block Class�� ����� ��ġ, Color, ȸ��, �̵� �� ������ Class �Դϴ�.
 * 
 * @author ������
 */
public abstract class Block  {

	/** Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable;
	/** Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable2;
	/** Block�� �ö� GameBoardSolo Type �� �����Դϴ�. */
	protected GameBoard gameBoard;
	/** Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */

	protected Point topLeftPoint;
	/** topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point topLeftPoint2;
	/** topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPoint;
	/** Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point tempTopLeftPoint2;
	/** Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point[] coord;
	/** coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] coord2;
	/** coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] tempCoord;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Point[] tempCoord2;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Color color;


	/**
	 * Block �� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public Block(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	/** Block�� ����� �����մϴ�. */
	public abstract void initShape(); // ��ӹ޴� ������ ����
	public abstract void initShape2(); // ��ӹ޴� ������ ����
	/** ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord(); // ��ӹ޴� ������ ����
	/** ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord2(); // ��ӹ޴� ������ ����

	/**
	 * Block�� Color�� ��ȯ�մϴ�.
	 * 
	 * @return Block�� Color �Դϴ�.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Block�� Color�� �����մϴ�.
	 * 
	 * @param color
	 *            - Block�� Color�� ������ Color ��ü �Դϴ�.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Block �� TopLeftPoint�� ��ȯ�մϴ�.
	 * 
	 * @return TopLeftPoint�� ��ġ �Դϴ�.
	 */
	public Point getTopLeftPoint() {
		return topLeftPoint;
	}
	public Point getTopLeftPoint2() {
		return topLeftPoint2;
	}
	/**
	 * Block �� TopLeftPoint�� �����մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - �� ���� TopLeftPoint�� �����մϴ�.
	 */
	public void setTopLeftPoint(Point topLeftPoint) {
		this.topLeftPoint = topLeftPoint;
	}
	public void setTopLeftPoint2(Point topLeftPoint2) {
		this.topLeftPoint2 = topLeftPoint2;
	}
	/**
	 * Block �� ȸ���ൿ�ڸ� �����մϴ�.
	 * 
	 * @param spinnable
	 *            - �� ȸ���ൿ�ڸ� �����մϴ�.
	 */
	public void setSpinBehavior(Spinnable spinnable) {
		this.spinnable = spinnable;
	}
	public void setSpinBehavior2(Spinnable spinnable2) {
		this.spinnable2 = spinnable2;
	}

	/** Block GameBoard�� �����ϰ�, next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock() {
		gameBoard.fixedAndSetNextBlock();
	}
	/** Block GameBoard�� �����ϰ�, next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock2() {
		gameBoard.fixedAndSetNextBlock2();
	}
	/**
	 * ȸ���� �� ���̳� �ٸ� ������ �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return ȸ���� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionSpin(Point topLeftPoint) { // ȸ�����ɿ���
		spinnable.spin(tempCoord);
		for (int i = 0; i < tempCoord.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint(tempCoord[i]);
			if (gameBoard.isCollistionSpin(tempNextPoint))
				return true;
		}
		return false;
	}
	public boolean isCollisionSpin2(Point topLeftPoint2) { // ȸ�����ɿ���
		spinnable2.spin(tempCoord2);
		for (int i = 0; i < tempCoord2.length; i++) {
			Point tempNextPoint2 = topLeftPoint2.setCurrentPoint2(tempCoord2[i]);
			if (gameBoard.isCollistionSpin2(tempNextPoint2))
				return true;
		}
		return false;
	}

	/**
	 * �̵��� �� ���̳� �ٸ������� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return �̵��� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionMove(Point topLeftPoint) {
		for (int i = 0; i < coord.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint(coord[i]);
			if (gameBoard.isCollision(tempNextPoint))
				return true;
		}
		return false;
	}
	public boolean isCollisionMove2(Point topLeftPoint2) {
		for (int i = 0; i < coord2.length; i++) {
			Point tempNextPoint2 = topLeftPoint2.setCurrentPoint2(coord2[i]);
			if (gameBoard.isCollision2(tempNextPoint2))
				return true;
		}
		return false;
	}
	/** Block ȸ���� �����մϴ�. */
	public void performSpin() { // ��� �����ϱ�
		gameBoard.revertMatrix();
		if (!isCollisionSpin(topLeftPoint)) {
			spinnable.spin(coord);
			changeCoord();
		} else {
			changeCoord();
			for (int i = 0; i < coord.length; i++) {
				tempCoord[i].setX(coord[i].getX());
				tempCoord[i].setY(coord[i].getY());
			}
		}
	}
	public void performSpin2() { // ��� �����ϱ�
		gameBoard.revertMatrix2();
		if (!isCollisionSpin2(topLeftPoint2)) {
			spinnable2.spin(coord2);
			changeCoord2();
		} else {
			changeCoord2();
			for (int i = 0; i < coord2.length; i++) {
				tempCoord2[i].setX(coord2[i].getX());
				tempCoord2[i].setY(coord2[i].getY());
			}
		}
	}
	/** Block �� �������� �̵��մϴ�. */
	public void moveLeft() {
		tempTopLeftPoint.setY(topLeftPoint.getY() - 1);
		tempTopLeftPoint.setX(topLeftPoint.getX());
		gameBoard.revertMatrix();
		if (!isCollisionMove(tempTopLeftPoint)) {
			setTopLeftPoint(tempTopLeftPoint);
			changeCoord();
		} else {
			topLeftPoint.setY(tempTopLeftPoint.getY() + 1);
			changeCoord();
		}
	}
	public void moveLeft2() {
		tempTopLeftPoint2.setY(topLeftPoint2.getY() - 1);
		tempTopLeftPoint2.setX(topLeftPoint2.getX());
		gameBoard.revertMatrix2();
		if (!isCollisionMove2(tempTopLeftPoint2)) {
			setTopLeftPoint2(tempTopLeftPoint2);
			changeCoord2();
		} else {
			topLeftPoint2.setY(tempTopLeftPoint2.getY() + 1);
			changeCoord2();
		}
	}


	/** Block �� ���������� �̵��մϴ�. */
	public void moveRight() {
		tempTopLeftPoint.setY(topLeftPoint.getY() + 1);
		tempTopLeftPoint.setX(topLeftPoint.getX());
		gameBoard.revertMatrix();
		if (!isCollisionMove(tempTopLeftPoint)) {
			setTopLeftPoint(tempTopLeftPoint);
			changeCoord();
		} else {
			topLeftPoint.setY(tempTopLeftPoint.getY() - 1);
			changeCoord();
		}
	}

	public void moveRight2() {
		tempTopLeftPoint2.setY(topLeftPoint2.getY() + 1);
		tempTopLeftPoint2.setX(topLeftPoint2.getX());
		gameBoard.revertMatrix2();
		if (!isCollisionMove2(tempTopLeftPoint2)) {
			setTopLeftPoint2(tempTopLeftPoint2);
			changeCoord2();
		} else {
			topLeftPoint2.setY(tempTopLeftPoint2.getY() - 1);
			changeCoord2();
		}
	}
	/** Block �� �Ʒ��� �̵��մϴ�. */
	public void moveDown() {
		tempTopLeftPoint.setX(topLeftPoint.getX() + 1);
		gameBoard.revertMatrix();
		if (!isCollisionMove(tempTopLeftPoint)) {
			setTopLeftPoint(tempTopLeftPoint);
			changeCoord();
		} else {
			topLeftPoint.setX(tempTopLeftPoint.getX() - 1);
			changeCoord();
			fixedAndSetNextBlock();
		}
	}
	public void moveDown2() {
		tempTopLeftPoint2.setX(topLeftPoint2.getX() + 1);
		gameBoard.revertMatrix2();
		if (!isCollisionMove2(tempTopLeftPoint2)) {
			setTopLeftPoint2(tempTopLeftPoint2);
			changeCoord2();
		} else {
			topLeftPoint2.setX(tempTopLeftPoint2.getX() - 1);
			changeCoord2();
			fixedAndSetNextBlock2();
		}
	}

	/**
	 * Block �Ʒ��� ��ĭ ���� �� �ִ��� Ȯ���մϴ�.
	 * 
	 * @return �Ʒ��� ��ĭ �̵��� �� �ִٸ� true��, ���ٸ� false�� ��ȯ�մϴ�.
	 */
	public boolean isMoveDown() {
		Point x = new Point(topLeftPoint.getX() + 1, topLeftPoint.getY());
		gameBoard.revertMatrix();
		if (!isCollisionMove(x))
			return true;
		else
			return false;
	}
	public boolean isMoveDown2() {
		Point x = new Point(topLeftPoint2.getX() + 1, topLeftPoint2.getY());
		gameBoard.revertMatrix2();
		if (!isCollisionMove2(x))
			return true;
		else
			return false;
	}

	/** Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown() {
		while (isMoveDown())
			moveDown();
		changeCoord();
		fixedAndSetNextBlock();
	}

	/** Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown2() {
		while (isMoveDown2())
			moveDown2();
		changeCoord2();
		fixedAndSetNextBlock2();
	}

	/** Block �� ��ĭ ����Ʈ���ϴ�. */
	public void drop() {
		tempTopLeftPoint.setX(topLeftPoint.getX() + 1);
		gameBoard.revertMatrix();
		if (!isCollisionMove(tempTopLeftPoint)) {
			setTopLeftPoint(tempTopLeftPoint);
			changeCoord();
		} else {
			topLeftPoint.setX(tempTopLeftPoint.getX() - 1);
			changeCoord();
			fixedAndSetNextBlock();
		}
		gameBoard.update();

		
	}
	public void drop2() {
		tempTopLeftPoint2.setX(topLeftPoint2.getX()+1);
		gameBoard.revertMatrix2();
		if (!isCollisionMove2(tempTopLeftPoint2)) {
			setTopLeftPoint2(tempTopLeftPoint2);
			changeCoord2();
		} else {
			topLeftPoint2.setX(tempTopLeftPoint2.getX() -1);
			changeCoord2();
			fixedAndSetNextBlock2();
		}
		gameBoard.update();
	}
}
