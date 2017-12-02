package model;

import java.awt.Color;

/**
 * �� Block Class�� ����� ��ġ, Color, ȸ��, �̵� �� ������ Class �Դϴ�.
 * 
 * @author ������
 */
public abstract class Block {

	/** Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable1P;
	/** Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnable2P;
	/** Spin �ൿ�� �� ����� Spinnable Type �� �����Դϴ�. */
	private Spinnable spinnableSolo;
	/** Block�� �ö� GameBoardSolo Type �� �����Դϴ�. */
	protected GameBoard1P gameBoard1P;
	/** Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected GameBoard2P gameBoard2P;
	protected GameBoardSolo gameBoardSolo;
	/** Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPoint1P;
	/** Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPoint2P;
	/** Block�� �ൿ ������ �� ������ ��ġ��ǥ�Դϴ�. */
	protected Point topLeftPointSolo;
	/** topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPoint1P;
	/** topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPoint2P;
	/** topLeftPoint�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point tempTopLeftPointSolo;
	/** Block�� ��ġ�� ������ Point Type Array �����Դϴ�. */
	protected Point[] coord1P;
	/** coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] coord2P;
	/** coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] coordSolo;
	/** coord�� ���� �ӽ÷� ������ �����Դϴ�. */
	protected Point[] tempCoord1P;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Point[] tempCoord2P;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Point[] tempCoordSolo;
	/** Block �� ���� ��� �����Դϴ�. */
	protected Color color;

	/**
	 * Block �� �����մϴ�.
	 * 
	 * @param gameBoard
	 *            - Block�� ������ GameBoard �Դϴ�.
	 */
	public Block(GameBoard1P gameBoard) {
		this.gameBoard1P = gameBoard;
	}

	public Block(GameBoard2P gameBoard2P) {
		this.gameBoard2P = gameBoard2P;
	}

	public Block(GameBoardSolo gameBoardSolo) {
		this.gameBoardSolo = gameBoardSolo;
	}

	/** Block�� ����� �����մϴ�. */
	public abstract void initShape1P(); // ��ӹ޴� ������ ����

	public abstract void initShape2P(); // ��ӹ޴� ������ ����

	public abstract void initShapeSolo(); // ��ӹ޴� ������ ����
	// public abstract void initShapesolo(); // ��ӹ޴� ������ ����

	/** ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord1P(); // ��ӹ޴� ������ ����

	/** ���� ��ġ�� �ٲߴϴ�. */
	public abstract void changeCoord2P(); // ��ӹ޴� ������ ����

	/** ���� ��ġ�� �ٲߴϴ�. */
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
	 * Block �� TopLeftPoint�� ��ȯ�մϴ�.
	 * 
	 * @return TopLeftPoint�� ��ġ �Դϴ�.
	 */
	public Point getTopLeftPoint() {
		return topLeftPoint1P;
	}

	public Point getTopLeftPoint2() {
		return topLeftPoint2P;
	}

	public Point getTopLeftPointSolo() {
		return topLeftPointSolo;
	}

	/**
	 * Block �� TopLeftPoint�� �����մϴ�.
	 * 
	 * @param topLeftPoint
	 *            - �� ���� TopLeftPoint�� �����մϴ�.
	 */
	public void setTopLeftPoint1P(Point topLeftPoint) {
		this.topLeftPoint1P = topLeftPoint;
	}

	public void setTopLeftPoint2P(Point topLeftPoint2) {
		this.topLeftPoint2P = topLeftPoint2;
	}

	public void setTopLeftPointSolo(Point topLeftPointSolo) {
		this.topLeftPointSolo = topLeftPointSolo;
	}

	/**
	 * Block �� ȸ���ൿ�ڸ� �����մϴ�.
	 * 
	 * @param spinnable
	 *            - �� ȸ���ൿ�ڸ� �����մϴ�.
	 */
	public void setSpinBehavior1P(Spinnable spinnable) {
		this.spinnable1P = spinnable;
	}

	public void setSpinBehavior2P(Spinnable spinnable2) {
		this.spinnable2P = spinnable2;
	}

	public void setSpinBehaviorSolo(Spinnable spinnableSolo) {
		this.spinnableSolo = spinnableSolo;
	}

	/** Block GameBoard�� �����ϰ�, next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock1P() {
		gameBoard1P.fixedAndSetNextBlock1P();
	}

	/** Block GameBoard�� �����ϰ�, next Block�� �����մϴ�. */
	public void fixedAndSetNextBlock2P() {
		gameBoard2P.fixedAndSetNextBlock2P();
	}

