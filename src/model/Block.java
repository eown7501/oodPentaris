package model;

import java.awt.Color;

/**
 * 이 Block Class는 블록의 위치, Color, 회전, 이동 이 구현된 Class 입니다.
 * 
 * @author 곽소정
 */
public abstract class Block {

	/** Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnable1P;
	/** Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnable2P;
	/** Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnableSolo;
	/** Block이 올라갈 GameBoardSolo Type 의 변수입니다. */
	protected GameBoard1P gameBoard1P;
	/** Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected GameBoard2P gameBoard2P;
	protected GameBoardSolo gameBoardSolo;
	/** Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPoint1P;
	/** Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPoint2P;
	/** Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPointSolo;
	/** topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPoint1P;
	/** topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPoint2P;
	/** topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPointSolo;
	/** Block의 위치를 저장할 Point Type Array 변수입니다. */
	protected Point[] coord1P;
	/** coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] coord2P;
	/** coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] coordSolo;
	/** coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] tempCoord1P;
	/** Block 의 색을 담는 변수입니다. */
	protected Point[] tempCoord2P;
	/** Block 의 색을 담는 변수입니다. */
	protected Point[] tempCoordSolo;
	/** Block 의 색을 담는 변수입니다. */
	protected Color color;

	/**
	 * Block 을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - Block이 생성될 GameBoard 입니다.
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

	/** Block의 모양을 결정합니다. */
	public abstract void initShape1P(); // 상속받는 블럭에서 구현

	public abstract void initShape2P(); // 상속받는 블럭에서 구현

	public abstract void initShapeSolo(); // 상속받는 블럭에서 구현
	// public abstract void initShapesolo(); // 상속받는 블럭에서 구현

	/** 블럭의 위치를 바꿉니다. */
	public abstract void changeCoord1P(); // 상속받는 블럭에서 구현

	/** 블럭의 위치를 바꿉니다. */
	public abstract void changeCoord2P(); // 상속받는 블럭에서 구현

	/** 블럭의 위치를 바꿉니다. */
	public abstract void changeCoordSolo(); // 상속받는 블럭에서 구현

	/**
	 * Block의 Color를 반환합니다.
	 * 
	 * @return Block의 Color 입니다.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Block의 Color를 설정합니다.
	 * 
	 * @param color
	 *            - Block의 Color로 설정될 Color 객체 입니다.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Block 의 TopLeftPoint를 반환합니다.
	 * 
	 * @return TopLeftPoint의 위치 입니다.
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
	 * Block 의 TopLeftPoint를 설정합니다.
	 * 
	 * @param topLeftPoint
	 *            - 로 현재 TopLeftPoint를 설정합니다.
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
	 * Block 의 회전행동자를 설정합니다.
	 * 
	 * @param spinnable
	 *            - 로 회전행동자를 설정합니다.
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

	/** Block GameBoard에 고정하고, next Block을 설정합니다. */
	public void fixedAndSetNextBlock1P() {
		gameBoard1P.fixedAndSetNextBlock1P();
	}

	/** Block GameBoard에 고정하고, next Block을 설정합니다. */
	public void fixedAndSetNextBlock2P() {
		gameBoard2P.fixedAndSetNextBlock2P();
	}

	public void fixedAndSetNextBlockSolo() {
		gameBoardSolo.fixedAndSetNextBlock();
	}

	/**
	 * 회전할 때 벽이나 다른 도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint1P
	 *            - 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 회전할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
	 */
	public boolean isCollisionSpin1P(Point topLeftPoint1P) { // 회전가능여부
		spinnable1P.spin(tempCoord1P);
		for (int i = 0; i < tempCoord1P.length; i++) {
			Point tempNextPoint1P = topLeftPoint1P.setCurrentPoint1P(tempCoord1P[i]);
			if (gameBoard1P.isCollistionSpin1P(tempNextPoint1P))
				return true;
		}
		return false;
	}

	public boolean isCollisionSpin2P(Point topLeftPoint2P) { // 회전가능여부
		spinnable2P.spin(tempCoord2P);
		for (int i = 0; i < tempCoord2P.length; i++) {
			Point tempNextPoint2P = topLeftPoint2P.setCurrentPoint2P(tempCoord2P[i]);
			if (gameBoard2P.isCollistionSpin2P(tempNextPoint2P))
				return true;
		}
		return false;
	}

	public boolean isCollisionSpinSolo(Point topLeftPointSolo) { // 회전가능여부
		spinnableSolo.spin(tempCoordSolo);
		for (int i = 0; i < tempCoordSolo.length; i++) {
			Point tempNextPointSolo = topLeftPointSolo.setCurrentPointSolo(tempCoordSolo[i]);
			if (gameBoardSolo.isCollistionSpinSolo(tempNextPointSolo))
				return true;
		}
		return false;
	}

	/**
	 * 이동할 때 벽이나 다른도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint1P
	 *            - 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 이동할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
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

	/** Block 회전을 실행합니다. */
	public void performSpin1P() { // 블록 스핀하기
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

	public void performSpin2P() { // 블록 스핀하기
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

	public void performSpinSolo() { // 블록 스핀하기
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

	/** Block 을 왼쪽으로 이동합니다. */
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

	/** Block 을 오른쪽으로 이동합니다. */
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

	/** Block 을 아래로 이동합니다. */
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
	 * Block 아래로 한칸 내릴 수 있는지 확인합니다.
	 * 
	 * @return 아래로 한칸 이동할 수 있다면 true를, 없다면 false를 반환합니다.
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

	/** Block 을 바로 떨어트립니다. */
	public void fastDown1P() {
		while (isMoveDown1P())
			moveDown1P();
		changeCoord1P();
		fixedAndSetNextBlock1P();
	}

	/** Block 을 바로 떨어트립니다. */
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

	/** Block 을 한칸 떨어트립니다. */
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
