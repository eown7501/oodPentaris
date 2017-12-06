package model;

import java.awt.Color;

/**
 * �� Block Class�� ����� ��ġ, Color, ȸ��, �̵� �� ������ Class �Դϴ�.
 * 
 * @author �۹μ�, ������
 */
public abstract class Block {

	/** 1PGame�� Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable1P;
	/** 2PGame�� Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable2P;
	/** SoloPlay�� Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnableSolo;
	/** 1P�� GameBoard�� ȣ���մϴ�. */
	protected GameBoard1P gameBoard1P;
	/** 2P�� GameBoard�� ȣ���մϴ�. */
	protected GameBoard2P gameBoard2P;
	/** SoloPlay�� GameBoard�� ȣ���մϴ�. */
	protected GameBoardSolo gameBoardSolo;
	/** 1P�� Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPoint1P;
	/** 2P�� Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPoint2P;
	/** SoloPlay�� Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPointSolo;
	/** 1P�� topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPoint1P;
	/** 2P�� topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPoint2P;
	/** SoloPlay�� topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPointSolo;
	/** 1P�� Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point[] coord1P;
	/** 2P�� Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point[] coord2P;
	/** SoloPlay�� Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point[] coordSolo;
	/** 1P�� coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] tempCoord1P;
	/** 2P�� coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] tempCoord2P;
	/** SoloPlay�� coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] tempCoordSolo;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Color color;

	/**
	 * Block �� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - 1P�� Block�� ������ GameBoard �Դϴ�.
	 */
	public Block(GameBoard1P gameBoard) {
		this.gameBoard1P = gameBoard;
	}

	/**
	 * Block �� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - 2P�� Block�� ������ GameBoard �Դϴ�.
	 */
	public Block(GameBoard2P gameBoard) {
		this.gameBoard2P = gameBoard;
	}

	/**
	 * Block �� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - SoloPlay�� Block�� ������ GameBoard �Դϴ�.
	 */
	public Block(GameBoardSolo gameBoard) {
		this.gameBoardSolo = gameBoard;
	}

	/** 1P�� Block�� ����� �����մϴ�. */
	public abstract void initShape1P(); // ��ӹ޴� ������ ����

	/** 2P�� Block�� ����� �����մϴ�. */
	public abstract void initShape2P(); // ��ӹ޴� ������ ����

	/** SoloPlay�� Block�� ����� �����մϴ�. */
	public abstract void initShapeSolo(); // ��ӹ޴� ������ ����

	/** 1P�� ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord1P(); // ��ӹ޴� ������ ����

	/** 2P�� ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord2P(); // ��ӹ޴� ������ ����

	/** SoloPlay�� ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoordSolo(); // ��ӹ޴� ������ ����

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
	 * 1P Block �� TopLeftPoint�� ��ȯ�մϴ�.
	 * 
	 * @return 1P�� TopLeftPoint ��ġ�� ��ȯ�մϴ�.
	 */
	public Point getTopLeftPoint() {
		return topLeftPoint1P;
	}

	/**
	 * 2P Block �� TopLeftPoint�� ��ȯ�մϴ�.
	 * 
	 * @return 2P�� TopLeftPoint ��ġ�� ��ȯ�մϴ�.
	 */
	public Point getTopLeftPoint2() {
		return topLeftPoint2P;
	}

	/**
	 * SoloPlay Block �� TopLeftPoint�� ��ȯ�մϴ�.
	 * 
	 * @return SoloPlay�� TopLeftPoint ��ġ�� ��ȯ�մϴ�.
	 */
	public Point getTopLeftPointSolo() {
		return topLeftPointSolo;
	}

	/**
	 * 1P Block �� TopLeftPoint�� �����մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - 1P�� ���� TopLeftPoint�� �����մϴ�.
	 */
	public void setTopLeftPoint1P(Point topLeftPoint) {
		this.topLeftPoint1P = topLeftPoint;
	}

	/**
	 * 2P Block �� TopLeftPoint�� �����մϴ�.
	 * 
	 * @param topLeftPoint2
	 *            - 2P�� ���� TopLeftPoint�� �����մϴ�.
	 */
	public void setTopLeftPoint2P(Point topLeftPoint2) {
		this.topLeftPoint2P = topLeftPoint2;
	}

	/**
	 * SoloPlay Block �� TopLeftPoint�� �����մϴ�.
	 * 
	 * @param topLeftPointSolo
	 *            - SoloPlay�� ���� TopLeftPoint�� �����մϴ�.
	 */
	public void setTopLeftPointSolo(Point topLeftPointSolo) {
		this.topLeftPointSolo = topLeftPointSolo;
	}

