package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * �� Class�� 2PGameModeȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author �۹μ�
 */
public class View2PAndAIGamePanel extends JPanel {

	/** ViewTotalFrame Type�� ���� �Դϴ�. */
	private ViewTotalFrame totalFrame;

	/** View2PAndAIGamePanel�� �����մϴ�. */
	public View2PAndAIGamePanel(ViewTotalFrame totalFrame) {
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
		totalFrame.draw2(g);

	}

	public void update() {
		repaint();
	}
	/** 2PAndAI�� ����Ǿ����� win �޽����� ǥ���մϴ�. */
	public void win() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setFont(new Font("Chiller", Font.BOLD, 110));
		g2.setColor(new Color(250, 0, 0, 250));
		g2.drawString("Game Over", 320, 240);
	}

	/** 2PAndAI�� ����Ǿ����� lose �޽����� ǥ���մϴ�. */
	public void lose() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setFont(new Font("Chiller", Font.BOLD, 110));
		g2.setColor(new Color(250, 0, 0, 250));
		g2.drawString("Game Over", 320, 240);
	}
}
