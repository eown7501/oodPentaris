package model;

import java.awt.Color;

/**
 * 이 Block Class는 블록의 위치, Color, 회전, 이동 이 구현된 Class 입니다.
 * 
 * @author 송민석, 곽소정
 */
public abstract class Block {

	/** 1PGame의 Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnable1P;
	/** 2PGame의 Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnable2P;
	/** SoloPlay의 Spin 행동자 를 담당할 Spinnable Type 의 변수입니다. */
	private Spinnable spinnableSolo;
	/** 1P의 GameBoard를 호출합니다. */
	protected GameBoard1P gameBoard1P;
	/** 2P의 GameBoard를 호출합니다. */
	protected GameBoard2P gameBoard2P;
	/** SoloPlay의 GameBoard를 호출합니다. */
	protected GameBoardSolo gameBoardSolo;
	/** 1P의 Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPoint1P;
	/** 2P의 Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPoint2P;
	/** SoloPlay의 Block의 행동 기준이 될 왼쪽위 위치좌표입니다. */
	protected Point topLeftPointSolo;
	/** 1P의 topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPoint1P;
	/** 2P의 topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPoint2P;
	/** SoloPlay의 topLeftPoint의 값을 임시로 저장할 변수입니다. */
	protected Point tempTopLeftPointSolo;
	/** 1P의 Block의 위치를 저장할 Point Type Array 변수입니다. */
	protected Point[] coord1P;
	/** 2P의 Block의 위치를 저장할 Point Type Array 변수입니다. */
	protected Point[] coord2P;
	/** SoloPlay의 Block의 위치를 저장할 Point Type Array 변수입니다. */
	protected Point[] coordSolo;
	/** 1P의 coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] tempCoord1P;
	/** 2P의 coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] tempCoord2P;
	/** SoloPlay의 coord의 값을 임시로 저장할 변수입니다. */
	protected Point[] tempCoordSolo;
	/** Block 의 색을 담는 변수입니다. */
	protected Color color;

	/**
	 * Block 을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - 1P의 Block이 생성될 GameBoard 입니다.
	 */
	public Block(GameBoard1P gameBoard) {
		this.gameBoard1P = gameBoard;
	}

	/**
	 * Block 을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - 2P의 Block이 생성될 GameBoard 입니다.
	 */
	public Block(GameBoard2P gameBoard) {
		this.gameBoard2P = gameBoard;
	}

	/**
	 * Block 을 생성합니다.
	 * 
	 * @param gameBoard
	 *            - SoloPlay의 Block이 생성될 GameBoard 입니다.
	 */
	public Block(GameBoardSolo gameBoard) {
		this.gameBoardSolo = gameBoard;
	}

	/** 1P의 Block의 모양을 결정합니다. */
	public abstract void initShape1P(); // 상속받는 블럭에서 구현

	/** 2P의 Block의 모양을 결정합니다. */
	public abstract void initShape2P(); // 상속받는 블럭에서 구현

	/** SoloPlay의 Block의 모양을 결정합니다. */
	public abstract void initShapeSolo(); // 상속받는 블럭에서 구현

	/** 1P의 블럭의 위치를 바꿉니다. */
	public abstract void changeCoord1P(); // 상속받는 블럭에서 구현

	/** 2P의 블럭의 위치를 바꿉니다. */
	public abstract void changeCoord2P(); // 상속받는 블럭에서 구현

	/** SoloPlay의 블럭의 위치를 바꿉니다. */
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
	 * 1P Block 의 TopLeftPoint를 반환합니다.
	 * 
	 * @return 1P의 TopLeftPoint 위치를 반환합니다.
	 */
	public Point getTopLeftPoint() {
		return topLeftPoint1P;
	}

	/**
	 * 2P Block 의 TopLeftPoint를 반환합니다.
	 * 
	 * @return 2P의 TopLeftPoint 위치를 반환합니다.
	 */
	public Point getTopLeftPoint2() {
		return topLeftPoint2P;
	}