	/**
	 * 1P Block �� ȸ���ൿ�ڸ� �����մϴ�.
	 * 
	 * @param spinnable
	 *            1P�� ȸ���ൿ�ڸ� �����մϴ�.
	 */
	public void setSpinBehavior1P(Spinnable spinnable) {
		this.spinnable1P = spinnable;
	}

	/**
	 * 2P Block �� ȸ���ൿ�ڸ� �����մϴ�.
	 * 
	 * @param spinnable
	 *            2P�� ȸ���ൿ�ڸ� �����մϴ�.
	 */
	public void setSpinBehavior2P(Spinnable spinnable) {
		this.spinnable2P = spinnable;
	}

	/**
	 * SoloPlay Block �� ȸ���ൿ�ڸ� �����մϴ�.
	 * 
	 * @param spinnable
	 *            SoloPlay�� ȸ���ൿ�ڸ� �����մϴ�.
	 */
	public void setSpinBehaviorSolo(Spinnable spinnable) {
		this.spinnableSolo = spinnable;
	}

	/** Block�� 1PGameBoard�� �����ϰ�, 1P�� next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock1P() {
		gameBoard1P.fixedAndSetNextBlock();
	}

	/** Block�� 2PGameBoard�� �����ϰ�, 2P�� next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock2P() {
		gameBoard2P.fixedAndSetNextBlock();
	}

	/** Block�� SoloGameBoard�� �����ϰ�, SoloPlay�� next Block�� �����մϴ�. */
	public void fixedAndSetNextBlockSolo() {
		gameBoardSolo.fixedAndSetNextBlock();
	}

	/**
	 * ȸ���� �� ���̳� �ٸ� ������ �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - 1P�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return ȸ���� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionSpin1P(Point topLeftPoint) { // ȸ�����ɿ���
		spinnable1P.spin(tempCoord1P);
		for (int i = 0; i < tempCoord1P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint1P(tempCoord1P[i]);
			if (gameBoard1P.isCollistionSpin(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * ȸ���� �� ���̳� �ٸ� ������ �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - 2P�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return ȸ���� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionSpin2P(Point topLeftPoint) { // ȸ�����ɿ���
		spinnable2P.spin(tempCoord2P);
		for (int i = 0; i < tempCoord2P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint2P(tempCoord2P[i]);
			if (gameBoard2P.isCollistionSpin(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * ȸ���� �� ���̳� �ٸ� ������ �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - SoloPlay�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return ȸ���� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionSpinSolo(Point topLeftPoint) { // ȸ�����ɿ���
		spinnableSolo.spin(tempCoordSolo);
		for (int i = 0; i < tempCoordSolo.length; i++) {
			Point tempNextPointSolo = topLeftPoint.setCurrentPointSolo(tempCoordSolo[i]);
			if (gameBoardSolo.isCollistionSpinSolo(tempNextPointSolo))
				return true;
		}
		return false;
	}

	/**
	 * �̵��� �� ���̳� �ٸ������� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - 1P�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return �̵��� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionMove1P(Point topLeftPoint) {
		for (int i = 0; i < coord1P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint1P(coord1P[i]);
			if (gameBoard1P.isCollision(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * �̵��� �� ���̳� �ٸ������� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - 2P�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return �̵��� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionMove2P(Point topLeftPoint) {
		for (int i = 0; i < coord2P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint2P(coord2P[i]);
			if (gameBoard2P.isCollision(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * �̵��� �� ���̳� �ٸ������� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - SoloPlay�� ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return �̵��� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionMoveSolo(Point topLeftPoint) {
		for (int i = 0; i < coordSolo.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPointSolo(coordSolo[i]);
			if (gameBoardSolo.isCollisionSolo(tempNextPoint))
				return true;
		}
		return false;
	}

	/** 1P Block ȸ���� �����մϴ�. */
	public void performSpin1P() { // ��� �����ϱ�
		gameBoard1P.revertMatrix();
		if (!isCollisionSpin1P(topLeftPoint1P)) {
			spinnable1P.spin(coord1P);
			changeCoord1P();
		} else {
			changeCoord1P();
			for (int i = 0; i < coord1P.length; i++) {
				tempCoord1P[i].setX(coord1P[i].getX());
				tempCoord1P[i].setY(coord1P[i].getY());
			}
		}
	}

	/** 2P Block ȸ���� �����մϴ�. */
	public void performSpin2P() { // ��� �����ϱ�
		gameBoard2P.revertMatrix();
		if (!isCollisionSpin2P(topLeftPoint2P)) {
			spinnable2P.spin(coord2P);
			changeCoord2P();
		} else {
			changeCoord2P();
			for (int i = 0; i < coord2P.length; i++) {
				tempCoord2P[i].setX(coord2P[i].getX());
				tempCoord2P[i].setY(coord2P[i].getY());
			}
		}
	}

