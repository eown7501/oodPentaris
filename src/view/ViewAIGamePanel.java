package view;

import javax.swing.*;
import java.awt.*;
/**
 * �� ViewSoloGamePanel Ŭ������ SoloGameȭ���� Panel�� �����ϰ� �����ִ� Ŭ�����Դϴ�.
 * 
 * @author �Ž���
 */
public class ViewAIGamePanel extends JPanel {

	/** ViewTotalFrame Type�� ���� �Դϴ�. */
	private ViewTotalFrame totalFrame;

	/**
	 * ViewAIGamePanel�� �����մϴ�.
	 * 
	 * @param totalFrame
	 *            - ����� ���޹��� totalFrame �Դϴ�.
	 */
	public ViewAIGamePanel(ViewTotalFrame totalFrame) {
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
		totalFrame.drawAI(g);
	}

	/**
	 *  Game�� �������� GameOver �޽����� ǥ�� �մϴ�.
	 * @param gameMode - � �÷��̾ �̱�� �������� Ȯ���� ���� �Դϴ�.
	 */
	public void gameOver(int gameMode) {
		if(gameMode == 3) {
			Graphics2D g2 = (Graphics2D) getGraphics();
			g2.setFont(new Font("Chiller", Font.BOLD, 110));
			g2.setColor(new Color(250, 0, 0, 250));
			g2.drawString("WIN!!", 320, 240);
			totalFrame.showAIRankingRegisterPanel();
		}
		else {
			Graphics2D g2 = (Graphics2D) getGraphics();
			g2.setFont(new Font("Chiller", Font.BOLD, 110));
			g2.setColor(new Color(250, 0, 0, 250));
			g2.drawString("LOSE", 320, 240);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			totalFrame.showMainPanel();
		}

	}
}