	/**
	 * SoloPlay Block 의 TopLeftPoint를 반환합니다.
	 * 
	 * @return SoloPlay의 TopLeftPoint 위치를 반환합니다.
	 */
	public Point getTopLeftPointSolo() {
		return topLeftPointSolo;
	}

	/**
	 * 1P Block 의 TopLeftPoint를 설정합니다.
	 * 
	 * @param topLeftPoint
	 *            - 1P의 현재 TopLeftPoint를 설정합니다.
	 */
	public void setTopLeftPoint1P(Point topLeftPoint) {
		this.topLeftPoint1P = topLeftPoint;
	}

	/**
	 * 2P Block 의 TopLeftPoint를 설정합니다.
	 * 
	 * @param topLeftPoint2
	 *            - 2P의 현재 TopLeftPoint를 설정합니다.
	 */
	public void setTopLeftPoint2P(Point topLeftPoint2) {
		this.topLeftPoint2P = topLeftPoint2;
	}

	/**
	 * SoloPlay Block 의 TopLeftPoint를 설정합니다.
	 * 
	 * @param topLeftPointSolo
	 *            - SoloPlay의 현재 TopLeftPoint를 설정합니다.
	 */
	public void setTopLeftPointSolo(Point topLeftPointSolo) {
		this.topLeftPointSolo = topLeftPointSolo;
	}

	/**
	 * 1P Block 의 회전행동자를 설정합니다.
	 * 
	 * @param spinnable
	 *            1P의 회전행동자를 설정합니다.
	 */
	public void setSpinBehavior1P(Spinnable spinnable) {
		this.spinnable1P = spinnable;
	}

	/**
	 * 2P Block 의 회전행동자를 설정합니다.
	 * 
	 * @param spinnable
	 *            2P의 회전행동자를 설정합니다.
	 */
	public void setSpinBehavior2P(Spinnable spinnable) {
		this.spinnable2P = spinnable;
	}

	/**
	 * SoloPlay Block 의 회전행동자를 설정합니다.
	 * 
	 * @param spinnable
	 *            SoloPlay의 회전행동자를 설정합니다.
	 */
	public void setSpinBehaviorSolo(Spinnable spinnable) {
		this.spinnableSolo = spinnable;
	}

	/** Block을 1PGameBoard에 고정하고, 1P의 next Block을 설정합니다. */
	public void fixedAndSetNextBlock1P() {
		gameBoard1P.fixedAndSetNextBlock();
	}

	/** Block을 2PGameBoard에 고정하고, 2P의 next Block을 설정합니다. */
	public void fixedAndSetNextBlock2P() {
		gameBoard2P.fixedAndSetNextBlock();
	}

	/** Block을 SoloGameBoard에 고정하고, SoloPlay의 next Block을 설정합니다. */
	public void fixedAndSetNextBlockSolo() {
		gameBoardSolo.fixedAndSetNextBlock();
	}