	/** SoloPlay Block ȸ���� �����մϴ�. */
	public void performSpinSolo() { // ��� �����ϱ�
		gameBoardSolo.revertMatrix();
		if (!isCollisionSpinSolo(topLeftPointSolo)) {
			spinnableSolo.spin(coordSolo);
			changeCoordSolo();
		} else {
			changeCoordSolo();
			for (int i = 0; i < coordSolo.length; i++) {
				tempCoordSolo[i].setX(coordSolo[i].getX());
				tempCoordSolo[i].setY(coordSolo[i].getY());
			}
		}
	}

	/** 1P Block �� �������� �̵��մϴ�. */
	public void moveLeft1P() {
		tempTopLeftPoint1P.setY(topLeftPoint1P.getY() - 1);
		tempTopLeftPoint1P.setX(topLeftPoint1P.getX());
		gameBoard1P.revertMatrix();
		if (!isCollisionMove1P(tempTopLeftPoint1P)) {
			setTopLeftPoint1P(tempTopLeftPoint1P);
			changeCoord1P();
		} else {
			topLeftPoint1P.setY(tempTopLeftPoint1P.getY() + 1);
			changeCoord1P();
		}
	}

	/** 2P Block �� �������� �̵��մϴ�. */
	public void moveLeft2P() {
		tempTopLeftPoint2P.setY(topLeftPoint2P.getY() - 1);
		tempTopLeftPoint2P.setX(topLeftPoint2P.getX());
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(tempTopLeftPoint2P)) {
			setTopLeftPoint2P(tempTopLeftPoint2P);
			changeCoord2P();
		} else {
			topLeftPoint2P.setY(tempTopLeftPoint2P.getY() + 1);
			changeCoord2P();
		}
	}

	/** SoloPlay Block �� �������� �̵��մϴ�. */
	public void moveLeftSolo() {
		tempTopLeftPointSolo.setY(topLeftPointSolo.getY() - 1);
		tempTopLeftPointSolo.setX(topLeftPointSolo.getX());
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(tempTopLeftPointSolo)) {
			setTopLeftPointSolo(tempTopLeftPointSolo);
			changeCoordSolo();
		} else {
			topLeftPointSolo.setY(tempTopLeftPointSolo.getY() + 1);
			changeCoordSolo();
		}
	}

	/** 1P Block �� ���������� �̵��մϴ�. */
	public void moveRight1P() {
		tempTopLeftPoint1P.setY(topLeftPoint1P.getY() + 1);
		tempTopLeftPoint1P.setX(topLeftPoint1P.getX());
		gameBoard1P.revertMatrix();
		if (!isCollisionMove1P(tempTopLeftPoint1P)) {
			setTopLeftPoint1P(tempTopLeftPoint1P);
			changeCoord1P();
		} else {
			topLeftPoint1P.setY(tempTopLeftPoint1P.getY() - 1);
			changeCoord1P();
		}
	}

	/** 2P Block �� ���������� �̵��մϴ�. */
	public void moveRight2P() {
		tempTopLeftPoint2P.setY(topLeftPoint2P.getY() + 1);
		tempTopLeftPoint2P.setX(topLeftPoint2P.getX());
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(tempTopLeftPoint2P)) {
			setTopLeftPoint2P(tempTopLeftPoint2P);
			changeCoord2P();
		} else {
			topLeftPoint2P.setY(tempTopLeftPoint2P.getY() - 1);
			changeCoord2P();
		}
	}

	/** SoloPlay Block �� ���������� �̵��մϴ�. */
	public void moveRightSolo() {
		tempTopLeftPointSolo.setY(topLeftPointSolo.getY() + 1);
		tempTopLeftPointSolo.setX(topLeftPointSolo.getX());
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(tempTopLeftPointSolo)) {
			setTopLeftPointSolo(tempTopLeftPointSolo);
			changeCoordSolo();
		} else {
			topLeftPointSolo.setY(tempTopLeftPointSolo.getY() - 1);
			changeCoordSolo();
		}
	}

	/** 1P Block �� �Ʒ��� �̵��մϴ�. */
	public void moveDown1P() {
		tempTopLeftPoint1P.setX(topLeftPoint1P.getX() + 1);
		gameBoard1P.revertMatrix();
		if (!isCollisionMove1P(tempTopLeftPoint1P)) {
			setTopLeftPoint1P(tempTopLeftPoint1P);
			changeCoord1P();
		} else {
			topLeftPoint1P.setX(tempTopLeftPoint1P.getX() - 1);
			changeCoord1P();
			fixedAndSetNextBlock1P();
		}
	}

	/** 2P Block �� �Ʒ��� �̵��մϴ�. */
	public void moveDown2P() {
		tempTopLeftPoint2P.setX(topLeftPoint2P.getX() + 1);
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(tempTopLeftPoint2P)) {
			setTopLeftPoint2P(tempTopLeftPoint2P);
			changeCoord2P();
		} else {
			topLeftPoint2P.setX(tempTopLeftPoint2P.getX() - 1);
			changeCoord2P();
			fixedAndSetNextBlock2P();
		}
	}

	/** SoloPlay Block �� �Ʒ��� �̵��մϴ�. */
	public void moveDownSolo() {
		tempTopLeftPointSolo.setX(topLeftPointSolo.getX() + 1);
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(tempTopLeftPointSolo)) {
			setTopLeftPointSolo(tempTopLeftPointSolo);
			changeCoordSolo();
		} else {
			topLeftPointSolo.setX(tempTopLeftPointSolo.getX() - 1);
			changeCoordSolo();
			fixedAndSetNextBlockSolo();
		}
	}

	/**
	 * 1P Block�� �Ʒ��� ��ĭ ���� �� �ִ��� Ȯ���մϴ�.
	 * 
	 * @return �Ʒ��� ��ĭ �̵��� �� �ִٸ� true��, ���ٸ� false�� ��ȯ�մϴ�.
	 */
	public boolean isMoveDown1P() {
		Point x = new Point(topLeftPoint1P.getX() + 1, topLeftPoint1P.getY());
		gameBoard1P.revertMatrix();
		if (!isCollisionMove1P(x))
			return true;
		else
			return false;
	}

	/**
	 * 2P Block�� �Ʒ��� ��ĭ ���� �� �ִ��� Ȯ���մϴ�.
	 * 
	 * @return �Ʒ��� ��ĭ �̵��� �� �ִٸ� true��, ���ٸ� false�� ��ȯ�մϴ�.
	 */
	public boolean isMoveDown2P() {
		Point x = new Point(topLeftPoint2P.getX() + 1, topLeftPoint2P.getY());
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(x))
			return true;
		else
			return false;
	}

	/**
	 * SoloPlay Block�� �Ʒ��� ��ĭ ���� �� �ִ��� Ȯ���մϴ�.
	 * 
	 * @return �Ʒ��� ��ĭ �̵��� �� �ִٸ� true��, ���ٸ� false�� ��ȯ�մϴ�.
	 */
	public boolean isMoveDownSolo() {
		Point x = new Point(topLeftPointSolo.getX() + 1, topLeftPointSolo.getY());
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(x))
			return true;
		else
			return false;
	}

	/** 1P Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown1P() {
		while (isMoveDown1P())
			moveDown1P();
		changeCoord1P();
		fixedAndSetNextBlock1P();
	}

	/** 2P Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown2P() {
		while (isMoveDown2P())
			moveDown2P();
		changeCoord2P();
		fixedAndSetNextBlock2P();
	}

	/** SoloPlay Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDownSolo() {
		while (isMoveDownSolo())
			moveDownSolo();
		changeCoordSolo();
		fixedAndSetNextBlockSolo();
	}

	/** 1P Block �� ������ �ð����� ��ĭ ����Ʈ���ϴ�. */
	public void drop1P() {
		tempTopLeftPoint1P.setX(topLeftPoint1P.getX() + 1);
		gameBoard1P.revertMatrix();
		if (!isCollisionMove1P(tempTopLeftPoint1P)) {
			setTopLeftPoint1P(tempTopLeftPoint1P);
			changeCoord1P();
		} else {
			topLeftPoint1P.setX(tempTopLeftPoint1P.getX() - 1);
			changeCoord1P();
			fixedAndSetNextBlock1P();
		}
		gameBoard1P.update();

	}

	/** 2P Block �� ������ �ð����� ��ĭ ����Ʈ���ϴ�. */
	public void drop2P() {
		tempTopLeftPoint2P.setX(topLeftPoint2P.getX() + 1);
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(tempTopLeftPoint2P)) {
			setTopLeftPoint2P(tempTopLeftPoint2P);
			changeCoord2P();
		} else {
			topLeftPoint2P.setX(tempTopLeftPoint2P.getX() - 1);
			changeCoord2P();
			fixedAndSetNextBlock2P();
		}
		gameBoard2P.update();
	}

	/** SoloPlay Block �� ������ �ð����� ��ĭ ����Ʈ���ϴ�. */
	public void dropSolo() {
		tempTopLeftPointSolo.setX(topLeftPointSolo.getX() + 1);
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(tempTopLeftPointSolo)) {
			setTopLeftPointSolo(tempTopLeftPointSolo);
			changeCoordSolo();
		} else {
			topLeftPointSolo.setX(tempTopLeftPointSolo.getX() - 1);
			changeCoordSolo();
			fixedAndSetNextBlockSolo();
		}
		gameBoardSolo.update();
	}
}
