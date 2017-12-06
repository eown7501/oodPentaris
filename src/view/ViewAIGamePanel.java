package view;

import javax.swing.*;
import java.awt.*;
/**
 * 이 ViewSoloGamePanel 클래스는 SoloGame화면의 Panel을 구성하고 보여주는 클래스입니다.
 * 
 * @author 신승현
 */
public class ViewAIGamePanel extends JPanel {

	/** ViewTotalFrame Type의 변수 입니다. */
	private ViewTotalFrame totalFrame;

	/**
	 * ViewAIGamePanel을 생성합니다.
	 * 
	 * @param totalFrame
	 *            - 명령을 전달받을 totalFrame 입니다.
	 */
	public ViewAIGamePanel(ViewTotalFrame totalFrame) {
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
		totalFrame.drawAI(g);
	}

	/**
	 *  Game이 끝났을시 GameOver 메시지를 표시 합니다.
	 * @param gameMode - 어떤 플레이어가 이기고 졌는지를 확인할 변수 입니다.
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
