package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * 이 Class는 2PGameMode화면의 Panel을 구성하고 보여주는 클래스입니다.
 * 
 * @author 송민석
 */
public class View2PAndAIGamePanel extends JPanel {

	/** ViewTotalFrame Type의 변수 입니다. */
	private ViewTotalFrame totalFrame;

	/** View2PAndAIGamePanel을 생성합니다. */
	public View2PAndAIGamePanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}

	/** 초기값 설정을 합니다. */
	public void init() {
		setLayout(null);
		setBackground(new Color(66, 66, 66, 160));
		setVisible(true);
	}

	/** 스윙 컴포넌트가 자신의 모양을 그립니다. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		totalFrame.draw(g);
		totalFrame.draw2(g);

	}

	public void update() {
		repaint();
	}
	/** 2PAndAI가 종료되었을시 win 메시지를 표시합니다. */
	public void win() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setFont(new Font("Chiller", Font.BOLD, 110));
		g2.setColor(new Color(250, 0, 0, 250));
		g2.drawString("Game Over", 320, 240);
	}

	/** 2PAndAI가 종료되었을시 lose 메시지를 표시합니다. */
	public void lose() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setFont(new Font("Chiller", Font.BOLD, 110));
		g2.setColor(new Color(250, 0, 0, 250));
		g2.drawString("Game Over", 320, 240);
	}
}