	/**
	 * 회전할 때 벽이나 다른 도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - 1P의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 회전할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
	 */
	public boolean isCollisionSpin1P(Point topLeftPoint) { // 회전가능여부
		spinnable1P.spin(tempCoord1P);
		for (int i = 0; i < tempCoord1P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint1P(tempCoord1P[i]);
			if (gameBoard1P.isCollistionSpin(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * 회전할 때 벽이나 다른 도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - 2P의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 회전할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
	 */
	public boolean isCollisionSpin2P(Point topLeftPoint) { // 회전가능여부
		spinnable2P.spin(tempCoord2P);
		for (int i = 0; i < tempCoord2P.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPoint2P(tempCoord2P[i]);
			if (gameBoard2P.isCollistionSpin(tempNextPoint))
				return true;
		}
		return false;
	}

	/**
	 * 회전할 때 벽이나 다른 도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - SoloPlay의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 회전할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
	 */
	public boolean isCollisionSpinSolo(Point topLeftPoint) { // 회전가능여부
		spinnableSolo.spin(tempCoordSolo);
		for (int i = 0; i < tempCoordSolo.length; i++) {
			Point tempNextPointSolo = topLeftPoint.setCurrentPointSolo(tempCoordSolo[i]);
			if (gameBoardSolo.isCollistionSpinSolo(tempNextPointSolo))
				return true;
		}
		return false;
	}

	/**
	 * 이동할 때 벽이나 다른도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - 1P의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 이동할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
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
	 * 이동할 때 벽이나 다른도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - 2P의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 이동할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
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
	 * 이동할 때 벽이나 다른도형에 충돌하는지 확인합니다.
	 * 
	 * @param topLeftPoint
	 *            - SoloPlay의 도형이 회전할때 기준이 되는 좌표입니다.
	 * @return 이동할 때 충돌하면 true를, 충돌하지않으면 false를 반환합니다.
	 */
	public boolean isCollisionMoveSolo(Point topLeftPoint) {
		for (int i = 0; i < coordSolo.length; i++) {
			Point tempNextPoint = topLeftPoint.setCurrentPointSolo(coordSolo[i]);
			if (gameBoardSolo.isCollisionSolo(tempNextPoint))
				return true;
		}
		return false;
	}

	/** 1P Block 회전을 실행합니다. */
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

	/** 2P Block 회전을 실행합니다. */
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

	/** SoloPlay Block 회전을 실행합니다. */
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

	/** 1P Block 을 왼쪽으로 이동합니다. */
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

	/** 2P Block 을 왼쪽으로 이동합니다. */
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

	/** SoloPlay Block 을 왼쪽으로 이동합니다. */
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

	/** 1P Block 을 오른쪽으로 이동합니다. */
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

	/** 2P Block 을 오른쪽으로 이동합니다. */
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

	/** SoloPlay Block 을 오른쪽으로 이동합니다. */
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

	/** 1P Block 을 아래로 이동합니다. */
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

	/** 2P Block 을 아래로 이동합니다. */
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

	/** SoloPlay Block 을 아래로 이동합니다. */
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
	 * 1P Block을 아래로 한칸 내릴 수 있는지 확인합니다.
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

	/**
	 * 2P Block을 아래로 한칸 내릴 수 있는지 확인합니다.
	 * 
	 * @return 아래로 한칸 이동할 수 있다면 true를, 없다면 false를 반환합니다.
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
	 * SoloPlay Block을 아래로 한칸 내릴 수 있는지 확인합니다.
	 * 
	 * @return 아래로 한칸 이동할 수 있다면 true를, 없다면 false를 반환합니다.
	 */
	public boolean isMoveDownSolo() {
		Point x = new Point(topLeftPointSolo.getX() + 1, topLeftPointSolo.getY());
		gameBoardSolo.revertMatrix();
		if (!isCollisionMoveSolo(x))
			return true;
		else
			return false;
	}

	/** 1P Block 을 바로 떨어트립니다. */
	public void fastDown1P() {
		while (isMoveDown1P())
			moveDown1P();
		changeCoord1P();
		fixedAndSetNextBlock1P();
	}

	/** 2P Block 을 바로 떨어트립니다. */
	public void fastDown2P() {
		while (isMoveDown2P())
			moveDown2P();
		changeCoord2P();
		fixedAndSetNextBlock2P();
	}

	/** SoloPlay Block 을 바로 떨어트립니다. */
	public void fastDownSolo() {
		while (isMoveDownSolo())
			moveDownSolo();
		changeCoordSolo();
		fixedAndSetNextBlockSolo();
	}

	/** 1P Block 을 스레드 시간따라 한칸 떨어트립니다. */
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

	/** 2P Block 을 스레드 시간따라 한칸 떨어트립니다. */
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

	/** SoloPlay Block 을 스레드 시간따라 한칸 떨어트립니다. */
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
