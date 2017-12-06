package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * �� Class�� 2PGameȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author �۹μ�
 */
public class View2PGamePanel extends JPanel {

	/** ViewTotalFrame Type�� ���� �Դϴ�. */
	private ViewTotalFrame totalFrame;

	/**
	 * View2PGamePanel�� �����մϴ�.
	 * 
	 * @param totalFrame
	 *            ViewTotalFrame Type�� �Ű����� �Դϴ�.
	 */
	public View2PGamePanel(ViewTotalFrame totalFrame) {
		this.totalFrame = totalFrame;
		init();
	}

	/** �ʱⰪ ������ �մϴ�. */
	public void init() {
		setLayout(null);
		setBackground(new Color(66, 66, 66, 160));
		setVisible(true);
	}

	/** ���� ������Ʈ�� �ڽ��� ����� �׸��ϴ�. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		totalFrame.draw(g);
		totalFrame.draw2P(g);

	}

	/** ȭ���� repaint �մϴ�. */
	public void update() {
		repaint();
	}

	/**
	 * 2P �÷��̰� ����Ǿ����� lose�� win �޽����� ǥ���մϴ�.
	 * 
	 * @param player
	 *            1P �� 2P �� ��Ÿ���� Win Lose�� �����մϴ�.
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
