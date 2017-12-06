package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * 이 Class는 2PGame화면의 Panel을 구성하고 보여주는 클래스입니다.
 * 
 * @author 송민석
 */
public class View2PGamePanel extends JPanel {

	/** ViewTotalFrame Type의 변수 입니다. */
	private ViewTotalFrame totalFrame;

	/**
	 * View2PGamePanel을 생성합니다.
	 * 
	 * @param totalFrame
	 *            ViewTotalFrame Type의 매개변수 입니다.
	 */
	public View2PGamePanel(ViewTotalFrame totalFrame) {
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
		totalFrame.draw2P(g);

	}

	/** 화면을 repaint 합니다. */
	public void update() {
		repaint();
	}

	/**
	 * 2P 플레이가 종료되었을시 lose와 win 메시지를 표시합니다.
	 * 
	 * @param player
	 *            1P 와 2P 를 나타내며 Win Lose를 구분합니다.
	 */
	public void lose(int player) {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setFont(new Font("Chiller", Font.BOLD, 110));
		g2.setColor(new Color(250, 0, 0, 250));
		if (player == 1) {
			g2.drawString("Lose", 620, 240);
			g2.drawString("WIN!!", 20, 240);
		} else {
			g2.drawString("Lose", 20, 240);
			g2.drawString("WIN!!", 620, 240);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		totalFrame.showMainPanel();
	}
}