	public void fixedAndSetNextBlockSolo() {
		gameBoardSolo.fixedAndSetNextBlock();
	}

	/**
	 * ȸ���� �� ���̳� �ٸ� ������ �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint1P
	 *            - ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return ȸ���� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionSpin1P(Point topLeftPoint1P) { // ȸ�����ɿ���
		spinnable1P.spin(tempCoord1P);
		for (int i = 0; i < tempCoord1P.length; i++) {
			Point tempNextPoint1P = topLeftPoint1P.setCurrentPoint1P(tempCoord1P[i]);
			if (gameBoard1P.isCollistionSpin1P(tempNextPoint1P))
				return true;
		}
		return false;
	}

	public boolean isCollisionSpin2P(Point topLeftPoint2P) { // ȸ�����ɿ���
		spinnable2P.spin(tempCoord2P);
		for (int i = 0; i < tempCoord2P.length; i++) {
			Point tempNextPoint2P = topLeftPoint2P.setCurrentPoint2P(tempCoord2P[i]);
			if (gameBoard2P.isCollistionSpin2P(tempNextPoint2P))
				return true;
		}
		return false;
	}

	public boolean isCollisionSpinSolo(Point topLeftPointSolo) { // ȸ�����ɿ���
		spinnableSolo.spin(tempCoordSolo);
		for (int i = 0; i < tempCoordSolo.length; i++) {
			Point tempNextPointSolo = topLeftPointSolo.setCurrentPointSolo(tempCoordSolo[i]);
			if (gameBoardSolo.isCollistionSpinSolo(tempNextPointSolo))
				return true;
		}
		return false;
	}

	/**
	 * �̵��� �� ���̳� �ٸ������� �浹�ϴ��� Ȯ���մϴ�.
	 * 
	 * @param topLeftPoint1P
	 *            - ������ ȸ���Ҷ� ������ �Ǵ� ��ǥ�Դϴ�.
	 * @return �̵��� �� �浹�ϸ� true��, �浹���������� false�� ��ȯ�մϴ�.
	 */
	public boolean isCollisionMove1P(Point topLeftPoint1P) {
		for (int i = 0; i < coord1P.length; i++) {
			Point tempNextPoint1P = topLeftPoint1P.setCurrentPoint1P(coord1P[i]);
			if (gameBoard1P.isCollision1P(tempNextPoint1P))
				return true;
		}
		return false;
	}

	public boolean isCollisionMove2P(Point topLeftPoint2P) {
		for (int i = 0; i < coord2P.length; i++) {
			Point tempNextPoint2P = topLeftPoint2P.setCurrentPoint2P(coord2P[i]);
			if (gameBoard2P.isCollision2P(tempNextPoint2P))
				return true;
		}
		return false;
	}

	public boolean isCollisionMoveSolo(Point topLeftPointSolo) {
		for (int i = 0; i < coordSolo.length; i++) {
			Point tempNextPointSolo = topLeftPointSolo.setCurrentPointSolo(coordSolo[i]);
			if (gameBoardSolo.isCollisionSolo(tempNextPointSolo))
				return true;
		}
		return false;
	}

	/** Block ȸ���� �����մϴ�. */
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

	/** Block �� �������� �̵��մϴ�. */
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

	/** Block �� ���������� �̵��մϴ�. */
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

	/** Block �� �Ʒ��� �̵��մϴ�. */
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
	 * Block �Ʒ��� ��ĭ ���� �� �ִ��� Ȯ���մϴ�.
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

	public boolean isMoveDown2P() {
		Point x = new Point(topLeftPoint2P.getX() + 1, topLeftPoint2P.getY());
		gameBoard2P.revertMatrix();
		if (!isCollisionMove2P(x))
			return true;
		else
			return false;
	}

	public boolean isMoveDownSolo() {
		Point x = new Point(topLeftPointSolo.getX() + 1, topLeftPointSolo.getY());
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(x))
			return true;
		else
			return false;
	}

	/** Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown1P() {
		while (isMoveDown1P())
			moveDown1P();
		changeCoord1P();
		fixedAndSetNextBlock1P();
	}

	/** Block �� �ٷ� ����Ʈ���ϴ�. */
	public void fastDown2P() {
		while (isMoveDown2P())
			moveDown2P();
		changeCoord2P();
		fixedAndSetNextBlock2P();
	}

	public void fastDownSolo() {
		while (isMoveDownSolo())
			moveDownSolo();
		changeCoordSolo();
		fixedAndSetNextBlockSolo();
	}

	/** Block �� ��ĭ ����Ʈ���ϴ�. */
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
